package com.sigwalt.priorityQueue.services.validations;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public class QueueIsNotEmptyValidation<T> extends Validation<T> {

	public QueueIsNotEmptyValidation(Map<Integer, List<QueueItem<T>>> queue, Validation<T> nextValidation) {
		super(queue, nextValidation);
	}

	@Override
	public void validation(QueueParameters<T> queueParameters) throws Exception {
		if(queueParameters.getCurrentSize() == 0 ) {
			throw new Exception("QueueIsEmpty");
		}
	}
	
	

}
