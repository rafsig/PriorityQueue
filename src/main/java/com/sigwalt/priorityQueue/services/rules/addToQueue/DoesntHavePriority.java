package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public class DoesntHavePriority<T> extends AddToQueueRules<T> {
	
	public DoesntHavePriority(Map<Integer,List<QueueItem<T>>> queue, AddToQueueRules<T> nextRule) {
		super(queue, nextRule);
	}

	@Override
	public boolean rule(Map<Integer, List<QueueItem<T>>> queue, QueueParameters<T> queueParameters) {
		List<QueueItem<T>> priorityList = new ArrayList<QueueItem<T>>();
		QueueItem<T> queueItem = queueParameters.getItem();
		priorityList.add(queueItem);
		queue.put(queueItem.getPriority(), priorityList);
		queueParameters.getPriorityMap().put(queueItem.getPriority(), 0);
		return true;
	}

}
