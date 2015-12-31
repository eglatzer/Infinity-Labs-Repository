package com.ilad.randomtest;

import java.util.Hashtable;
import java.util.Random;

public class RandomTest {
	
	private final int LOOPSNUMBER = 10000;
	private final int RANDOMRANGE = 6;
	private Hashtable<Integer, Integer> table = new Hashtable<>(RANDOMRANGE);
	private Random randomNumber = new Random();
	
	public boolean isRandom() {
		
		int currentValue = 0;
		double distribution = 0.0;
		
		for(int i = 0; i < RANDOMRANGE; ++i) {
			table.put(i, 0);
		}
		for(int i = 0; i < LOOPSNUMBER; ++i) {
			int rand = randomNumber.nextInt(RANDOMRANGE);
			currentValue = table.get(rand) + 1;
			table.put(rand, currentValue);
		}
		for(int i = 0; i < RANDOMRANGE; ++i) {
			distribution = (int)table.get(i) / (double)LOOPSNUMBER;
//			System.out.println(i + ". distribution" + " = " + distribution);
			if(distribution < 0.9 / RANDOMRANGE || distribution > 1.1 / RANDOMRANGE) {
				return false;
			}
		}
		
		return true;
	}
}