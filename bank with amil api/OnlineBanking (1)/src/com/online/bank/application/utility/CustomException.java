package com.online.bank.application.utility;
 /*To handle user Exception*/
@SuppressWarnings("serial")
public class CustomException   extends Exception{
 
	
private String msg;

public CustomException(String msg) {
	
	this.msg = msg;
}

@Override
	public String toString() {
		return msg;
	}
@Override
	public String getMessage() {
		
		return msg;
	}

 
}
