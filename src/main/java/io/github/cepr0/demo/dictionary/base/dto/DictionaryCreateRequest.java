package io.github.cepr0.demo.dictionary.base.dto;

import io.github.cepr0.demo.base.dto.CreateRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
public class DictionaryCreateRequest extends CreateRequest {
	@NotBlank private String name;
}
