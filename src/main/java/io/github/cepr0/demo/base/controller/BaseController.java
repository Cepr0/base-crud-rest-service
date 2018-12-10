package io.github.cepr0.demo.base.controller;

import io.github.cepr0.demo.base.dto.BaseResponse;
import io.github.cepr0.demo.base.dto.CreateRequest;
import io.github.cepr0.demo.base.dto.UpdateRequest;
import io.github.cepr0.demo.base.model.BaseEntity;
import io.github.cepr0.demo.base.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;

public abstract class BaseController<
		ID extends Serializable,
		T extends BaseEntity<ID>,
		C extends CreateRequest,
		U extends UpdateRequest,
		R extends BaseResponse<ID>
		> {

	protected final BaseService<ID, T, C, U, R> service;

	public BaseController(BaseService<ID, T, C, U, R> service) {
		this.service = service;
	}

	protected ResponseEntity<?> create(@Valid @RequestBody C request) {
		return ResponseEntity.ok(service.create(request));
	}

	protected ResponseEntity<?> update(@PathVariable("id") ID id, @Valid @RequestBody U request) {
		return ResponseEntity.of(service.update(id, request));
	}

	protected ResponseEntity<?> delete(@PathVariable("id") ID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	protected ResponseEntity<?> getAll(Pageable pageable) {
		return ResponseEntity.ok(service.getAll(pageable));
	}

	protected ResponseEntity<?> getOne(@PathVariable("id") ID id) {
		return ResponseEntity.of(service.getOne(id));
	}
}
