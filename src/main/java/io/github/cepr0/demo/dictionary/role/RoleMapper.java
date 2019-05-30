package io.github.cepr0.demo.dictionary.role;

import io.github.cepr0.demo.dictionary.base.DictionaryMapper;
import io.github.cepr0.demo.user.UserMapper;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = UserMapper.class)
public abstract class RoleMapper extends DictionaryMapper<Role> {
	@Autowired @Getter private RoleRepo repo;
}
