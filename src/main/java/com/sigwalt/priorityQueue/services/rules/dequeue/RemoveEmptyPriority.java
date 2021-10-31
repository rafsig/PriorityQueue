package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public class RemoveEmptyPriority<T> extends DequeueRules<T> {

	

	

	public RemoveEmptyPriority(DequeueRules<T> nextRule, Map<Integer, List<QueueItem<T>>> queue, QueueParameters<T> queueParameters, int nextPriority) {
		super(nextRule, queue, queueParameters, nextPriority);
	}

	@Override
	public boolean rule() {
		if( queue.get(nextPriority).size() == 0) {
			queue.remove(nextPriority);
			queueParameters.getPriorityMap().remove(nextPriority);
			return true;
		}
		return false;
	}

}
