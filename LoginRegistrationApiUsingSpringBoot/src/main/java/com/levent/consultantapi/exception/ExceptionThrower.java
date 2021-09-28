package com.levent.consultantapi.exception;

import com.levent.consultantapi.model.User;

public class ExceptionThrower {

	public User throwCustomException() throws CustomException {
		return null;
		// CustomException e = new CustomException();
		// e.setCode(10);
		// e.setMessage("User with email id Already exists");
		// throw e;
	}

}
