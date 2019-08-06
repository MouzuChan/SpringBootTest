package com.imooc.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String name;
	public UserNotFoundException(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
}
