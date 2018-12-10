package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.model.LongIdEntity;
import io.github.cepr0.demo.dictionary.group.Group;
import io.github.cepr0.demo.dictionary.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
@Cache(usage = READ_WRITE, region = "user")
public class User extends LongIdEntity {

	@Column(nullable = false, length = 32)
	private String name;

	@Cache(usage = READ_WRITE, region = "roles")
	@ManyToMany
	private Set<Role> roles;

	@Cache(usage = READ_WRITE, region = "groups")
	@ManyToMany
	private Set<Group> groups;
}
