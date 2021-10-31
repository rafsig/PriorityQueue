package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.List;
import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.model.QueueParameters;

public abstract class DequeueRules<T> {
	
		protected DequeueRules<T> nextRule;
		protected Map<Integer, List<QueueItem<T>>> queue;
		protected QueueParameters<T> queueParameters;
		protected int nextPriority;

		public DequeueRules(DequeueRules<T> nextRule, Map<Integer, List<QueueItem<T>>> queue,
				QueueParameters<T> queueParameters, int nextPriority) {
			this.nextRule = nextRule;
			this.queue = queue;
			this.queueParameters = queueParameters;
			this.nextPriority = nextPriority;
		}

		public void execute() {
			if(!this.rule() && nextRule != null) {
				nextRule.execute();
			}
		}
		
		public abstract boolean rule();
}
