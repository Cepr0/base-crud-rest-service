package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.service.BaseService;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryCreateRequest;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryResponse;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryUpdateRequest;

import java.util.List;

public interface DictionaryService<T extends Dictionary> extends BaseService<String, T, DictionaryCreateRequest, DictionaryUpdateRequest, DictionaryResponse> {

	List<DictionaryResponse> getAll();
}
