package com.ilad.hello;

public class Greeting {
	private final long id;
	private final String content;

	// Constructor
	public Greeting(long id_, String content_) {
		id = id_;
		content = content_;
	}

	// Getters
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}