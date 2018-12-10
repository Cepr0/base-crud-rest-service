package io.github.cepr0.demo.dictionary.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.cepr0.demo.base.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Dictionary extends BaseEntity<String> {

	@Id private String id;

	@JsonIgnore
	@Version
	private Long version;

	@Column(nullable = false, length = 32)
	private String name;

	public Dictionary(String name) {
		setName(name);
	}

	public void setName(String name) {
		this.name = name;
		if (id == null) {
			this.id = name.toLowerCase()
					.trim()
					.replaceAll("\\s", "-");
		}
	}
}
