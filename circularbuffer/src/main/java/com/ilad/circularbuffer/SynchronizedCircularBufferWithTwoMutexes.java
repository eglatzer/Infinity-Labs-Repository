package com.ilad.circularbuffer;

import java.util.concurrent.Semaphore;

import javax.crypto.IllegalBlockSizeException;

public class SynchronizedCircularBufferWithTwoMutexes <E> extends CircularBuffer<E> {
	private Semaphore readSemaphore;
	private Semaphore writeSemaphore;
	private Object readMutex;
	private Object writeMutex;

	// Constructor
	public SynchronizedCircularBufferWithTwoMutexes(int memCapacity_) throws IllegalBlockSizeException {
		super(memCapacity_);
		readSemaphore = new Semaphore(memCapacity);
		try {
			readSemaphore.acquire(memCapacity);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		writeSemaphore = new Semaphore(memCapacity);
		readMutex = new Object();
		writeMutex = new Object();
	}

	// Other Methods
	@Override
	public boolean read(E outerBuffer) {
		try {
			readSemaphore.acquire();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(readMutex) {
			outerBuffer = circularBuffer[readIndex];
			--memUsed;
			readIndex = (readIndex + 1) % memCapacity;
		}
		writeSemaphore.release();
		return true;
	}
	
	@Override
	public boolean write(E outerBuffer) {
		try {
			writeSemaphore.acquire();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(writeMutex) {
			circularBuffer[getWriteIndex()] = outerBuffer;
			++memUsed;
		}
		readSemaphore.release();
		return true;
	}
}
