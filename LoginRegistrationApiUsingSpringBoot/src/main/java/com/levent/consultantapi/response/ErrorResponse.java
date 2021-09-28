package com.levent.consultantapi.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse {

	private String errorMessage;
	private int errorCode;
	private int status;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String errorMessage, int errorCode, int status) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", status=" + status + "]";

	}

}