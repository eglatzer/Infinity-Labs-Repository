package com.ilad.spring;

public class HelloWorld {
	private String message;
	
	// Setter
	public void setMessage(String message_) {
		message  = message_;
	}
	
	// Getter
	public String getMessage() {
		return message;
	}
	
	// initiator
	public void init() {
		System.out.println("Bean is going through init.");
	}
	
	// destroyer
	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
}
