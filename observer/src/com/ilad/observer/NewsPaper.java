package com.ilad.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private List<Message> messages = new ArrayList<Message>();
	public void update(Message message) {
		messages.add(message);
		for (Observer observer : observers) {
			observer.notifyObserver(message);
		}
	}
	@Override
	public String toString() {
		return "NewsPaper [observers=" + observers + "]";
	}
	@Override
	public void subscribe(Observer observer) {
		observers.add(observer);
	}
	@Override
	public void unsubscribe(Observer observer) {
		observers.remove(observer);
	}
}
