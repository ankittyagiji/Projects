package com.rsi.kafka.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsi.kafka.dto.UserDto;
import com.rsi.kafka.dto.UserDtoConverter;
import com.rsi.kafka.model.User;
import com.rsi.kafka.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDtoConverter userDtoConverter;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void createUser(ArrayList<UserDto> userDtos)
	{
			userDtos.stream().forEach(userDto -> {
				
				try {
					userRepository.save(userDtoConverter.convertUserRequestDtoToUser(userDto));
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("data not valid", e);
				}
				
		});
		
			userDtos.clear();

	}

}
