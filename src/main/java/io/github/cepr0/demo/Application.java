package io.github.cepr0.demo;

import io.github.cepr0.demo.dictionary.group.Group;
import io.github.cepr0.demo.dictionary.group.GroupRepo;
import io.github.cepr0.demo.dictionary.role.Role;
import io.github.cepr0.demo.dictionary.role.RoleRepo;
import io.github.cepr0.demo.user.User;
import io.github.cepr0.demo.user.UserRepo;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

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

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}

	@EventListener
	public void demoData(ApplicationReadyEvent e) {

		Set<Group> groups = new HashSet<>(groupRepo.saveAll(List.of(
				new Group("Group 1"),
				new Group("Group 2")
		)));

		Set<Role> roles = new HashSet<>(roleRepo.saveAll(List.of(
				new Role("USER"),
				new Role("ADMIN")
		)));

		userRepo.saveAll(asList(
				new User("John Smith", roles, groups),
				new User("Joan Smith", roles, groups)
		));
	}
}
