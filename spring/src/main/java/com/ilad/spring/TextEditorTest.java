package com.ilad.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextEditorTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context =
				new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor text = (TextEditor)context.getBean("textEditor");
		text.spellCheck();
	}
}