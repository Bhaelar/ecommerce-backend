package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.data.payloads.request.UserRequest;
import com.example.ecommerce.data.payloads.response.MessageResponse;
import com.example.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	/*
	private final UserRepository repository;

	UserController(UserRepository repository) {
	    this.repository = repository;
	}

	@PostMapping("/register")
	User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	}
	*/
	
	@Autowired
	UserService userService;
	@PostMapping("/register")
	public ResponseEntity<MessageResponse> addUser( @RequestBody UserRequest user) {
        MessageResponse newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
