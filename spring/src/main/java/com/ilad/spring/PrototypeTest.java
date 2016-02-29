package com.ilad.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context =
				new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA = (HelloWorld)context.getBean("prototype");
		
		objA.setMessage("I'm object A");
		System.out.println("Your Message : " + objA.getMessage());
		
		HelloWorld objB = (HelloWorld)context.getBean("prototype");
		System.out.println("Your Message : " + objB.getMessage());
	}
}
