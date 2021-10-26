package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public class HasPriority<T> extends AddToQueueRules<T> {

	public HasPriority(Map<Integer,List<QueueItem<T>>> queue, AddToQueueRules<T> nextRule) {
		super(queue, nextRule);
	}

	@Override
	public boolean rule(Map<Integer, List<QueueItem<T>>> queue, QueueParameters<T> queueParameters) {
		int priority = queueParameters.getItem().getPriority();
		if(queue.containsKey(priority)) {
			List<QueueItem<T>> itemList = queue.get(priority);
			itemList.add(queueParameters.getItem());
			return true;
		}
		return false;
	}
	
	

	

}
