package com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition;

import java.util.Map;

public class NextPriorityExists<T> extends DetermineNextPriorityRules<T> {

	public NextPriorityExists(Map<Integer, Integer> priorityCounting, DetermineNextPriorityRules<T> nextRule) {
		super(priorityCounting, nextRule);
	}

	@Override
	public int rule(int nextPriority) {
		if(nextPriority > 0 && this.priorityCounting.containsKey(nextPriority)) {
			return nextPriority;
		}
		return -1;
	}

}
