package com.masai;

import com.masai.entity.User;
import com.masai.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtTokenApplication {
	@Autowired
	private UserRepository repo;
	     @PostConstruct
         public void initUsers(){
			 List<User> users= Stream.of(
					 new User(101,"admin","admin","admin@gmail.com"),
			         new User(102,"user1","user1","user1@gmail.com"),
			         new User(103,"user2","user1","user2@gmail.com"),
					 new User(104,"user3","user1","user3@gmail.com")

			 ).collect(Collectors.toList());
			 repo.saveAll(users);
		 }
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtTokenApplication.class, args);
	}

}
