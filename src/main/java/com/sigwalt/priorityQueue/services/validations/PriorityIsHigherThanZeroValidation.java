package com.sigwalt.priorityQueue.services.validations;

import com.sigwalt.priorityQueue.model.PriorityQueue;

public class PriorityIsHigherThanZeroValidation<T> extends Validation<T> {

	public PriorityIsHigherThanZeroValidation(PriorityQueue<T> priorityQueue, Validation<T> nextValidation) {
		super(priorityQueue, nextValidation);
	}

	@Override
	public void validation(int priority) throws Exception {
		if(priority < 1) {
			throw new Exception("Priority must be 1 or higher");
		}
	}
	
	

}
