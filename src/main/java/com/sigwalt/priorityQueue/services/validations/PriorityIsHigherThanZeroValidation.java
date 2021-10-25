package com.sigwalt.priorityQueue.services.validations;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public class PriorityIsHigherThanZeroValidation<T> extends Validation<T> {

	public PriorityIsHigherThanZeroValidation(Map<Integer, List<QueueItem<T>>> queue, Validation<T> nextValidation) {
		super(queue, nextValidation);
	}

	@Override
	public void validation(QueueParameters<T> queueParameters) throws Exception {
		if(queueParameters.getItem().getPriority() < 1) {
			throw new Exception("Priority must be 1 or higher");
		}
	}
	
	

}
