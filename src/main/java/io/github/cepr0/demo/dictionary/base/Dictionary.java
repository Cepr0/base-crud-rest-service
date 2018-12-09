package io.github.cepr0.demo.dictionary.base;

import io.github.cepr0.demo.base.model.BaseElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "dictionary")
public abstract class Dictionary extends BaseElement<String> {

	@Id private String id;

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
