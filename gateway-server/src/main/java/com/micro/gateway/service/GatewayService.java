package com.micro.gateway.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.gateway.model.ApiResponse;
import com.micro.gateway.model.LoginDetails;
import com.micro.gateway.model.User;

public interface GatewayService {
	public ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails);

}
