package io.github.cepr0.demo.base.service;

import io.github.cepr0.demo.base.dto.BaseResponse;
import io.github.cepr0.demo.base.dto.CreateRequest;
import io.github.cepr0.demo.base.dto.UpdateRequest;
import io.github.cepr0.demo.base.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<ID extends Serializable, T extends BaseEntity<ID>, C extends CreateRequest, U extends UpdateRequest, R extends BaseResponse<ID>> {
	R create(C request);
	Optional<R> update(ID id, U request);
	void delete(ID id);
	Page<R> getAll(Pageable pageable);
	Optional<R> getOne(ID id);
}
