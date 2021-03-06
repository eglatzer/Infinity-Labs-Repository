package com.ilad.circularbuffer;

import javax.crypto.IllegalBlockSizeException;

public class CircularBuffer<E> {
	protected volatile E[] circularBuffer;
	protected int memCapacity;
	protected volatile int memUsed = 0;
	protected volatile int readIndex = 0;

	// Constructor
	@SuppressWarnings("unchecked")
	public CircularBuffer(int memCapacity_) throws IllegalBlockSizeException {
		if(0 >= memCapacity_) {
			throw new IllegalBlockSizeException("memCapacity_ should be positive!");
		}
		Object temp = new Object[memCapacity_];
		circularBuffer = (E[])temp;
		memCapacity = memCapacity_;
	}

	// Getters
	public int getMemCapacity() {
		return memCapacity;
	}

	public int getMemUsed() {
		return memUsed;
	}

	public int getMemFree() {
		return memCapacity - memUsed;
	}

	protected int getWriteIndex() {
		return (readIndex + memUsed) % memCapacity;
	}

	// Other Methods
	public boolean read(E outerBuffer) {
		if(0 == memUsed) {
			return false;
		}
		outerBuffer = circularBuffer[readIndex];
		--memUsed;
		readIndex = (readIndex + 1) % memCapacity;
		return true;
	}

	public boolean write(E outerBuffer) {
		if(0 == getMemFree()) {
			return false;
		}
		circularBuffer[getWriteIndex()] = outerBuffer;
		++memUsed;
		return true;
	}

	public void printCircularBufferContent() {
		for(int i = 0; i < memUsed; ++i) {
			System.out.print(circularBuffer[(readIndex + i) % memCapacity] + " ");
		}
		System.out.println();
	}
}
