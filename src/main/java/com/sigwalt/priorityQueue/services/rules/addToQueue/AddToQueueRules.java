package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;

public abstract class AddToQueueRules <T> {
	
	private AddToQueueRules<T> nextRule;
	
	public AddToQueueRules(AddToQueueRules<T> nextRule) {
		this.nextRule = nextRule;
	}
	
	public void execute(PriorityQueue<T> queue, int priority, T queueItem) {
		boolean ruleExecuted = !this.rule(queue.getQueue(), priority, queueItem);
		if(ruleExecuted) {
			this.nextRule.execute(queue, priority, queueItem);
		}else {
			queue.setCurrentSize(queue.getCurrentSize() + 1);
		}
		
	}
	
	public abstract boolean rule(Map<Integer, List<QueueItem<T>>> queue, int priority, T queueItem);
	
}
