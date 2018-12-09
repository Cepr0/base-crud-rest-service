package io.github.cepr0.demo.user.mapper;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.base.model.BaseElement;
import io.github.cepr0.demo.base.repo.BaseRepo;
import io.github.cepr0.demo.user.User;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@DecoratedWith(AbstractUserMapper.class)
public interface UserMapper extends BaseMapper<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {

	default <ID extends Serializable, T extends BaseElement<ID>> Set<T> toElements(@NonNull Collection<ID> ids, @NonNull BaseRepo<ID, T> repo) {
		return ids.stream()
				.map(repo::getOne)
				.collect(Collectors.toSet());
	}

	default <ID extends Serializable, T extends BaseElement<ID>> Set<ID> toIds(@NonNull Collection<T> elements) {
		return elements.stream()
				.map(BaseElement::getId)
				.collect(Collectors.toSet());
	}
}
