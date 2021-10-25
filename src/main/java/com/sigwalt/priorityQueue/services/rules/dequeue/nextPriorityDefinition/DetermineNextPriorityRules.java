package com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition;

import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueParameters;

public abstract class DetermineNextPriorityRules<T> {

	
	protected Map<Integer, Integer> priorityCounting;
	private DetermineNextPriorityRules<T> nextRule;

	public DetermineNextPriorityRules(Map<Integer, Integer> priorityCounting, DetermineNextPriorityRules<T> nextRule) {
		super();
		this.priorityCounting = priorityCounting;
		this.nextRule = nextRule;
	}

	public int execute(QueueParameters<T> queueParameters) {
		int priority = rule(queueParameters.getNextPriority());
		if (priority == -1 && nextRule != null) {
			return nextRule.execute(queueParameters);
		}
		return priority;
	}

	public abstract int rule(int nextPriority);
	
}
