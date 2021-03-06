package com.ilad.circularbuffer;

import java.util.concurrent.Semaphore;

import javax.crypto.IllegalBlockSizeException;

public class SynchronizedCircularBufferWithOneMutex<E> extends CircularBuffer<E> {
	private Semaphore readSemaphore;
	private Semaphore writeSemaphore;

	// Constructor
	public SynchronizedCircularBufferWithOneMutex(int memCapacity_) throws IllegalBlockSizeException {
		super(memCapacity_);
		readSemaphore = new Semaphore(memCapacity);
		try {
			readSemaphore.acquire(memCapacity);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		writeSemaphore = new Semaphore(memCapacity);
	}
	
	// Other Methods
	@Override
	synchronized public boolean read(E outerBuffer) {
		try {
			readSemaphore.acquire();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		outerBuffer = circularBuffer[readIndex];
		--memUsed;
		readIndex = (readIndex + 1) % memCapacity;
		writeSemaphore.release();
		return true;
	}
	
	@Override
	synchronized public boolean write(E outerBuffer) {
		try {
			writeSemaphore.acquire();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		circularBuffer[getWriteIndex()] = outerBuffer;
		++memUsed;
		return true;
	}
}
