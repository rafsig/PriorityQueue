package com.sigwalt.priorityQueue.services.validations;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public abstract class Validation<T> {
	
	protected Map<Integer, List<QueueItem<T>>> queue;
	
	protected Validation<T> nextValidation;
	
	public Validation(Map<Integer, List<QueueItem<T>>> priorityQueue, Validation<T> nextValidation) {
		this.queue = priorityQueue;
		this.nextValidation = nextValidation;
	}

	public void execute(QueueParameters<T> queueParameters) throws Exception {
		this.validation(queueParameters);
		if(nextValidation != null) {
			nextValidation.execute(queueParameters);
		}
	}
	
	public abstract void validation(QueueParameters<T> queueParameters) throws Exception;
}
