package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.PriorityCountingEqualsThrottling;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.PriorityCountingLessThanThrottling;
import com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting.UpdatePriorityCountingRules;

public class UpdatePriorityCounting<T> extends DequeueRules<T> {

	

	public UpdatePriorityCounting(DequeueRules<T> nextRule, Map<Integer, List<QueueItem<T>>> queue, QueueParameters<T> queueParameters, int nextPriority) {
		super(nextRule, queue, queueParameters, nextPriority);
	}

	@Override
	public boolean rule() {
		
		try {
			int newPriorityCounting;
			
			Map<Integer, Integer> priorityCounting = queueParameters.getPriorityMap();
			UpdatePriorityCountingRules updatePriorityCounting = new PriorityCountingLessThanThrottling(priorityCounting,
					new PriorityCountingEqualsThrottling(priorityCounting, null));
			newPriorityCounting = updatePriorityCounting.execute(nextPriority);
			if (newPriorityCounting == 2) {
				nextPriority++;
			} else {
				nextPriority = (int) priorityCounting.keySet().toArray()[0];
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
