package com.ilad.hanoitower;

import java.util.LinkedList;

public class HanoiTower {
	private static LinkedList<Integer> source;
	private static LinkedList<Integer> other;
	private static LinkedList<Integer> destination;
	private static int counter = 0;
	
	public static void play(int size) throws Exception {
		if(1 > size) {
			throw new Exception("This is an illegal size!");
		}
		source = new LinkedList<>();
		other = new LinkedList<>();
		destination = new LinkedList<>();
		
		for(int i = size; i > 0; --i) {
			source.add(i);
		}
		
		printStatus();
		play(size, source, other, destination);
	}
	
	private static void play(int size, LinkedList<Integer> src,
			LinkedList<Integer> oth, LinkedList<Integer> dest) {
		if(1 == size) {
			dest.add(src.removeLast());
			printStatus();
			return;
		}
		
		play(size - 1, src, dest, oth);
		play(1, src, oth, dest);
		play(size - 1, oth, src, dest);
	}
	
	private static void printStatus() {
		System.out.println(counter + ". source tower: " + source);
		System.out.println(counter + ". other tower: " + other);
		System.out.println(counter + ". destination tower: " + destination);
		System.out.println();
		++counter;
	}
}
