package com.micro.controller;

import com.micro.dto.ApiResponse;
import com.micro.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
public interface GuestController {
	@PostMapping("/users")
	public ResponseEntity<ApiResponse<UserDto>> addUser(@RequestBody UserDto userDto);

	@GetMapping("/users")
	public ResponseEntity<ApiResponse<List<UserDto>>> getUsers();

	@GetMapping("/users/{userid}")
	public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable Long userid);

	@PutMapping("/users/{userid}")
	public ResponseEntity<ApiResponse<UserDto>> updateUser(@RequestBody UserDto userDto, @PathVariable Long userid);

	@DeleteMapping("/users/{userid}")
	public ResponseEntity<ApiResponse<UserDto>> deleteUserById(@PathVariable Long userid);



	@GetMapping("/users/username/{username}")
	public ResponseEntity<ApiResponse<UserDto>> getUserByUserName(@PathVariable String username);

}
