package com.levent.consultantapi.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.levent.consultantapi.exception.CustomException;
import com.levent.consultantapi.model.User;
import com.levent.consultantapi.repository.UserRepository;
import com.levent.consultantapi.util.SimpleEmail;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) throws CustomException {
		// ExceptionThrower exceptionThrower = new ExceptionThrower();
		String emailid = user.getEmail();
		if (userRepository.existsByEmail(user.getEmail())) {
			// return exceptionThrower.throwCustomException();
			throw new CustomException("User with Email Id --> {0} Already exists", emailid);
		}

		SimpleEmail.sendMailAdvance(emailid, "Registration in Spring Boot Application", "U r registered successfully",
				"");

		return userRepository.saveAndFlush(user);

	}

	@Override
	public User findByUuid(String uuid) {
		return userRepository.findByUuid(uuid);
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.getById(id);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);

	}

	@Override
	public User updateUserById(Integer id, User user) {
		User existingUser = userRepository.getById(id);
		BeanUtils.copyProperties(user, existingUser);
		return userRepository.saveAndFlush(existingUser);

	}

}