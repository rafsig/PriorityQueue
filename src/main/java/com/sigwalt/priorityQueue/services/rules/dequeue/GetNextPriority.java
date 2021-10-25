package com.sigwalt.priorityQueue.services.rules.dequeue;

import java.util.Map;

import com.sigwalt.priorityQueue.model.QueueParameters;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityEqualsZero;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityExists;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityNotFoundAndHigherExists;
import com.sigwalt.priorityQueue.services.rules.dequeue.nextPriorityDefinition.NextPriorityNotFoundAndSmallerExists;

public class GetNextPriority<T> {


	public GetNextPriority() {
	}

	public int execute(QueueParameters<T> queueParameters) {
		Map<Integer, Integer> priorityCounting = queueParameters.getPriorityMap();
		int nextPriority = new NextPriorityNotFoundAndSmallerExists<T>(priorityCounting, 
				new NextPriorityNotFoundAndHigherExists<T>(priorityCounting,
						new NextPriorityExists<>(priorityCounting, 
								new NextPriorityEqualsZero<>(priorityCounting, null)))).execute(queueParameters);
		
		return nextPriority;
	}
}
