
package com.levent.consultantapi.service;

import java.util.List;

import com.levent.consultantapi.exception.CustomException;

import com.levent.consultantapi.model.User;

public interface UserService {

	List<User> getUsers();

	User createUser(User user) throws CustomException;

	User findByUuid(String uuid);

	User getUserById(Integer id);

	public void deleteUserById(Integer id);

	User updateUserById(Integer id, User user);

}
