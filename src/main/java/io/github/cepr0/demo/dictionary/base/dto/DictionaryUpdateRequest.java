package io.github.cepr0.demo.dictionary.base.dto;

import io.github.cepr0.demo.base.dto.UpdateRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DictionaryUpdateRequest extends UpdateRequest {
	private String name;
}
