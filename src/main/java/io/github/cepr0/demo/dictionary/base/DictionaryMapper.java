package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryCreateRequest;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryResponse;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryUpdateRequest;

public interface DictionaryMapper<T extends Dictionary> extends BaseMapper<String, T, DictionaryCreateRequest, DictionaryUpdateRequest, DictionaryResponse> {
}
