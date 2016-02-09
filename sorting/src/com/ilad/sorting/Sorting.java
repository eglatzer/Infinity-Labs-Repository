package com.ilad.sorting;

public class Sorting<E extends Comparable<E>> {
	public void bubbleSort(E[] array) {
		boolean isOrdered = false;
		while(!isOrdered) {
			for(int i = 0; i < array.length - 1; ++i) {
				isOrdered = true;
				for(int j = 0; j < array.length - i - 1; ++j) {
					if(0 < array[j].compareTo(array[j + 1])) {
						isOrdered = false;
						swap(array[j], array[j + 1]);
					}
				}
			}
		}
	}
}
