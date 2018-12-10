package io.github.cepr0.demo.dictionary.role;

import io.github.cepr0.demo.dictionary.base.Dictionary;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "roles")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "role")
public class Role extends Dictionary {
	public Role(String name) {
		super(name);
	}
}
