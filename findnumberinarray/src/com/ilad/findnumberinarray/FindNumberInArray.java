package com.ilad.findnumberinarray;

import java.util.Random;

public class FindNumberInArray {
	public static int findNumber(int[] array, int numberToFind) {
		int length = array.length;
		boolean isFound = false;
		
		if(array[length - 1] == numberToFind) {
			isFound = true;
		}
		int temp = array[length - 1];
		array[length - 1] = numberToFind;
		int i = 0;
		while(numberToFind != array[i]) {
			++i;
		}
		array[length - 1] = temp;
		if(length - 1 == i && !isFound) {
			return length;
		}
		return i;
	}
	
	public static boolean findChar(char[] array, char charToFind) {
		int length = array.length;
		boolean isFound = (array[length - 1] == charToFind);
		
		char temp = array[length - 1];
		array[length - 1] = charToFind;
		int i = 0;
		while(charToFind != array[i]) {
			++i;
		}
		array[length - 1] = temp;
		isFound = (isFound || length - 1 != i);
		return isFound;
	}
	
	public static void main(String[] args) {
		final int LENGTH = 10;
		Random random = new Random();
		int[] array = new int[LENGTH];
		char[] charArray = new char[LENGTH];
		int i;
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(LENGTH);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		for(i = 0; i < LENGTH; ++i) {
			charArray[i] = (char)(random.nextInt() % 95 + 33);
			System.out.print(charArray[i] + " ");
		}
		System.out.println();
		int num = random.nextInt(LENGTH);
		char charToFind = (char)(random.nextInt() % 95 + 33);
		int found = findNumber(array, num);
		if(LENGTH != found) {
			System.out.println
				("Number " + num + " exists in index " + found + " in the array");
		}
		else {
			System.out.println("Number " + num + " doesn't exist in the array");
		}
		if(findChar(charArray, charToFind)) {
			System.out.println("Char " + charToFind + " exists in the array");
		}
		else {
			System.out.println("Char " + charToFind +
					" doesn't exist in the array");
		}
	}
}
