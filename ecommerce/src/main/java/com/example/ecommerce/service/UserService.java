package com.example.ecommerce.service;

import org.springframework.stereotype.Component;

import com.example.ecommerce.data.payloads.request.UserRequest;
import com.example.ecommerce.data.payloads.response.MessageResponse;

@Component
public interface UserService {

	MessageResponse createUser(UserRequest userRequest);
}
