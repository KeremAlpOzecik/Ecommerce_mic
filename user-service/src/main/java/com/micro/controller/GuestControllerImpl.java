package com.micro.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.micro.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.micro.dto.ApiResponse;
import com.micro.dto.UserDto;
import com.micro.entity.User;
import com.micro.service.GuestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestControllerImpl implements GuestController {

	@Autowired
	private GuestService guestService;

	@Override
	public ResponseEntity<ApiResponse<UserDto>> addUser(UserDto userDto) {
		log.info("Entered into the " + GuestControllerImpl.class.getName() + "addUser");
		User user = guestService.addUser(userDto);
		return new ResponseEntity<>(new ApiResponse<>(GuestMapper.INSTANCE.convert(user),
				LocalDate.now(), "User created "), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ApiResponse<List<UserDto>>> getUsers() {
		log.info("Getting the user");
		List<User> users = guestService.getUsers();
		List<UserDto> usersDtos= users.stream().map(user -> GuestMapper.INSTANCE.convert(user))
				.collect(Collectors.toList());

		return new ResponseEntity<>(new ApiResponse<>(usersDtos, 
				LocalDate.now(), "User created "), HttpStatus.OK);
	}



	@Override
	public ResponseEntity<ApiResponse<UserDto>> getUserById(Long userid) {
		log.info("Entered into the " + GuestControllerImpl.class.getName() + "getUserById");
		User user = guestService.getUserById(userid);
		log.info("User has retrieved by the userid" + userid);
		return new ResponseEntity<>(new ApiResponse<>(GuestMapper.INSTANCE.convert(user),
				LocalDate.now(), "User has retrieved"), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<UserDto>> updateUser(UserDto userDto, Long userid) {
		log.info("Enterd into the " + GuestControllerImpl.class.getName() + "updateUser");
		User user = guestService.updateUser(userDto, userid);
		log.info("User has retrieved by the userid" + userid);
		return new ResponseEntity<>(new ApiResponse<>(GuestMapper.INSTANCE.convert(user),
				LocalDate.now(), "User" + userid + "has updated"),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<UserDto>> deleteUserById(Long userid) {
		log.info("Entered into the " + GuestControllerImpl.class.getName() + "deleteUserById" + userid);
		return new ResponseEntity<>(new ApiResponse<>(null, LocalDate.now(), guestService.deleteUser(userid)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<UserDto>> getUserByUserName(String username) {
		log.info("Entered into the " + GuestControllerImpl.class.getName() + "getUserByUserName");
		User user = guestService.getUserByUserName(username);
		return new ResponseEntity<>(new ApiResponse<>(GuestMapper.INSTANCE.convert(user),
				LocalDate.now(), "User with " + username + " has retrieved"),
				HttpStatus.OK);
	}

}
