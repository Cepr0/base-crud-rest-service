package io.github.cepr0.demo.user;

import io.github.cepr0.demo.base.model.LongIdEntity;
import io.github.cepr0.demo.dictionary.group.Group;
import io.github.cepr0.demo.dictionary.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends LongIdEntity {

	@Column(nullable = false, length = 32)
	private String name;

	@ManyToMany
	private List<Role> roles;

	@ManyToMany
	private List<Group> groups;

	public void setRoles(List<Role> roles) {
		if (!Objects.equals(roles, this.roles)) {
			this.roles = roles;
		}
	}

	public void setGroups(List<Group> groups) {
		if (!Objects.equals(groups, this.groups)) {
			this.groups = groups;
		}
	}
}
