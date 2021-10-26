package com.sigwalt.priorityQueue.services.rules.addToQueue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public abstract class AddToQueueRules <T> {
	
	private AddToQueueRules<T> nextRule;
	private Map<Integer, List<QueueItem<T>>> queue;
	
	
	public AddToQueueRules(Map<Integer,List<QueueItem<T>>> queue, AddToQueueRules<T> nextRule) {
		this.queue = queue;
		this.nextRule = nextRule;
	}
	
	public void execute(QueueParameters<T> queueParameters) {
		boolean ruleExecuted = !this.rule(queue, queueParameters);
		if(ruleExecuted) {
			this.nextRule.execute(queueParameters);
		}else {
			
		}
		
	}
	
	public abstract boolean rule(Map<Integer, List<QueueItem<T>>> queue, QueueParameters<T> queueParameters);
	
}
