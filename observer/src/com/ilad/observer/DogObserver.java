package com.ilad.observer;

import java.util.ArrayList;
import java.util.List;

public class DogObserver implements Observer {
	List<Message> messages = new ArrayList<Message>();
	@Override
	public void notifyObserver(Message message) {
		messages.add(message);
	}
	@Override
	public String toString() {
		return "DogObserver messages : "+ messages +"";
	}
}
