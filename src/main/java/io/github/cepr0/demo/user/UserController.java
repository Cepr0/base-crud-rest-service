package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.controller.BaseController;
import io.github.cepr0.demo.user.dto.UserCreateRequest;
import io.github.cepr0.demo.user.dto.UserResponse;
import io.github.cepr0.demo.user.dto.UserUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController extends BaseController<Long, User, UserCreateRequest, UserUpdateRequest, UserResponse> {

	public UserController(UserService service) {
		super(service);
	}

	@PostMapping
	@Override
	protected ResponseEntity<?> create(@Valid @RequestBody UserCreateRequest request) {
		return super.create(request);
	}

	@PatchMapping("/{id}")
	@Override
	protected ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateRequest request) {
		return super.update(id, request);
	}

	@DeleteMapping("/{id}")
	@Override
	protected ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@GetMapping
	protected ResponseEntity<?> getAll(@RequestParam(value = "name", required = false) String name, Pageable pageable) {
		if (name != null) return ResponseEntity.ok(((UserService) service).findByName(name));
		return super.getAll(pageable);
	}

	@GetMapping("/{id}")
	@Override
	protected ResponseEntity<?> getOne(@PathVariable("id") Long id) {
		return super.getOne(id);
	}
}
