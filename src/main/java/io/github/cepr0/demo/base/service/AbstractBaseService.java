package io.github.cepr0.demo.base.service;

import io.github.cepr0.demo.base.dto.BaseResponse;
import io.github.cepr0.demo.base.dto.CreateRequest;
import io.github.cepr0.demo.base.dto.UpdateRequest;
import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.base.model.BaseElement;
import io.github.cepr0.demo.base.repo.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Transactional
public class AbstractBaseService<
		ID extends Serializable,
		T extends BaseElement<ID>,
		C extends CreateRequest,
		U extends UpdateRequest,
		R extends BaseResponse<ID>
		> implements BaseService<ID, T, C, U, R> {

	protected final BaseRepo<ID, T> repo;
	protected final BaseMapper<ID, T, C, U, R> mapper;

	public AbstractBaseService(BaseRepo<ID, T> repo, BaseMapper<ID, T, C, U, R> mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public R create(C request) {
		T element = mapper.fromCreateRequest(request);
		return mapper.toResponse(repo.save(onCreate(request, element)));
	}

	@Override
	public Optional<R> update(ID id, U request) {
		return repo.findElementToUpdate(id)
				.map(element -> {
					T updated = mapper.fromUpdateRequest(element, request);
					onUpdate(updated, request);
					repo.flush();
					return mapper.toResponse(updated);
				});
	}

	@Override
	public void delete(ID id) {
		onDelete(id);
		repo.deleteElement(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<R> getAll(Pageable pageable) {
		return repo.findAllElements(pageable).map(mapper::toResponse);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<R> getOne(ID id) {
		return repo.findOneElement(id).map(mapper::toResponse);
	}

	protected T onCreate(C request, T element) {
		return element;
	}

	protected T onUpdate(T element, U request) {
		return element;
	}

	protected void onDelete(ID id) {
	}
}
