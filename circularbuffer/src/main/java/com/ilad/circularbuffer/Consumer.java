package com.ilad.circularbuffer;

public class Consumer extends Thread {
	private ProtectedCircularBuffer<Integer> circularBuffer;
	private Integer[] consumer;
	private long waiting;

	// Constructor
	public Consumer(ProtectedCircularBuffer<Integer> circularBuffer_, Integer[] consumer_, long waiting_) {
		circularBuffer = circularBuffer_;
		consumer = consumer_;
		waiting = waiting_;
	}

	@Override
	public void run() {
		for(int i = 0; i < consumer.length; ++i) {
			System.out.print("Consumer number " + (i + 1) + ": ");
			circularBuffer.read(consumer[i]);
			circularBuffer.printCircularBufferContent();
			try {
				Thread.sleep(waiting);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
