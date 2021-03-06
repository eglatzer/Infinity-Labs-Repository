package com.ilad.sumpairoutofarray;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class SumPairOutOfArray {
	public static int first = 0;
	public static int second = 0;
	
	public static void findPairWhichSum(ArrayList<Integer> array, int sum) {
		int i;
		int length = array.size();
		Hashtable<Integer, Integer> table = new Hashtable<>();
		for(i = 0; i < length; ++i) {
			if(table.containsKey(array.get(i))) {
				first = array.get(i);
				second = array.get(table.get(array.get(i)));
				table.put(sum - array.get(i), i);
				break;
			}
			table.put(sum - array.get(i), i);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		Random random = new Random();
		int sum = random.nextInt(20);
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		array.add(random.nextInt(20));
		SumPairOutOfArray.findPairWhichSum(array, sum);
		System.out.println("sum = " + sum);
		System.out.println(array);
		if(sum == first + second) {
			System.out.println("first = " + first + ", second = " + second);
		}
		else {
			System.out.println("There isn't pair which summed to " + sum);
		}
	}
}
