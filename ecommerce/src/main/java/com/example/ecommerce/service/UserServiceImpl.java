package com.example.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.data.models.User;
import com.example.ecommerce.data.payloads.request.UserRequest;
import com.example.ecommerce.data.payloads.response.MessageResponse;
import com.example.ecommerce.data.repository.UserRepository;
import com.example.ecommerce.exceptions.UserEmailExistsException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/*
	@Autowired
	private PasswordEncoder passwordEncoder;
	*/
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public MessageResponse createUser(UserRequest userRequest) throws UserEmailExistsException {
		// TODO Auto-generated method stub
		if (emailExist(userRequest.getEmail())) {
	        throw new UserEmailExistsException(
	          "There is an account with that email adress:" + userRequest.getEmail());
	    }
		
		User newUser = new User();
		newUser.setFirst_name(userRequest.getFirst_name());
		newUser.setLast_name(userRequest.getLast_name());
		newUser.setEmail(userRequest.getEmail());
		newUser.setPassword(encoder.encode(userRequest.getPassword()));
		newUser.setPhone_number(userRequest.getPhone_number());
		newUser.setAddress(userRequest.getAddress());
		newUser.setRole(userRequest.getRole());
		newUser.setCreated_at(LocalDateTime.now());
		newUser.setUpdated_at(LocalDateTime.now());
		// userRepository.save(newUser);
		return new MessageResponse("New User created successfully \n" + userRepository.save(newUser).toString());
	}

	private boolean emailExist(String email) {
		return userRepository.findByEmail(email) != null;
	}

	@Override
	public Optional<User> getUser(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
		// return new MessageResponse(userRepository.findById(id).toString());
	}

}
