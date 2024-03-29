package com.micro;

import com.micro.dto.UserDto;
import com.micro.entity.User;
import com.micro.mapper.GuestMapper;
import com.micro.repository.GuestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuestRepositoryTest {

	@Autowired
	private GuestRepository guestRepository;

	private UserDto userDto;


	@BeforeEach
	void beforeEach() {

		userDto = new UserDto();
		userDto.setStatus(true);


	}

	@Test
	void validateDataSource() {
		User user = guestRepository.save(GuestMapper.INSTANCE.convert(userDto));
		Assertions.assertNotNull(user);
	}
}
