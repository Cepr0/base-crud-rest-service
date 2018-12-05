package io.github.cepr0.demo.dictionary.group;

import io.github.cepr0.demo.dictionary.base.DictionaryController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("groups")
public class GroupController extends DictionaryController<Group> {

	public GroupController(GroupService service) {
		super(service);
	}
}
