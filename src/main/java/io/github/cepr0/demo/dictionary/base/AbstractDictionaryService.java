package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.service.AbstractBaseService;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryCreateRequest;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryResponse;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryUpdateRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AbstractDictionaryService<T extends Dictionary> extends AbstractBaseService<
		String,
		T,
		DictionaryCreateRequest,
		DictionaryUpdateRequest,
		DictionaryResponse
		> implements DictionaryService<T> {

	public AbstractDictionaryService(DictionaryRepo<T> repo, DictionaryMapper<T> mapper) {
		super(repo, mapper);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DictionaryResponse> getAll() {
		return repo.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(toList());
	}
}
