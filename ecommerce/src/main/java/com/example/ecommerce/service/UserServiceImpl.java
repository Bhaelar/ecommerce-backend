package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.data.models.User;
import com.example.ecommerce.data.payloads.request.UserRequest;
import com.example.ecommerce.data.payloads.response.MessageResponse;
import com.example.ecommerce.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public MessageResponse createUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		User newUser = new User();
		newUser.setFirst_name(userRequest.getFirst_name());
		newUser.setLast_name(userRequest.getLast_name());
		newUser.setEmail(userRequest.getEmail());
		newUser.setPassword(userRequest.getPassword());
		newUser.setPhone_number(userRequest.getPhone_number());
		newUser.setRole(userRequest.getRole());
		userRepository.save(newUser);
		return new MessageResponse("New User created successfully");
	}

}
