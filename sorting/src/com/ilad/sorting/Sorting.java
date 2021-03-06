package com.ilad.sorting;

import java.util.Arrays;

import static java.lang.Math.pow;

public class Sorting<E extends Comparable<E>> {
	public void bubbleSort(E[] array) {
		boolean isOrdered;
		for(int i = 0; i < array.length - 1; ++i) {
			isOrdered = true;
			for(int j = 0; j < array.length - i - 1; ++j) {
				if(0 < array[j].compareTo(array[j + 1])) {
					isOrdered = false;
					swap(array, j, j + 1);
				}
			}
			if(isOrdered) {
				break;
			}
		}
	}
	
	public void insertionSort(E[] array) {
		E copyElement;
		for(int i = 1; i < array.length; ++i) {
			copyElement = array[i];
			for(int j = i - 1; j >= 0; --j) {
				if(0 < array[j].compareTo(copyElement)) {
					array[j + 1] = array[j];
					if(0 == j) {
						array[j] = copyElement;
					}
				}
				else {
					array[j + 1] = copyElement;
					break;
				}
			}
		}
	}

	public void selectionSort(E[] array) {
		int minIndex;
		for(int i = 0; i < array.length - 1; ++i) {
			minIndex = i;
			for(int j = i + 1; j < array.length; ++j) {
				if(0 < array[minIndex].compareTo(array[j])) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}
	
	public void mergeSort(E[] array) {
		if(2 > array.length) {
			return;
		}
		int leftLength = array.length / 2;
		int rightLength = array.length - leftLength;
		GenericArray genericArray = new GenericArray();
		E[] leftArray = genericArray.getArrayInstance(array, leftLength);
		System.arraycopy(array, 0, leftArray, 0, leftLength);
		E[] rightArray = genericArray.getArrayInstance(array, rightLength);
		System.arraycopy(array, leftLength, rightArray, 0, rightLength);
		
		mergeSort(leftArray);
		mergeSort(rightArray);
		
		mergeByOrder(array, 0, leftArray, leftLength, 0,
				rightArray, rightLength, 0);		
	}
	
	private void mergeByOrder(E[] array, int index,
			E[] leftArray, int leftLength, int leftIndex,
			E[] rightArray, int rightLength, int rightIndex) {
		if(0 == leftLength) {
			System.arraycopy(rightArray, rightIndex, array, index, rightLength);
			return;
		}
		
		if(0 == rightLength) {
			System.arraycopy(leftArray, leftIndex, array, index, leftLength);
			return;
		}
		
		if(0 < leftArray[leftIndex].compareTo(rightArray[rightIndex])) {
			array[index] = rightArray[rightIndex];
			++rightIndex;
			--rightLength;
		}
		
		else {
			array[index] = leftArray[leftIndex];
			++leftIndex;
			--leftLength;
		}
		
		++index;
		mergeByOrder(array, index, leftArray, leftLength, leftIndex,
				rightArray, rightLength, rightIndex);
	}
	
	public void quickSort(E[] array) {
		recursiveQuickSort(array, 0, array.length - 1);
	}
	
	private void recursiveQuickSort(E[] array, int begin, int end) {
		if(begin >= end) {
			return;
		}
		int i = begin;
		int j = end;
		int pivot = (begin + end) / 2;
		
		while(i < j) {			
			while(i < pivot && 0 > array[i].compareTo(array[pivot])) {
				++i;
			}
			
			while(pivot < j && 0 <= array[j].compareTo(array[pivot])) {
				--j;
			}
			
			if(i < j) {
				swap(array, i , j);
			}
			
			if(pivot == i) {
				pivot = j;
			}
			
			else if(pivot == j) {
				pivot = i;
			}
			
			recursiveQuickSort(array, begin, pivot);
			recursiveQuickSort(array, pivot + 1, end);
		}
	}
	
	public void countingSort(int[] array, int range) {
		int i;
		int[] indexArray = new int[range];
		int[] sortedArray = new int[array.length];
		
		Arrays.fill(indexArray, 0);
		
		for(i = 0; i < array.length; ++i) {
			++indexArray[array[i]];
		}
		
		for(i = 1; i < range; ++i) {
			indexArray[i] += indexArray[i - 1];
		}
		
		for(i = array.length - 1; i >= 0; --i) {
			--indexArray[array[i]];
			sortedArray[indexArray[array[i]]] = array[i];
		}
		
		for(i = 0; i < array.length; ++i) {
			array[i] = sortedArray[i];
		}
	}
	
	public void radixSort(int[] array, int maxNumOfDigits, int radix) {
		for(int i = 0; i < maxNumOfDigits; ++i) {
			countingSort(array, i, radix);
		}
	}
	
	// This method aimed to service the radixSort method
	private void countingSort(int[] array, int digitNumber, int range) {
		int i;
		int index;
		int[] indexArray = new int[range];
		int[] sortedArray = new int[array.length];
		
		Arrays.fill(indexArray, 0);
		
		for(i = 0; i < array.length; ++i) {
			index = getDigit(array[i], digitNumber, range);
			++indexArray[index];
		}
		
		for(i = 1; i < range; ++i) {
			indexArray[i] += indexArray[i - 1];
		}
		
		for(i = array.length - 1; i >= 0; --i) {
			index = getDigit(array[i], digitNumber, range);
			--indexArray[index];
			sortedArray[indexArray[index]] = array[i];
		}
		
		for(i = 0; i < array.length; ++i) {
			array[i] = sortedArray[i];
		}
	}
	
	private int getDigit(int number, int digitNumber, int radix) {
		return (int)((number % pow(radix, (digitNumber + 1))) / pow(radix, digitNumber));
	}
	
	private void swap(E[] array, int index1, int index2) {
		E temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}