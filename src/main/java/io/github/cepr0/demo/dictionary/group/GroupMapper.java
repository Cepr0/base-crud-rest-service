package io.github.cepr0.demo.dictionary.group;

import io.github.cepr0.demo.dictionary.base.DictionaryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GroupMapper extends DictionaryMapper<Group> {
}
