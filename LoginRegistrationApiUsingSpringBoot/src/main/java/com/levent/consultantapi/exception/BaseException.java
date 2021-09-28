package com.levent.consultantapi.exception;

import java.text.MessageFormat;

public class BaseException extends Exception {
	/**
	*
	 */
	private static final long serialVersionUID = 4559265005862662853L;
	private Object[] messageArgs;

	public Object[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(Object... messageArgs) {
		this.messageArgs = messageArgs;
	}

	public BaseException(String messageValue, Object... messageArgs) {
		super(MessageFormat.format(messageValue, messageArgs));
		this.messageArgs = messageArgs;
	}

	public BaseException()

	{
	}

}
