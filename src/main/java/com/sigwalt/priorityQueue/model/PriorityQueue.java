package com.sigwalt.priorityQueue.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueue <T>{
	
	private Map<Integer, List<QueueItem<T>>> queue;
	private int maxSize;
	
	public PriorityQueue(int maxSize){
		this.queue = new HashMap<Integer, List<QueueItem<T>>>();
		this.maxSize = maxSize;
	}

	public Map<Integer, List<QueueItem<T>>> getQueue() {
		return queue;
	}

	public int getMaxSize() {
		return maxSize;
	}

}
