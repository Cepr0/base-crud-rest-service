package io.github.cepr0.demo.dictionary.group;

import io.github.cepr0.demo.dictionary.base.Dictionary;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

@NoArgsConstructor
@Entity
@Table(name = "groups")
@DynamicInsert
@DynamicUpdate
@Cache(usage = READ_WRITE, region = "group")
public class Group extends Dictionary {
	public Group(String name) {
		super(name);
	}
}
