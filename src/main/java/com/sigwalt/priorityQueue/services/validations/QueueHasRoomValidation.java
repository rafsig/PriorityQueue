package com.sigwalt.priorityQueue.services.validations;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.rules.addToQueue.AddToQueueRules;

public class QueueHasRoomValidation<T> extends Validation<T> {

	public QueueHasRoomValidation(PriorityQueue<T> priorityQueue, Validation<T> nextValidation) {
		super(priorityQueue, nextValidation);
	}

	@Override
	public void validation(int priority) throws Exception {
		if(priorityQueue.getQueue().size() >= priorityQueue.getMaxSize() ) {
			throw new Exception("Queue reached maximum length");
		}	
	}

}
