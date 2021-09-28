package com.rsi.kafka.dto;

import org.springframework.stereotype.Component;
import com.rsi.kafka.exception.CustomException;
import com.rsi.kafka.model.User;

@Component
public class UserDtoConverterImpl implements UserDtoConverter {

	@Override
	public User convertUserRequestDtoToUser(UserDto userDto) throws CustomException {
		User user = new User();
		user.setId(userDto.getId());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		return user;
	}

}
