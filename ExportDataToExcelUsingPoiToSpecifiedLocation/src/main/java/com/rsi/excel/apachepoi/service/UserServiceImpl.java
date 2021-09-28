package com.rsi.excel.apachepoi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rsi.excel.apachepoi.model.User;
import com.rsi.excel.apachepoi.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.getById(id);
	}

}
