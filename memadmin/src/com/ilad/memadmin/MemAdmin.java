package com.ilad.memadmin;

public class MemAdmin {
	private final int SIZE;
	private int[] arrayOfVals;
	private int[] arrayOfActionNumbers;
	private int actionNumber = 0;
	
	// Constructor
	public MemAdmin(int size) {
		SIZE = size;
		arrayOfVals = new int[SIZE + 1];
		arrayOfActionNumbers = new int[SIZE + 1];
	}
	
	public void setVal(int index, int val) throws Exception {
		if(SIZE <= index) {
			throw new Exception("Out of bounds!");
		}
		arrayOfActionNumbers[index] = actionNumber;
		arrayOfVals[index] = val;
		++actionNumber;
	}
	
	public void setAll(int val) {
		arrayOfActionNumbers[SIZE] = actionNumber;
		arrayOfVals[SIZE] = val;
		++actionNumber;
	}
	
	public int getVal(int index) throws Exception {
		if(SIZE <= index) {
			throw new Exception("Out of bounds!");
		}
		int val = (arrayOfActionNumbers[index] > arrayOfActionNumbers[SIZE] ?
				arrayOfVals[index] : arrayOfVals[SIZE]);
		return val;
	}
}
