package com.sigwalt.priorityQueue.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueue <T>{
	
	private Map<Integer, List<QueueItem<T>>> queue;
	private int maxSize;
	private int currentSize;
	private int nextPriority;
	private Map<Integer, Integer> priorityCounting;
	
	public PriorityQueue(int maxSize){
		this.queue = new HashMap<Integer, List<QueueItem<T>>>();
		priorityCounting = new HashMap<Integer, Integer>();
		currentSize = 0;
		nextPriority = 0;
		this.maxSize = maxSize;
	}
	
	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public Map<Integer, List<QueueItem<T>>> getQueue() {
		return queue;
	}
	
	public Map<Integer, Integer> getPriorityCounting() {
		return priorityCounting;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public int getNextPriority() {
		return nextPriority;
	}

	public void setNextPriority(int nextPriority) {
		this.nextPriority = nextPriority;
	}

}
