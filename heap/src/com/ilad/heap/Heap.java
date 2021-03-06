package com.ilad.heap;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	private ArrayList<E> heap;
	private boolean isMinHeap;
	
	// Constructors
	public Heap() {
		isMinHeap = true;
		heap = new ArrayList<>();
	}
	
	public Heap(boolean isMinHeap_) {
		isMinHeap = isMinHeap_;
		heap = new ArrayList<>();
	}
	
	// Getter
	public boolean isMinHeap() {
		return isMinHeap;
	}
	
	public boolean add(E element) {
		if(heap.add(element)) {
			setUp();
			return true;
		}
		return false;
	}
	
	private void setUp() {
		int index = heap.size() - 1;
		E element = heap.get(index);
		
		if(isMinHeap) {
			while(0 != index && 0 < heap.get((index - 1) / 2).compareTo(element)) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}
		else {
			while(0 != index && 0 > heap.get((index - 1) / 2).compareTo(element)) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}
	}
	
	public void clear() {
		heap.clear();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public E peek() {
		return heap.get(0);
	}
	
	public E pop() {
		E temp = heap.get(0);
		remove();
		return temp;
	}
	
	public void remove() {
		int lastIndex = heap.size() - 1;
		swap(0, lastIndex);
		heap.remove(lastIndex);
		setDown();
	}
	
	private void setDown() {
		int index = 0;
		int lastIndex = heap.size() - 1;
		while(index * 2 + 1 <= lastIndex) {
			int minOrMax = findMinOrMaxChild(index);
			if(minOrMax != index) {
				swap(index, minOrMax);
				index = minOrMax;
			}
			else {
				break;
			}
		}
	}
	
	private int findMinOrMaxChild(int index) {
		int lastIndex = heap.size() - 1;
		if(isMinHeap) {
			if(index * 2 + 1 == lastIndex) {
				return (0 > heap.get(lastIndex).compareTo(heap.get(index)) ?
						lastIndex : index);
			}
			
			int min = (0 > heap.get(index * 2 + 1).compareTo(heap.get(index)) ?
					index * 2 + 1 : index);
			return (0 > heap.get(index * 2 + 2).compareTo(heap.get(min)) ?
					index * 2 + 2 : min);
		}
		if(index * 2 + 1 == lastIndex) {
			return (0 < heap.get(lastIndex).compareTo(heap.get(index)) ?
					lastIndex : index);
		}
		int max = (0 < heap.get(index * 2 + 1).compareTo(heap.get(index)) ?
				index * 2 + 1 : index);
		return (0 < heap.get(index * 2 + 2).compareTo(heap.get(max)) ?
				index * 2 + 2 : max);
	}
	
	public int size() {
		return heap.size();
	}
	
	@Override
	public String toString() {
		int size = heap.size();
		String s = "[";
		for(int i = 0; i < size; ++i) {
			s += heap.get(i);
			if(i < size - 1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	
	private void swap(int index1, int index2) {
		E temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
}
