## Base CRUD REST service

This Spring Boot service implements base CRUD operations and try to provide these operations for your entities in declarative way.

Implemented operations:

1. Create
2. Update
3. Delete
4. Get one
5. Get all  

For example:

```http request
POST /users
PATCH /users/1
DELETE /users/1
GET /users/1
GET /users
```

To use these operations with your entity you have perform the following steps:

1. Inherit your entity from `LongIdEntity` (or first create your own base entity - see `LongIdEntity` as example):

    ```java
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "users")
    @DynamicInsert
    @DynamicUpdate
    @Cache(usage = READ_WRITE, region = "user")
    public class User extends LongIdEntity {
    
        @Column(nullable = false, length = 32)
        private String name;
    }
    ```
2. Create three DTOs: 'create request', 'update request' and 'response', 
based on `CreateRequest`, `UpdateRequest` and `BaseResponse<ID>` respectively:

    ```java
    @Data
    @EqualsAndHashCode(callSuper = false)
    public class UserCreateRequest extends CreateRequest {
        @NotBlank private String name;
    }
    
    @Data
    @EqualsAndHashCode(callSuper = false)
    public class UserUpdateRequest extends UpdateRequest {
        private String name;
    }
    
    @Getter
    @Setter
    public class UserResponse extends BaseResponse<Long> {
        private String name;
    }
    ```
            
3. Create a repository for your entity, based on `BaseRepo<ID, T>`

    ```java
    public interface UserRepo extends BaseRepo<Long, User> {
    }
    ```

4. Create a mapper, based on `BaseMapper`,  which will perform mapping between your entity and DTOs:

    ```java
    @Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract class UserMapper implements BaseMapper<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {
    }
    ``` 

5. Create a service for your entity. based on `AbstractBaseService`:

    ```java
    @Service
    public class UserService extends AbstractBaseService<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {
    
        public UserService(UserRepo repo, UserMapper mapper) {
            super(repo, mapper);
        }
    }
    ```
6. And create a REST controller, based on `BaseController`:

    ```java
    @RestController
    @RequestMapping("users")
    public class UserController extends BaseController<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {
    
        public UserController(UserService service) {
            super(service);
        }
    
        @PostMapping
        @Override
        protected ResponseEntity<?> create(@Valid @RequestBody UserCreateRequest request) {
            return super.create(request);
        }
    
        @PatchMapping("/{id}")
        @Override
        protected ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateRequest request) {
            return super.update(id, request);
        }
    
        @DeleteMapping("/{id}")
        @Override
        protected ResponseEntity<?> delete(@PathVariable("id") Long id) {
            return super.delete(id);
        }
    
        @GetMapping
        @Override
        protected ResponseEntity<?> getAll(Pageable pageable) {
            return super.getAll(pageable);
        }
    
        @GetMapping("/{id}")
        @Override
        protected ResponseEntity<?> getOne(@PathVariable("id") Long id) {
            return super.getOne(id);
        }
    }
    ```

Then you will be able to perform all CRUD operations with your entity, for example:

```http request
GET /users/1
```     
```json
{
  "name": "user1"
}
```

You can implement more complex entities, which have associations with over ones - see package `io.github.cepr0.demo.user` as example.
To reduce a pressure to the database, the project uses **Ehcache 3** as _Hibernate 2nd level cache_. 
You can add respective entries to the 'resources/ehcache.xml' file for your entities.

Project uses **MapStruct** to generate mappers code automatically. 
But for complex entities you can make additional codding (see package `io.github.cepr0.demo.user` as example). 

Project uses **log4jdbc** to log JDBC queries and their results 
(see 'pom.xml' for 'log4jdbc-spring-boot-starter' dependency and corresponding settings in the 'resources/application.yml').
It also logs Hibernate statistic which you can turn off in 'resources/application.yml'.

Project uses **H2** database. You can replace it to another RDBMS - the project does not use specific SQL dialect, only **Spring Data JPA** query methods.  

Project uses Java 11.    