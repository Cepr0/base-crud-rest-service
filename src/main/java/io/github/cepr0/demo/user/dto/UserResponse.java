package io.github.cepr0.demo.user.dto;

import io.github.cepr0.demo.base.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse extends BaseResponse<Long> {
	private String name;
	private Set<String> roleIds;
	private Set<String> groupIds;
}
