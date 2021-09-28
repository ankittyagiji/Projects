package com.rsi.excel.apachepoi.dto;

import com.rsi.excel.apachepoi.exception.CustomException;
import com.rsi.excel.apachepoi.model.User;

public interface UserDtoConverter {
	User convertUserRequestDtoToUser(UserRequestDto userRequestDto) throws CustomException;

}
