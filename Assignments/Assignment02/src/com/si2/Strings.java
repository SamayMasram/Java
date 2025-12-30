package com.si2;

public class Strings {
	
	String line;

	public String getLine() {
		return line;
	}

	public void setLine(String line) throws ExceptionLineTooLongException {
		if(line.length() > 80)
			throw new ExceptionLineTooLongException();
		this.line = line;
	}

	@Override
	public String toString() {
		return line;
	}
	
	public int getLength() {
		return line.length();
	}
	
}
