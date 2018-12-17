package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.mapper.BaseMapper;
import io.github.cepr0.demo.base.mapper.ReferenceMapper;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryCreateRequest;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryResponse;
import io.github.cepr0.demo.dictionary.base.dto.DictionaryUpdateRequest;

public abstract class DictionaryMapper<T extends Dictionary> implements
		BaseMapper<String, T, DictionaryCreateRequest, DictionaryUpdateRequest, DictionaryResponse>,
		ReferenceMapper<String, T> {
}
