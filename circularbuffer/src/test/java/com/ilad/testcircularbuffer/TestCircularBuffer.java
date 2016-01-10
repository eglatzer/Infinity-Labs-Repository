package com.ilad.testcircularbuffer;

import javax.crypto.IllegalBlockSizeException;


import com.ilad.circularbuffer.Consumer;
import com.ilad.circularbuffer.Producer;
import com.ilad.circularbuffer.ProtectedCircularBuffer;

public class TestCircularBuffer {
	public static void main(String[] args) throws IllegalBlockSizeException {
		ProtectedCircularBuffer<Integer> circularBuffer = new ProtectedCircularBuffer<>(7);
		Integer[] outerBufferProducer = new Integer[]{1, 2, 3, 4, 5, 6, 7};
		Integer[] outerBufferConsumer = new Integer[7];
		Producer producer = new Producer(circularBuffer, outerBufferProducer, 1000);
		Consumer consumer = new Consumer(circularBuffer, outerBufferConsumer, 3000);
		
		producer.start();
		consumer.start();
	}
}
