package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.repo.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

import static org.hibernate.annotations.QueryHints.CACHEABLE;

public interface UserRepo extends BaseRepo<Long, User> {
	@QueryHints(value = @QueryHint(name = CACHEABLE, value = "true"))
	@Query("select u from User u")
	@Override
	Page<User> findAllElements(Pageable pageable);

	@QueryHints(value = @QueryHint(name = CACHEABLE, value = "true"))
	List<User> findByNameIgnoringCaseContaining(String name);
}
