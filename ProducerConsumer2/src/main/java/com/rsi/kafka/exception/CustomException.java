package com.rsi.kafka.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 4829940098347316021L;

	public CustomException(String messageValue, Object... messageArgs) {
		super(messageValue);

	}

	public CustomException(String messageValue) {
		super(messageValue);
	}

	public CustomException() {
		super();

	}
}