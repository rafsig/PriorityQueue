package com.sigwalt.priorityQueue.services.validations;

import com.sigwalt.priorityQueue.model.PriorityQueue;

public class QueueIsNotEmptyValidation<T> extends Validation<T> {

	public QueueIsNotEmptyValidation(PriorityQueue<T> priorityQueue, Validation<T> nextValidation) {
		super(priorityQueue, nextValidation);
	}

	@Override
	public void validation(int priority) throws Exception {
		if(priorityQueue.getCurrentSize() == 0 ) {
			throw new Exception("QueueIsEmpty");
		}
	}
	
	

}
