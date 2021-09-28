package com.levent.consultantapi.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder {

	public PasswordEncoder outhClientPasswordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	public PasswordEncoder userPasswordEncoder() {
		return new BCryptPasswordEncoder(8);
	}
}