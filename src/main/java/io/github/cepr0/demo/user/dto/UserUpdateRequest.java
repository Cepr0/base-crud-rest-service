package io.github.cepr0.demo.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.cepr0.demo.base.dto.UpdateRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequest extends UpdateRequest {

	private String name;

	@JsonProperty("roleIds")
	@Size(min = 1)
	private Set<String> roles;

	@JsonProperty("groupIds")
	@Size(min = 1)
	private Set<String> groups;
}
