package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.DequeuedItem;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.PriorityCountingEqualsThrottling;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.PriorityCountingLessThanThrottling;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.UpdatePriorityCountingRules;

public class RemoveItem<T> {
	
	private Map<Integer, List<QueueItem<T>>> queue;

	public RemoveItem(Map<Integer, List<QueueItem<T>>> queue) {
		super();
		this.queue = queue;
	}

	public DequeuedItem<T> execute(QueueParameters<T> queueParameters, int nextPriority) throws Exception {
		Map<Integer, Integer> priorityCounting = queueParameters.getPriorityMap();
		
		int newPriorityCounting;
		
		List<QueueItem<T>> itemsList = queue.get(nextPriority);
		QueueItem<T> queueItem = itemsList.remove(0);
		if(itemsList.size() == 0) {
			queue.remove(nextPriority);
			queueParameters.getPriorityMap().remove(nextPriority);
		}
		else {
			UpdatePriorityCountingRules updatePriorityCounting = new PriorityCountingLessThanThrottling(priorityCounting, new PriorityCountingEqualsThrottling(priorityCounting, null));
			newPriorityCounting = updatePriorityCounting.execute(nextPriority);
			if(newPriorityCounting == 2) {
				nextPriority++;
			}
			else {
				nextPriority = (int) priorityCounting.keySet().toArray()[0];
			}
		}
		
		return new DequeuedItem<T>(queueItem, nextPriority);
	}

}
