package com.online.bank.application.controller.utility;
 /*To handle user Exception*/
public class CustomException   extends Exception{
 
	private static final long serialVersionUID = -4219579238019207003L;
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
