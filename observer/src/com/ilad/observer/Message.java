package com.ilad.observer;

import java.util.Date;

public class Message {
	String str;
	Date date;
	private static int numOfWatchers;
	@Override
	public String toString() {
		return "Message [str = " + str + ", date = " + date + ", numOfWatchers = "
				+ numOfWatchers + "]";
	}
	//Constructors
	public Message() {

	}
	public Message(String str_, Date date_) {
		++numOfWatchers;
		str = str_;
		date = date_;
	}
}
