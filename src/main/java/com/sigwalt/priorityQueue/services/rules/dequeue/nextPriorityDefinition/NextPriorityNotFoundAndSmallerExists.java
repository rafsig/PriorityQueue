package com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition;

import java.util.Map;

public class NextPriorityNotFoundAndSmallerExists<T> extends DetermineNextPriorityRules<T> {

	public NextPriorityNotFoundAndSmallerExists(Map<Integer, Integer> priorityCounting,
			DetermineNextPriorityRules<T> nextRule) {
		super(priorityCounting, nextRule);
	}

	@Override
	public int rule(int nextPriority) {
		if (nextPriority > 0 && !this.priorityCounting.containsKey(nextPriority)) {

			Object[] prioritiesList = this.priorityCounting.keySet().toArray();

			int position = 0;
			while ((Integer) prioritiesList[position] < nextPriority && prioritiesList.length > 1) {
				position++;
			}
			return (Integer) prioritiesList[position];

		}
		return -1;
	}

}
