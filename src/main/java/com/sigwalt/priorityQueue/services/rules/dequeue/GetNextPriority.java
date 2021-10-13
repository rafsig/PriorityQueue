package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.Map;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityEqualsZero;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityExists;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityNotFoundAndHigherExists;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityNotFoundAndSmallerExists;

public class GetNextPriority<T> {

	private PriorityQueue<T> priorityQueue;

	public GetNextPriority(PriorityQueue<T> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public int execute() {
		Map<Integer, Integer> priorityCounting = priorityQueue.getPriorityCounting();
		int nextPriority = new NextPriorityNotFoundAndSmallerExists<T>(priorityCounting, 
				new NextPriorityNotFoundAndHigherExists<T>(priorityCounting,
						new NextPriorityExists<>(priorityCounting, 
								new NextPriorityEqualsZero<>(priorityCounting, null)))).execute(priorityQueue.getNextPriority());
		
		return nextPriority;
	}
}
