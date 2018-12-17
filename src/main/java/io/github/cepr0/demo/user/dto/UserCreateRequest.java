package io.github.cepr0.demo.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.cepr0.demo.base.dto.CreateRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCreateRequest extends CreateRequest {

	@NotBlank private String name;

	@JsonProperty("roleIds")
	@NotNull
	@Size(min = 1)
	private Set<String> roles;

	@JsonProperty("groupIds")
	@NotNull
	@Size(min = 1)
	private Set<String> groups;
}
