package com.sigwalt.priorityQueue.services.validations;

import com.sigwalt.priorityQueue.model.PriorityQueue;

public class QueueHasRoomValidation<T> extends Validation<T> {

	public QueueHasRoomValidation(PriorityQueue<T> priorityQueue, Validation<T> nextValidation) {
		super(priorityQueue, nextValidation);
	}

	@Override
	public void validation(int priority) throws Exception {
		if(priorityQueue.getCurrentSize() >= priorityQueue.getMaxSize() ) {
			throw new Exception("Queue full\nMaxSize\t" + priorityQueue.getMaxSize() + "\nCurrentSize\t" + priorityQueue.getCurrentSize());
		}	
	}

}
