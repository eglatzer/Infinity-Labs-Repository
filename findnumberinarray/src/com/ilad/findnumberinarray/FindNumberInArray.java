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
	
	public static void main(String[] args) {
		final int LENGTH = 10;
		Random random = new Random();
		int[] array = new int[LENGTH];
		int i;
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(LENGTH);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		int num = random.nextInt(LENGTH);
		int found = findNumber(array, num);
		if(LENGTH != found) {
			System.out.println
				("Number " + num + " exists in index " + found + " in the array");
		}
		else {
			System.out.println("Number " + num + " doesn't exist in the array");
		}
	}
}
