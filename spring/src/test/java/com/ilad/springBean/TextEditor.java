package com.ilad.springBean;

public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker_) {
		System.out.println("Inside TextEditor constructor.");
		spellChecker = spellChecker_;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}