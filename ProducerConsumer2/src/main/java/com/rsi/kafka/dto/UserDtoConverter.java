package com.rsi.kafka.dto;

import com.rsi.kafka.exception.CustomException;
import com.rsi.kafka.model.User;

public interface UserDtoConverter {
	User convertUserRequestDtoToUser(UserDto userDto) throws CustomException ;
}
