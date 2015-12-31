package com.ilad.suminarray;

public class MainTest {
	public static void main(String args[]) {
		System.out.println("Hello world!");
		
		int[] array = {1, 15, 16, 31, 18, 14, 12, 19, 17, 33, 8};
		SumInArray find = new SumInArray(array, 32);
		find.findSum();
	}
}
