package io.github.cepr0.demo.dictionary.role;

import io.github.cepr0.demo.dictionary.base.AbstractDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractDictionaryService<Role> {

	public RoleService(RoleRepo repo, RoleMapper mapper) {
		super(repo, mapper);
	}
}
