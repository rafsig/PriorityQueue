package com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition;

import java.util.Map;

public class NextPriorityNotFoundAndHigherExists<T> extends DetermineNextPriorityRules<T> {

	public NextPriorityNotFoundAndHigherExists(Map<Integer, Integer> priorityCounting, DetermineNextPriorityRules<T> nextRule) {
		super(priorityCounting, nextRule);
	}

	@Override
	public int rule(int nextPriority) {
		Object[] prioritiesList =  this.priorityCounting.keySet().toArray();
		if(nextPriority > 0 &&  !this.priorityCounting.containsKey(nextPriority) &&  prioritiesList.length > 1) {
			return (Integer) prioritiesList[0];
		}
		return -1;
	}

}
