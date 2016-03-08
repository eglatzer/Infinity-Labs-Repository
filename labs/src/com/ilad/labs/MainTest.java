package com.ilad.labs;

public class MainTest {

	public MainTest() {
	}
	
	public static void main(String[] args) {
		String hello = "Hello world from MainTest";
		System.out.println(hello);
		
		Hello.call();
		
		Hello sendy = new Hello();
		
		sendy.send();
	}

}
