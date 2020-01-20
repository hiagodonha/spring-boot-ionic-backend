package com.hiagodonha.mc.exception;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 3278087277893040975L;
	
	public DataIntegrityException(String msg) { super(msg); }
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	

}
