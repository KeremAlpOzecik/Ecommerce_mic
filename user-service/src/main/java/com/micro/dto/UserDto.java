package com.micro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private Long id;
	private Boolean status;
	private String name;
	private String email;
	private String userName;
	private String password;
}
