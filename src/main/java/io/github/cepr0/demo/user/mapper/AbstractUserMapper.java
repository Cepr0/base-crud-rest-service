package io.github.cepr0.demo.user.mapper;

import io.github.cepr0.demo.dictionary.group.GroupRepo;
import io.github.cepr0.demo.dictionary.role.RoleRepo;
import io.github.cepr0.demo.user.User;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

public abstract class AbstractUserMapper implements UserMapper {

	@Autowired @Qualifier("delegate") private UserMapper delegate;
	@Autowired private GroupRepo groupRepo;
	@Autowired private RoleRepo roleRepo;

	@Override
	public User fromCreateRequest(UserCreateRequest request) {
		User user = delegate.fromCreateRequest(request);
		user.setGroups(toElements(request.getGroupIds(), groupRepo));
		user.setRoles(toElements(request.getRoleIds(), roleRepo));
		return user;
	}

	@Override
	public User fromUpdateRequest(User element, UserUpdateRequest request) {
		User user = delegate.fromUpdateRequest(element, request);

		Set<String> groupIds = request.getGroupIds();
		if (groupIds != null && !groupIds.isEmpty()) {
			user.setGroups(toElements(groupIds, groupRepo));
		}

		Set<String> roleIds = request.getRoleIds();
		if (roleIds != null && !roleIds.isEmpty()) {
			user.setRoles(toElements(roleIds, roleRepo));
		}

		return user;
	}

	@Override
	public UserResponse toResponse(User element) {
		UserResponse response = delegate.toResponse(element);
		response.setGroupIds(toIds(element.getGroups()));
		response.setRoleIds(toIds(element.getRoles()));
		return response;
	}
}