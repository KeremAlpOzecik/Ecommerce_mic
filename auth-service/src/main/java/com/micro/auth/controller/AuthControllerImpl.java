package com.micro.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.micro.auth.model.ApiResponse;
import com.micro.auth.model.LoginDetails;
import com.micro.auth.model.User;
import com.micro.auth.service.AuthService;

@RestController
public class AuthControllerImpl implements AuthController {

	@Autowired
	private AuthService authService;

	@Override
	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails) {
		return authService.login(loginDetails);
	}

	@Override
	public Boolean validateToken(String token) {

		return authService.validateToken(token);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> signUp(User user) {
		return authService.signUp(user);
	}

}
