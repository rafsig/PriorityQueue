package com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition;

import java.util.Map;

public abstract class DetermineNextPriorityRules<T> {

	
	protected Map<Integer, Integer> priorityCounting;
	private DetermineNextPriorityRules<T> nextRule;

	public DetermineNextPriorityRules(Map<Integer, Integer> priorityCounting, DetermineNextPriorityRules<T> nextRule) {
		super();
		this.priorityCounting = priorityCounting;
		this.nextRule = nextRule;
	}

	public int execute(int nextPriority) {
		int priority = rule(nextPriority);
		if (priority == -1 && nextRule != null) {
			return nextRule.execute(nextPriority);
		}
		return priority;
	}

	public abstract int rule(int nextPriority);
	
}
