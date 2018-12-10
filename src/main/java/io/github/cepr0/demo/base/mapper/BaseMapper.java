package io.github.cepr0.demo.base.mapper;

import io.github.cepr0.demo.base.dto.BaseResponse;
import io.github.cepr0.demo.base.dto.CreateRequest;
import io.github.cepr0.demo.base.dto.UpdateRequest;
import io.github.cepr0.demo.base.model.BaseEntity;
import org.mapstruct.MappingTarget;

import java.io.Serializable;

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
}
