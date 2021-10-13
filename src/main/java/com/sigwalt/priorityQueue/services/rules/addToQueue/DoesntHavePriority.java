package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;

public class DoesntHavePriority<T> extends AddToQueueRules<T> {
	
	public DoesntHavePriority(AddToQueueRules<T> nextRule) {
		super(nextRule);
	}

	@Override
	public boolean rule(Map<Integer, List<QueueItem<T>>> queue, int priority, T item) {
		List<QueueItem<T>> priorityList = new ArrayList<QueueItem<T>>();
		priorityList.add(new QueueItem<T>(item, priority));
		queue.put(priority, priorityList);
		return true;
	}

}
