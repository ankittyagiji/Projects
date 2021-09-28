package com.rsi.kafka.exceptioncontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rsi.kafka.exception.CustomException;
import com.rsi.kafka.response.ErrorResponse;

@ControllerAdvice
public class ErrorhandlingController {

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<ErrorResponse> specialException(CustomException e, HttpServletRequest httpServletRequest)
			throws Exception {
		ErrorResponse er = new ErrorResponse();
		er.setErrorMessage(e.getMessage());
		System.out.println("Error is --> " + e);
		return new ResponseEntity<ErrorResponse>(er, HttpStatus.BAD_REQUEST);
	}

}
