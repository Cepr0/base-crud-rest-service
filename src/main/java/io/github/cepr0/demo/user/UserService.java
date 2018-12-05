package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.service.AbstractBaseService;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractBaseService<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {

	public UserService(UserRepo repo, UserMapper mapper) {
		super(repo, mapper);
	}
}
