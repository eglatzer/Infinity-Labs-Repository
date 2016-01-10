package com.ilad.circularbuffer;

import javax.crypto.IllegalBlockSizeException;

public class ProtectedCircularBuffer<E> extends CircularBuffer<E> {
	private volatile boolean isBusy = false;

	// Constructor
	public ProtectedCircularBuffer(int memCapacity_) throws IllegalBlockSizeException {
		super(memCapacity_);
	}

	// Other Methods
	@Override
	public boolean read(E outerBuffer) {
		boolean isSucceed = false;
		while(isBusy) {
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		isBusy = true;
		isSucceed = super.read(outerBuffer);
		isBusy = false;
		return isSucceed;
	}

	@Override
	public boolean write(E outerBuffer) {
		boolean isSucceed = false;
		while(isBusy) {
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		isBusy = true;
		isSucceed = super.write(outerBuffer);
		isBusy = false;
		return isSucceed;
	}
}
