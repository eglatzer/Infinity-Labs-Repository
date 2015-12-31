package com.ilad.suminarray;

import java.util.Hashtable;

public class SumInArray {

	private int[] array;
	private int sum;
	
	public SumInArray() {

	}
	public SumInArray(int[] array_, int sum_) {
		array = array_;
		sum = sum_;
	}
	
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array_) {
		array = array_;
	}
	public int getSum() {
		return sum;
	}
	public void setRank(int sum_) {
		sum = sum_;
	}
	
	public void findSum() {
		Hashtable<Integer, Integer> table = new Hashtable<>();
		int i;
		for(i = 0; i < array.length; ++i) {
			table.put(sum - array[i], i);
		}
		int counter = 0;
		for(i = 0; i < array.length; ++i) {
			if(true == table.containsKey(array[i]) && i < table.get(array[i])) {
				++counter;
				System.out.println(counter + ". index1 = " + i +
											 ", index2 = " + table.get(array[i]));
			}
		}
		if(0 == counter) {
			System.out.println("NOT EXIST!");
		}
	}
}
