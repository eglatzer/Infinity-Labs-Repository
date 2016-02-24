package com.ilad.subsets;

public class MainTest {

	public static void main(String[] args) throws Exception {
		for(int i = 1; i < 10; ++i) {
			for(int j = i; j < 10; ++j) {
				System.out.println
					("numOfDigits = " + i + ", maximalDigit = " + j + ":");
				System.out.println(SubSets.subSets(i, j));
			}
		}
	}
}