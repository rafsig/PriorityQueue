package com.sigwalt.priorityQueue.services.validations;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public class QueueHasRoomValidation<T> extends Validation<T> {

	public QueueHasRoomValidation(Map<Integer, List<QueueItem<T>>> queue, Validation<T> nextValidation) {
		super(queue, nextValidation);
	}

	@Override
	public void validation(QueueParameters<T> queueParameters) throws Exception {
		if(queueParameters.getCurrentSize() >= queueParameters.getMaxSize() ) {
			throw new Exception("Queue full\nMaxSize\t" + queueParameters.getMaxSize() + "\nCurrentSize\t" + queueParameters.getCurrentSize());
		}	
	}

}
