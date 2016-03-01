package com.ilad.springBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class TextEditorTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(TextEditorConfig.class);

		TextEditor text = ctx.getBean(TextEditor.class);

		text.spellCheck();
	}
}