package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.base.model.BaseElement;
import io.github.cepr0.demo.base.repo.BaseRepo;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@DecoratedWith(AbstractUserMapper.class)
public interface UserMapper extends BaseMapper<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {

	default <ID extends Serializable, T extends BaseElement<ID>> List<T> toElements(Collection<ID> ids, BaseRepo<ID, T> repo) {
		return ids.stream()
				.map(repo::getOne)
				.collect(Collectors.toList());
	}

	default <ID extends Serializable, T extends BaseElement<ID>> List<ID> toIds(Collection<T> elements) {
		return elements.stream()
				.map(BaseElement::getId)
				.collect(Collectors.toList());
	}
}
