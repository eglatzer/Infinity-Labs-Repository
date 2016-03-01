package com.ilad.springBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class MainTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(HelloWorldConfig.class);

		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

		helloWorld.setMessage("Hello World!");
		System.out.println("Your Message : " + helloWorld.getMessage());
	}
}