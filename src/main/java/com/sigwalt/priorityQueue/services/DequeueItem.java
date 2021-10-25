package com.sigwalt.priorityQueue.services;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.rules.dequeue.GetNextPriority;
import com.sigwalt.priorityQueue.services.rules.dequeue.RemoveItem;
import com.sigwalt.priorityQueue.services.validations.QueueIsNotEmptyValidation;
import com.sigwalt.priorityQueue.services.validations.Validation;

public class DequeueItem<T> {

	private PriorityQueue<T> priorityQueue;

	public DequeueItem(PriorityQueue<T> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public QueueItem<T> execute() throws Exception{
		
		Validation<T> validation = new QueueIsNotEmptyValidation<T>(priorityQueue, null);
		validation.execute(priorityQueue.getNextPriority());
	
		int nextPriority = new GetNextPriority<>(priorityQueue).execute();
		
		QueueItem<T> queueItem = new RemoveItem<T>(priorityQueue).execute(nextPriority);
		
		return queueItem;

	}

}
