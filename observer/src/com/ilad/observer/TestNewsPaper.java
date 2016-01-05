package com.ilad.observer;

import java.util.Date;

public class TestNewsPaper {
	public static void main(String[] args) {
		NewsPaper paper = new NewsPaper();
		PersonObserver person = new PersonObserver();
		paper.subscribe(person);
		DogObserver dog = new DogObserver();
		paper.subscribe(dog);		
		Message message = new Message("Hello", new Date());
		paper.update(message);
		paper.update(new Message("Bye", new Date()));
		System.out.println(paper.toString());
	}
}
