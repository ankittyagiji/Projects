package com.levent.consultantapi.dto.converter;

import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.levent.consultantapi.dto.UserRequestDto;
import com.levent.consultantapi.encoder.Encoder;
import com.levent.consultantapi.exception.CustomException;
import com.levent.consultantapi.model.User;

@Service
@Transactional
public class UserDtoConvertorImpl implements UserDtoConvertor {
	
	@Autowired
	private Encoder encoder;

	@Override
	public User convertUserRequestDtoToUser(UserRequestDto userDto) throws CustomException {
		User user = new User();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		if (userDto.getLastName().length() < 5 || userDto.getLastName().length() > 15) {
			throw new CustomException("between 5 to 15");
		}

		user.setPincode(userDto.getPincode());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setMobile(userDto.getMobile());
		if (userDto.getPassword().length() < 6 || userDto.getPassword().length() > 15) {
			throw new CustomException("password should be between 6 to 15");
		}

		user.setPassword(encoder.userPasswordEncoder().encode(userDto.getPassword()));
		user.setUuid(UUID.randomUUID().toString());
		return user;

	}

}