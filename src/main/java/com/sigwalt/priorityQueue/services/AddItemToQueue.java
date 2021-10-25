package com.sigwalt.priorityQueue.services;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;
import com.sigwalt.priorityQueue.services.rules.addToQueue.AddToQueueRules;
import com.sigwalt.priorityQueue.services.rules.addToQueue.DoesntHavePriority;
import com.sigwalt.priorityQueue.services.rules.addToQueue.HasPriority;
import com.sigwalt.priorityQueue.services.validations.PriorityIsHigherThanZeroValidation;
import com.sigwalt.priorityQueue.services.validations.QueueHasRoomValidation;

public class AddItemToQueue<T>{
	
	private Map<Integer, List<QueueItem<T>>> queue;
	
	public AddItemToQueue(Map<Integer, List<QueueItem<T>>> priorityQueue){
		this.queue = priorityQueue;
	}
	
	public void execute(QueueParameters<T> queueParameters) throws Exception {
		new QueueHasRoomValidation<T>(queue, new PriorityIsHigherThanZeroValidation<T>(queue, null)).execute(queueParameters);
		
		AddToQueueRules<T> rules = new HasPriority<T>(queue, new DoesntHavePriority<T>(queue, null));
		rules.execute(queueParameters);
	}
	
}
