package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.dictionary.group.GroupRepo;
import io.github.cepr0.demo.dictionary.role.RoleRepo;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Optional.ofNullable;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UserMapper implements BaseMapper<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {

	@Autowired private GroupRepo groupRepo;
	@Autowired private RoleRepo roleRepo;

	@AfterMapping
	void fillRefs(UserCreateRequest request, @MappingTarget User user) {
		user.setGroups(toRefSet(request.getGroupIds(), groupRepo));
		user.setRoles(toRefSet(request.getRoleIds(), roleRepo));
	}

	@AfterMapping
	void fillRefs(UserUpdateRequest request, @MappingTarget User user) {
		ofNullable(request.getGroupIds()).ifPresent(ids -> user.setGroups(toRefSet(ids, groupRepo)));
		ofNullable(request.getRoleIds()).ifPresent(ids -> user.setRoles(toRefSet(ids, roleRepo)));
	}

	@AfterMapping
	void fillIds(User user, @MappingTarget UserResponse response) {
		response.setGroupIds(toRefIdSet(user.getGroups()));
		response.setRoleIds(toRefIdSet(user.getRoles()));
	}
}
