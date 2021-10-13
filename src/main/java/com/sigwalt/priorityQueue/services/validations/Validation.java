package com.sigwalt.priorityQueue.services.validations;

import com.sigwalt.priorityQueue.model.PriorityQueue;

public abstract class Validation<T> {
	
	protected PriorityQueue<T> priorityQueue;
	
	protected Validation<T> nextValidation;
	
	public Validation(PriorityQueue<T> priorityQueue, Validation<T> nextValidation) {
		this.priorityQueue = priorityQueue;
		this.nextValidation = nextValidation;
	}

	public void execute(int priority) throws Exception {
		this.validation(priority);
		if(nextValidation != null) {
			nextValidation.execute(priority);
		}
	}
	
	public abstract void validation(int priority) throws Exception;
}
