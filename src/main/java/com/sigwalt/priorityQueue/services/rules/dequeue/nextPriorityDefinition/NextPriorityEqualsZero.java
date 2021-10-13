package com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition;

import java.util.Map;

public class NextPriorityEqualsZero<T> extends DetermineNextPriorityRules<T> {

	public NextPriorityEqualsZero(Map<Integer, Integer> priorityCounting, DetermineNextPriorityRules<T> nextRule) {
		super(priorityCounting, nextRule);
	}

	@Override
	public int rule(int nextPriority) {
		if(nextPriority == 0) {
			return (Integer) this.priorityCounting.keySet().toArray()[0];
		}
		return -1;
	}

}
