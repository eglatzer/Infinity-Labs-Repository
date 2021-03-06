package com.ilad.subsets;

import java.util.ArrayList;

public class SubSets {
	public static ArrayList<Integer> subSets(int numOfDigits, int maximalDigit)
			throws Exception {
		if(numOfDigits < 1 || numOfDigits > 9 ||
				maximalDigit < numOfDigits || maximalDigit > 9) {
			throw new Exception("n or k are illegal!");
		}
		ArrayList<Integer> array = new ArrayList<>();
		int min = 0;
		int max = 0;
		int i;
		for(i = 1; i <= numOfDigits; ++i) {
			min = 10 * min + i;
			max = 10 * max + maximalDigit - numOfDigits + i;
		}
		for(i = min; i <= max; ++i) {
			if(isValidNumber(i, maximalDigit)) {
				array.add(i);
			}
		}
		return array;
	}
	
	private static boolean isValidNumber(int number, int maximalDigit) {
		int copy = number;
		int temp = 10;
		
		while(0 != copy) {
			if(copy % 10 >= temp || copy % 10 > maximalDigit) {
				return false;
			}
			temp = copy % 10;
			copy = copy / 10;
		}
		return true;
	}
}