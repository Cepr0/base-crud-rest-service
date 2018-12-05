package io.github.cepr0.demo.dictionary.role;

import io.github.cepr0.demo.dictionary.base.Dictionary;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends Dictionary {
	public Role(String name) {
		super(name);
	}
}
