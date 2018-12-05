package io.github.cepr0.demo.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@MappedSuperclass
public abstract class BaseElement<ID extends Serializable> extends BaseEntity<ID> {

	@JsonIgnore
	@Version
	private Long version;

	protected void setVersion(Long version) {
		this.version = version;
	}
}
