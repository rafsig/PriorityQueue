package com.sigwalt.priorityQueue.services;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.rules.addToQueue.AddToQueueRules;
import com.sigwalt.priorityQueue.services.rules.addToQueue.DoesntHavePriority;
import com.sigwalt.priorityQueue.services.rules.addToQueue.HasPriority;
import com.sigwalt.priorityQueue.services.validations.PriorityIsHigherThanZeroValidation;
import com.sigwalt.priorityQueue.services.validations.QueueHasRoomValidation;

public class AddItemToQueue<T>{
	
	private PriorityQueue<T> priorityQueue;
	
	public AddItemToQueue(PriorityQueue<T> priorityQueue){
		this.priorityQueue = priorityQueue;
	}
	
	public void execute(int priority, T queueItem) throws Exception {
		new QueueHasRoomValidation<T>(priorityQueue, new PriorityIsHigherThanZeroValidation<T>(priorityQueue, null)).execute(priority);;
		
		AddToQueueRules<T> rules = new HasPriority<T>(new DoesntHavePriority<T>(null));
		rules.execute(priorityQueue, priority, queueItem);
	}
	
}
