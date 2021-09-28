package com.rsi.excel.apachepoi.dto;

import org.springframework.stereotype.Component;

import com.rsi.excel.apachepoi.exception.CustomException;
import com.rsi.excel.apachepoi.model.User;

@Component
public class UserDtoConverterImpl implements UserDtoConverter{

	@Override
	public User convertUserRequestDtoToUser(UserRequestDto userRequestDto) throws CustomException {
		User user = new User();
		user.setId(userRequestDto.getId());
		if((userRequestDto.getFirstName().length() < 5  || userRequestDto.getFirstName().length() > 15)
				||userRequestDto.getFirstName()==null || userRequestDto.getFirstName()=="")
			throw new CustomException("FirstName length should be between 5 to 15");
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setAddress(userRequestDto.getAddress());
		return user;
	}

}
