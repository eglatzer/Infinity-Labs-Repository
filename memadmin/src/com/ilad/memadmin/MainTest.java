package com.ilad.memadmin;

public class MainTest {
	public static void main(String[] args) throws Exception {
		final int SIZE = 10;
		MemAdmin memAdmin = new MemAdmin(SIZE);
		memAdmin.setAll(4);
		memAdmin.setVal(3, 5);
		memAdmin.setVal(6, 3);
		memAdmin.setAll(0);
		memAdmin.setVal(1, 9);
		memAdmin.setVal(2, 5);
		memAdmin.setVal(1, 7);
		memAdmin.setVal(5, 8);
		memAdmin.setVal(6, 4);
		for(int i = 0; i < SIZE; ++i) {
			System.out.print(memAdmin.getVal(i) + " ");
		}
	}
}
