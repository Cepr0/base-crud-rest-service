package io.github.cepr0.demo.dictionary.role;

import io.github.cepr0.demo.dictionary.base.DictionaryController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController extends DictionaryController<Role> {

	public RoleController(RoleService service) {
		super(service);
	}
}
