package com.ilad.springAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context =
				new ClassPathXmlApplicationContext("BeansAOP.xml");

		Student student = (Student)context.getBean("student");

		student.getName();
		student.getAge();

		student.printThrowException();
	}
}