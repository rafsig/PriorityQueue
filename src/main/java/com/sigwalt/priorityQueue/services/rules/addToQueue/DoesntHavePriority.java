package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;

public class DoesntHavePriority<T> extends AddToQueueRules<T> {
	
	public DoesntHavePriority(Map<Integer,List<QueueItem<T>>> queue, AddToQueueRules<T> nextRule) {
		super(queue, nextRule);
	}

	@Override
	public boolean rule(Map<Integer, List<QueueItem<T>>> queue, QueueItem<T> queueItem) {
		List<QueueItem<T>> priorityList = new ArrayList<QueueItem<T>>();
		priorityList.add(queueItem);
		queue.put(queueItem.getPriority(), priorityList);
		return true;
	}

}
