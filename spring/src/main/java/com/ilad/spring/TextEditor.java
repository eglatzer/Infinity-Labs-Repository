package com.ilad.spring;

public class TextEditor {
	private SpellChecker spellChecker;
	
/*	// Constructor
	public TextEditor(SpellChecker spellChecker_) {
		System.out.println("Inside TextEditor constructor.");
		spellChecker = spellChecker_;
	}
*/
	// A setter method to inject the dependency
	public void setSpellChecker(SpellChecker spellChecker_) {
		System.out.println("Inside setSpellChecker.");
		spellChecker = spellChecker_;
	}
	
	// A getter method to return spellChecker
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}