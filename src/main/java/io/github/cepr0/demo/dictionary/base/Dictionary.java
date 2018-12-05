package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.model.BaseElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Dictionary extends BaseElement<String> {

	@Id protected String id;

	@Column(nullable = false, length = 32)
	private String name;

	public Dictionary(String name) {
		setName(name);
	}

	public void setName(String name) {
		this.name = name;
		this.id = name.toLowerCase().trim().replaceAll("\\s", "-");
	}
}
