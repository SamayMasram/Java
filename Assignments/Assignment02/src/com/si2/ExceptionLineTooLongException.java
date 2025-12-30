package com.si2;

public class ExceptionLineTooLongException extends Exception {
	int invalidLength;
	public ExceptionLineTooLongException() {
	}
	public int getInvalidLength() {
		return invalidLength;
	}
	public void setInvalidLength(int invalidLength) {
		this.invalidLength = invalidLength;
	}
	@Override
	public String getMessage() {
		return String.format("The Strings is too long");
	}

}
