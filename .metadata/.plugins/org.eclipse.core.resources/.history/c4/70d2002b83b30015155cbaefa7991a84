package com.ilad.palindrome;

import java.util.Scanner;

public class Palindrome {
	private static Scanner scan;
	private static boolean isFirstTime;

	public static boolean isPalindrome(String arg) {
		String trimmed;
		
		if(isFirstTime) {
			isFirstTime = false;
			trimmed = arg.trim().toLowerCase();
		}
		else {
			trimmed = arg.trim();
		}
		
		if(2 > trimmed.length()) {
			return true;
		}
				
		return isPalindrome(trimmed.substring(1, trimmed.length() - 1)) &&
			   trimmed.charAt(0) == trimmed.charAt(trimmed.length() - 1);
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter a string, and let the program check"
				+ " if it's a palindrome");
		System.out.println("To stop, please enter Stop");
		boolean isStop = false;
		while(false == isStop) {
			scan = new Scanner(System.in);
			String arg = scan.nextLine();
			if(arg.trim().equalsIgnoreCase("Stop")) {
				isStop = true;
				break;
			}
			isFirstTime = true;
			if(isPalindrome(arg)) {
				System.out.println("The string: '" + arg + "' is a palindrome");
			}
			else {
				System.out.println
						("The string: '" + arg + "' is NOT a palindrome");
			}
		}
	}
}
