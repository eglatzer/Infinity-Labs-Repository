package com.ilad.sorting;

import java.util.Random;
import static java.lang.Math.abs;

public class MainTest {
	public static void main(String[] args) {
		Random random = new Random();
		Sorting<Integer> sorting = new Sorting<>();
		final int LENGTH = 15;
		final int RANGE = 100;
		final int INT_MAX_NUM_OF_DIGITS = 10;
		final int RADIX = 10;
		Integer[] array = new Integer[LENGTH];
		int[] intArray = new int[LENGTH];
		int i = 0;
		
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(RANGE);
			System.out.print(array[i] + " ");
		}
		sorting.bubbleSort(array);
		System.out.println();
		System.out.println("After Bubble Sort:");
		for(Integer element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(RANGE);
			System.out.print(array[i] + " ");
		}
		sorting.insertionSort(array);
		System.out.println();
		System.out.println("After Insertion Sort:");
		for(Integer element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(RANGE);
			System.out.print(array[i] + " ");
		}
		sorting.selectionSort(array);
		System.out.println();
		System.out.println("After Selection Sort:");
		for(Integer element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(RANGE);
			System.out.print(array[i] + " ");
		}
		sorting.mergeSort(array);
		System.out.println();
		System.out.println("After Merge Sort:");
		for(Integer element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(RANGE);
			System.out.print(array[i] + " ");
		}
		sorting.quickSort(array);
		System.out.println();
		System.out.println("After Quick Sort:");
		for(Integer element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			intArray[i] = random.nextInt(RANGE);
			System.out.print(intArray[i] + " ");
		}
		sorting.countingSort(intArray, RANGE);
		System.out.println();
		System.out.println("After Counting Sort:");
		for(int element : intArray) {
			System.out.print(element + " ");
		}
		System.out.println();

		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			intArray[i] = abs(random.nextInt());
			System.out.print(intArray[i] + " ");
		}
		sorting.radixSort(intArray, INT_MAX_NUM_OF_DIGITS, RADIX);
		System.out.println();
		System.out.println("After Radix Sort:");
		for(int element : intArray) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
