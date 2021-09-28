package com.levent.consultantapi.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends BaseException {
	/**
	*
	 */
	private static final long serialVersionUID = -925589354392740733L;

	public CustomException(String messageValue, Object... messageArgs) {
		super(messageValue, messageArgs);

	}

	public CustomException(String messageValue) {
		super(messageValue);
	}

	public CustomException() {
		super();

	}
}