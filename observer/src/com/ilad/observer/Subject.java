package com.ilad.observer;

public interface Subject {
	public void subscribe(Observer observer);
	public void unsubscribe(Observer observer);
}
