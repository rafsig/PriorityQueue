package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;

public class HasPriority<T> extends AddToQueueRules<T> {

	public HasPriority(Map<Integer,List<QueueItem<T>>> queue, AddToQueueRules<T> nextRule) {
		super(queue, nextRule);
	}

	@Override
	public boolean rule(Map<Integer, List<QueueItem<T>>> queue, QueueItem<T> queueItem) {
		int priority = queueItem.getPriority();
		if(queue.containsKey(priority)) {
			List<QueueItem<T>> itemList = queue.get(priority);
			itemList.add(queueItem);
			return true;
		}
		return false;
	}
	
	

	

}
