package io.github.cepr0.demo.user.mapper;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.user.User;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@DecoratedWith(AbstractUserMapper.class)
public interface UserMapper extends BaseMapper<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {
}
