package io.github.cepr0.demo.dictionary.group;

import io.github.cepr0.demo.dictionary.base.Dictionary;
import io.github.cepr0.demo.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
@DynamicInsert
@DynamicUpdate
@Cache(usage = READ_WRITE, region = "group")
public class Group extends Dictionary {

	@Cache(usage = READ_WRITE)
	@ManyToMany(mappedBy = "groups")
	private Set<User> users;

	public Group(String name) {
		super(name);
	}
}
