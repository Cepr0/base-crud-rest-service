package io.github.cepr0.demo.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseEntity<ID extends Serializable> implements Serializable, Persistable<ID> {

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{id=" + getId() + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseEntity that = (BaseEntity) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@JsonIgnore
	@Override
	public boolean isNew() {
		return getVersion() == null;
	}

	protected abstract Long getVersion();
}
