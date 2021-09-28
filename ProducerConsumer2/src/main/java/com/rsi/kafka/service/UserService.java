package com.rsi.kafka.service;

import java.util.ArrayList;
import java.util.List;

import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.exception.CustomException;
import com.rsi.kafka.model.User;

public interface UserService {

	List<User> findAll();

	void createUser(ArrayList<UserDto> userDtos) throws CustomException;

}
