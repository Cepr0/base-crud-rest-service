package io.github.cepr0.demo.dictionary.group;

import io.github.cepr0.demo.dictionary.base.AbstractDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends AbstractDictionaryService<Group> {

	public GroupService(GroupRepo repo, GroupMapper mapper) {
		super(repo, mapper);
	}
}
