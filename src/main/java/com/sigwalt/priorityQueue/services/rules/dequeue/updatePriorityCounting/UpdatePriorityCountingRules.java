package com.sigwalt.priorityQueue.services.rules.dequeue.updatePriorityCounting;

import java.util.Map;

public abstract class UpdatePriorityCountingRules {
	
	protected Map<Integer, Integer> priorityCounting;
	
	private UpdatePriorityCountingRules nextRule;
	
	public UpdatePriorityCountingRules(Map<Integer, Integer> priorityCounting, UpdatePriorityCountingRules nextRule) {
		this.priorityCounting = priorityCounting;
		this.nextRule = nextRule;
	}

	public int execute(int nextPriority) throws Exception{
		int newPriorityCounting = update(nextPriority, priorityCounting.get(nextPriority));
		if(newPriorityCounting != -1) {
			return newPriorityCounting;
		}
		if( newPriorityCounting == -1 && nextRule != null) {
			return nextRule.execute(nextPriority);
		}
		throw new Exception("No priority rule found");
	}
	
	public abstract int update(int nextPriority, int priorityCounting);
	
}
