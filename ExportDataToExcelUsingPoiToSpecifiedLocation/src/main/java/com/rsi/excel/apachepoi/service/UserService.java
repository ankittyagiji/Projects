package com.rsi.excel.apachepoi.service;

import java.util.List;

import com.rsi.excel.apachepoi.model.User;

public interface UserService {
	
	List<User> getUsers();

	User createUser(User user);

	User getUserById(Integer id);

}
