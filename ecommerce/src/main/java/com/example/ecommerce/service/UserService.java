package com.example.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.ecommerce.data.models.User;
import com.example.ecommerce.data.payloads.request.UserRequest;
import com.example.ecommerce.data.payloads.response.MessageResponse;
import com.example.ecommerce.data.repository.UserRepository;

@Component
public interface UserService {

	MessageResponse createUser(UserRequest userRequest);
	// MessageResponse getUser(Integer id);
	Optional<User> getUser(Integer id);
}
