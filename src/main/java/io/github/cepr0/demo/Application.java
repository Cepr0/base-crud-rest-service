package io.github.cepr0.demo;

import io.github.cepr0.demo.dictionary.group.Group;
import io.github.cepr0.demo.dictionary.group.GroupRepo;
import io.github.cepr0.demo.dictionary.role.Role;
import io.github.cepr0.demo.dictionary.role.RoleRepo;
import io.github.cepr0.demo.user.User;
import io.github.cepr0.demo.user.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class Application {

	private final GroupRepo groupRepo;
	private final RoleRepo roleRepo;
	private final UserRepo userRepo;

	public Application(GroupRepo groupRepo, RoleRepo roleRepo, UserRepo userRepo) {
		this.groupRepo = groupRepo;
		this.roleRepo = roleRepo;
		this.userRepo = userRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener
	public void demoData(ApplicationReadyEvent e) {
		List<Group> groups = groupRepo.saveAll(List.of(
				new Group("Group 1"),
				new Group("Group 2")
		));

		List<Role> roles = roleRepo.saveAll(List.of(
				new Role("USER"),
				new Role("ADMIN")
		));

		userRepo.save(new User("John Smith", roles, groups));
	}
}
