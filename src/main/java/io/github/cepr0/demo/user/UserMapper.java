package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.dictionary.group.GroupMapper;
import io.github.cepr0.demo.dictionary.role.RoleMapper;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", nullValueCheckStrategy = ALWAYS, uses = {GroupMapper.class, RoleMapper.class})
public abstract class UserMapper implements BaseMapper<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {
}
