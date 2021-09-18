package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.data.models.User;
import com.example.ecommerce.data.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserRepository repository;

	UserController(UserRepository repository) {
	    this.repository = repository;
	}

	@PostMapping("/register")
	User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	}
}
