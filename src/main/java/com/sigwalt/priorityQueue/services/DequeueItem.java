package com.sigwalt.priorityQueue.services;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.DequeuedItem;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;
import com.sigwalt.priorityQueue.services.rules.dequeue.GetNextPriority;
import com.sigwalt.priorityQueue.services.rules.dequeue.RemoveItem;
import com.sigwalt.priorityQueue.services.validations.QueueIsNotEmptyValidation;
import com.sigwalt.priorityQueue.services.validations.Validation;

public class DequeueItem<T> {
	
	private Map<Integer, List<QueueItem<T>>> queue;

	public DequeueItem(Map<Integer, List<QueueItem<T>>> queue) {
		this.queue = queue;
	}

	public DequeuedItem<T> execute(QueueParameters<T> queueParameters) throws Exception{
		
		Validation<T> validation = new QueueIsNotEmptyValidation<T>(queue, null);
		validation.execute(queueParameters);
	
		int nextPriority = new GetNextPriority<T>().execute(queueParameters);
		
		DequeuedItem<T> queueItem = new RemoveItem<T>(queue).execute(queueParameters, nextPriority);
		
		return queueItem;

	}

}
