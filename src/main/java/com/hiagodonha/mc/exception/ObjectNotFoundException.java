package com.hiagodonha.mc.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3278087277893040975L;
	
	public ObjectNotFoundException(String msg) { super(msg); }
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	

}
