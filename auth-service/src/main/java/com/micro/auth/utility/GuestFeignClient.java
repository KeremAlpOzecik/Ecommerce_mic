package com.micro.auth.utility;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.auth.model.ApiResponse;
import com.micro.auth.model.User;

@FeignClient(name = "user-service")
@LoadBalancerClient(name = "user-service")
public interface GuestFeignClient {

	@GetMapping("/users/username/{username}")
	ResponseEntity<ApiResponse<User>> getUserByUserName(@PathVariable String username);

	@PostMapping("/users")
	public ResponseEntity<ApiResponse<User>> addUser(@RequestBody User user);
}
