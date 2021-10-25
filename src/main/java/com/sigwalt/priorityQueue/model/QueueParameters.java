package com.sigwalt.priorityQueue.model;

import java.util.Map;

public class QueueParameters<T> {
	
	private int maxSize;
	private int currentSize;
	private int nextPriority;
	private Map<Integer, Integer> priorityMap;
	private QueueItem<T> item;

	public QueueParameters(int maxSize, int currentSize, int nextPriority, Map<Integer, Integer> priorityMap, QueueItem<T> item) {
		super();
		this.maxSize = maxSize;
		this.currentSize = currentSize;
		this.nextPriority = nextPriority;
		this.priorityMap = priorityMap;
		this.item = item;
	}
	
	public QueueParameters(int maxSize, int currentSize, int nextPriority, Map<Integer, Integer> priorityMap) {
		super();
		this.maxSize = maxSize;
		this.currentSize = currentSize;
		this.nextPriority = nextPriority;
		this.priorityMap = priorityMap;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public int getCurrentSize() {
		return currentSize;
	}
	
	public int getNextPriority() {
		return nextPriority;
	}
	
	public Map<Integer, Integer> getPriorityMap() {
		return priorityMap;
	}
	public QueueItem<T> getItem() {
		return item;
	}
	

	

}
