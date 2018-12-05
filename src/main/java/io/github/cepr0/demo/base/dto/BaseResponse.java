package io.github.cepr0.demo.base.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseResponse<ID extends Serializable> {
	protected ID id;
}
