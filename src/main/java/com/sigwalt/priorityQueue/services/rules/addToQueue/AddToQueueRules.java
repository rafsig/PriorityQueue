package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;

public abstract class AddToQueueRules <T> {
	
	private AddToQueueRules<T> nextRule;
	
	public AddToQueueRules(AddToQueueRules<T> nextRule) {
		this.nextRule = nextRule;
	}
	
	public void execute(Map<Integer, List<QueueItem<T>>> queue, int priority, T queueItem) {
		if(!this.rule(queue, priority, queueItem)) {
			this.nextRule.execute(queue, priority, queueItem);
		}
	}
	
	public abstract boolean rule(Map<Integer, List<QueueItem<T>>> queue, int priority, T queueItem);
	
}
