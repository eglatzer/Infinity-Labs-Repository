package com.ilad.heap;

import java.util.Random;

public class MainTest {

	public static void main(String[] args) {
		final int LENGTH = 15;
		final int RANGE = 100;
		int i;
		Random random = new Random();
		Heap<Integer> minHeap = new Heap<>();
		Heap<Integer> maxHeap = new Heap<>(false);
		
		System.out.println("minHeap.isMinHeap() = " + minHeap.isMinHeap());
		System.out.println("maxHeap.isMinHeap() = " + maxHeap.isMinHeap());
		System.out.println("minHeap.isempty() = " + minHeap.isEmpty());
		System.out.println("maxHeap.isempty() = " + maxHeap.isEmpty());
		System.out.println("minHeap.size() = " + minHeap.size());
		System.out.println("maxHeap.size() = " + maxHeap.size());
		
		for(i = 0; i < LENGTH; ++i) {
			int x = random.nextInt(RANGE);
			System.out.println("adding " + x + " to the heaps");
			minHeap.add(x);
			maxHeap.add(x);
			System.out.println("minHeap.peek() = " + minHeap.peek());
			System.out.println("maxHeap.peek() = " + maxHeap.peek());
			System.out.println("minHeap.isempty() = " + minHeap.isEmpty());
			System.out.println("maxHeap.isempty() = " + maxHeap.isEmpty());
			System.out.println("minHeap.size() = " + minHeap.size());
			System.out.println("maxHeap.size() = " + maxHeap.size());
		}
		
		System.out.println(minHeap);
		System.out.println(maxHeap);
		
		for(i = 0; i < LENGTH - 3; ++i) {
			System.out.println("minHeap.pop() = " + minHeap.pop());
			System.out.println("maxHeap.pop() = " + maxHeap.pop());
			System.out.println("minHeap.isempty() = " + minHeap.isEmpty());
			System.out.println("maxHeap.isempty() = " + maxHeap.isEmpty());
			System.out.println("minHeap.size() = " + minHeap.size());
			System.out.println("maxHeap.size() = " + maxHeap.size());
		}
		
		System.out.println("removing from the heaps");
		minHeap.remove();
		maxHeap.remove();
		System.out.println("minHeap.isempty() = " + minHeap.isEmpty());
		System.out.println("maxHeap.isempty() = " + maxHeap.isEmpty());
		System.out.println("minHeap.size() = " + minHeap.size());
		System.out.println("maxHeap.size() = " + maxHeap.size());
		System.out.println("clearing the heaps");
		minHeap.clear();
		maxHeap.clear();
		System.out.println("minHeap.isempty() = " + minHeap.isEmpty());
		System.out.println("maxHeap.isempty() = " + maxHeap.isEmpty());
		System.out.println("minHeap.size() = " + minHeap.size());
		System.out.println("maxHeap.size() = " + maxHeap.size());
		
		HeapSort<Integer> heapS = new HeapSort<>();
		Integer[] array = new Integer[LENGTH];
		System.out.println("Before sorting:");
		for(i = 0; i < LENGTH; ++i) {
			array[i] = random.nextInt(RANGE);
			System.out.print(array[i] + " ");
		}
		
		heapS.heapSort(array);
		System.out.println();
		System.out.println("After Heap Sort:");
		for(Integer element : array) {
			System.out.print(element + " ");
		}
	}
}
