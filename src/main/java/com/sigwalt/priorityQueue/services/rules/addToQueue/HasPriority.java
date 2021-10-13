package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;

public class HasPriority<T> extends AddToQueueRules<T> {

	public HasPriority(AddToQueueRules<T> nextRule) {
		super(nextRule);
	}

	@Override
	public boolean rule(Map<Integer, List<QueueItem<T>>> queue,int priority, T item) {
		if(queue.containsKey(priority)) {
			List<QueueItem<T>> itemList = queue.get(priority);
			itemList.add(new QueueItem<T>(item, priority));
			return true;
		}
		return false;
	}
	
	

	

}
