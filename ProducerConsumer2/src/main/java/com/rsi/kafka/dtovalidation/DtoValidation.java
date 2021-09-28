package com.rsi.kafka.dtovalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.exception.CustomException;

@Component
public class DtoValidation {

	@Autowired
	private UserDto userDto;

	public void checkValidations(UserDto userDto) {
		userNameValidation(userDto);
		passwordValidation(userDto);
	}

	void userNameValidation(UserDto userDto) {
		if (userDto.getUserName().length() < 5 || userDto.getUserName().length() > 15) {

			throw new CustomException("***username*** length should be between 5 to 15 characters");

		}
	}

	void passwordValidation(UserDto userDto) {
		if (userDto.getPassword().length() < 6 || userDto.getPassword().length() > 15) {

			throw new CustomException("***password*** length should be between 6 to 15 characters");

		}
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

}
