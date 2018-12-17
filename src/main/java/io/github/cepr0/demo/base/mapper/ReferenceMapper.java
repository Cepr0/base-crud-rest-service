package io.github.cepr0.demo.base.mapper;

import io.github.cepr0.demo.base.model.BaseEntity;
import io.github.cepr0.demo.base.repo.BaseRepo;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public interface ReferenceMapper<ID extends Serializable, T extends BaseEntity<ID>> {

	BaseRepo<ID, T> getRepo();

	default T toReference(ID id) {
		return getRepo().getOne(id);
	}

	default ID toId(T element) {
		return element.getId();
	}

	default Set<T> toRefSet(@NonNull Collection<ID> ids) {
		return ids.stream().map(this::toReference).collect(toSet());
	}

	default Set<ID> toIdSet(@NonNull Collection<T> elements) {
		return elements.stream().map(this::toId).collect(toSet());
	}

	default List<T> toRefList(@NonNull Collection<ID> ids) {
		return ids.stream().map(this::toReference).collect(toList());
	}

	default List<ID> toIdList(@NonNull Collection<T> elements) {
		return elements.stream().map(this::toId).collect(toList());
	}
}
