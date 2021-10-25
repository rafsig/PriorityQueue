package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.PriorityCountingEqualsThrottling;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.PriorityCountingLessThanThrottling;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.UpdatePriorityCountingRules;

public class RemoveItem<T> {
	
	private PriorityQueue<T> priorityQueue;

	public RemoveItem(PriorityQueue<T> priorityQueue) {
		super();
		this.priorityQueue = priorityQueue;
	}

	public QueueItem<T> execute(int nextPriority) throws Exception {
		Map<Integer, List<QueueItem<T>>> queue = priorityQueue.getQueue();
		Map<Integer, Integer> priorityCounting = priorityQueue.getPriorityCounting();
		
		int newPriorityCounting;
		
		List<QueueItem<T>> itemsList = queue.get(nextPriority);
		QueueItem<T> queueItem = itemsList.remove(0);
		if(itemsList.size() == 0) {
			queue.remove(nextPriority);
			priorityQueue.getPriorityCounting().remove(nextPriority);
		}
		else {
			UpdatePriorityCountingRules updatePriorityCounting = new PriorityCountingLessThanThrottling(priorityCounting, new PriorityCountingEqualsThrottling(priorityCounting, null));
			newPriorityCounting = updatePriorityCounting.execute(nextPriority);
			if(newPriorityCounting == 2) {
				this.priorityQueue.setNextPriority(nextPriority + 1);
			}
			else {
				this.priorityQueue.setNextPriority((Integer) priorityCounting.keySet().toArray()[0]);
			}
		}
		this.priorityQueue.setCurrentSize(this.priorityQueue.getCurrentSize() - 1);
		return queueItem;
	}

}
