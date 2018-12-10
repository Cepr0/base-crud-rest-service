package io.github.cepr0.demo.base.mapper;

import io.github.cepr0.demo.base.dto.BaseResponse;
import io.github.cepr0.demo.base.dto.CreateRequest;
import io.github.cepr0.demo.base.dto.UpdateRequest;
import io.github.cepr0.demo.base.model.BaseEntity;
import io.github.cepr0.demo.base.repo.BaseRepo;
import org.mapstruct.MappingTarget;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface BaseMapper<
		ID extends Serializable,
		T extends BaseEntity<ID>,
		C extends CreateRequest,
		U extends UpdateRequest,
		R extends BaseResponse<ID>
		> {
	T fromCreateRequest(C request);
	T fromUpdateRequest(@MappingTarget T element, U request);
	R toResponse(T element);

	default <RefID extends Serializable, Ref extends BaseEntity<RefID>> Set<Ref> toRefSet(@NonNull Collection<RefID> ids, @NonNull BaseRepo<RefID, Ref> repo) {
		return ids.stream()
				.map(repo::getOne)
				.collect(Collectors.toSet());
	}

	default <RefID extends Serializable, Ref extends BaseEntity<RefID>> Set<RefID> toRefIdSet(@NonNull Collection<Ref> elements) {
		return elements.stream()
				.map(BaseEntity::getId)
				.collect(Collectors.toSet());
	}

	default <RefID extends Serializable, Ref extends BaseEntity<RefID>> List<Ref> toRefList(@NonNull Collection<RefID> ids, @NonNull BaseRepo<RefID, Ref> repo) {
		return ids.stream()
				.map(repo::getOne)
				.collect(Collectors.toList());
	}

	default <RefID extends Serializable, Ref extends BaseEntity<RefID>> List<RefID> toRefIdList(@NonNull Collection<Ref> elements) {
		return elements.stream()
				.map(BaseEntity::getId)
				.collect(Collectors.toList());
	}
}
