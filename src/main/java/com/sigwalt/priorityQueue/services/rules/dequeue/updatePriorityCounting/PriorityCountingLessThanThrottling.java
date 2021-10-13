package com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting;

import java.util.Map;

public class PriorityCountingLessThanThrottling extends UpdatePriorityCountingRules {

	

	public PriorityCountingLessThanThrottling(Map<Integer, Integer> priorityCounting,
			UpdatePriorityCountingRules nextRule) {
		super(priorityCounting, nextRule);
	}

	@Override
	public int update(int nextPriority, int priorityCounting) {
		if(priorityCounting < 2) {
			int newPriorityCounting = priorityCounting + 1;
			this.priorityCounting.put(nextPriority, newPriorityCounting);
			return newPriorityCounting;
		}
		return -1;
	}

}
