package com.sigwalt.priorityQueue.services;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;

public class DequeueItem<T> {
	
	private PriorityQueue<T> priorityQueue;
	
	public DequeueItem(PriorityQueue<T> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public QueueItem<T> execute(){
		Map<Integer, List<QueueItem<T>>> queue = priorityQueue.getQueue();
		
		if(queue.size() > 0) {
		
			Object[] priorities = queue.keySet().toArray();
			int nextPriority = (Integer) priorities[0];
			List<QueueItem<T>> itemsList = queue.get(nextPriority);
			QueueItem<T> queueItem = itemsList.remove(0);
			if(itemsList.size() == 0) {
				queue.remove(nextPriority);
			}
			return queueItem;
		}
		return null;
	}

}
