package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.controller.BaseController;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryCreateRequest;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryResponse;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class DictionaryController<T extends Dictionary> extends BaseController<
		String,
		T,
		DictionaryCreateRequest,
		DictionaryUpdateRequest,
		DictionaryResponse
		> {
	public DictionaryController(DictionaryService<T> service) {
		super(service);
	}

	@PostMapping
	@Override
	protected ResponseEntity<?> create(@Valid @RequestBody DictionaryCreateRequest request) {
		return super.create(request);
	}

	@DeleteMapping("/{id}")
	@Override
	protected ResponseEntity<?> delete(@PathVariable("id") String id) {
		return super.delete(id);
	}

	@GetMapping
	protected ResponseEntity<?> getAll(Pageable pageable) {
		return ResponseEntity.ok(((DictionaryService<T>) service).getAll());
	}

	@GetMapping("/{id}")
	@Override
	protected ResponseEntity<?> getOne(@PathVariable("id") String id) {
		return super.getOne(id);
	}
}
