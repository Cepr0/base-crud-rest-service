package io.github.cepr0.demo.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.cepr0.demo.base.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse extends BaseResponse<Long> {
	private String name;
	@JsonProperty("roleIds") private Set<String> roles;
	@JsonProperty("groupIds") private Set<String> groups;
}
