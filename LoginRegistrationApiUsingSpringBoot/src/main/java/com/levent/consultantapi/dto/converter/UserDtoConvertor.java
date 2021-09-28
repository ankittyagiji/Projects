package com.levent.consultantapi.dto.converter;

import com.levent.consultantapi.dto.UserRequestDto;

import com.levent.consultantapi.exception.CustomException;

import com.levent.consultantapi.model.User;

public interface UserDtoConvertor {

	User convertUserRequestDtoToUser(UserRequestDto userDto) throws CustomException;

}