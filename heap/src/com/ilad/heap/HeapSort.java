package com.ilad.heap;

public class HeapSort<E extends Comparable<E>> {
	public void heapSort(E[] array) {
		Heap<E> heap = new Heap<>();
		
		for(E element : array) {
			heap.add(element);
		}
		
		for (int i = 0; i < array.length; ++i) {
			array[i] = heap.pop();
		}
	}
}