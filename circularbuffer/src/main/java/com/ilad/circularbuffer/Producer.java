package com.ilad.circularbuffer;

public class Producer extends Thread {
	private ProtectedCircularBuffer<Integer> circularBuffer;
	private Integer[] producer;
	private long waiting;

	// Constructor
	public Producer(ProtectedCircularBuffer<Integer> circularBuffer_, Integer[] producer_, long waiting_) {
		circularBuffer = circularBuffer_;
		producer = producer_;
		waiting = waiting_;
	}

	@Override
	public void run() {
		for(int i = 0; i < producer.length; ++i) {
			System.out.print("Producer number " + (i + 1) + ": ");
			circularBuffer.write(producer[i]);
			circularBuffer.printCircularBufferContent();
			try {
				Thread.sleep(waiting);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}