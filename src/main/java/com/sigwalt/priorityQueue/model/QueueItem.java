package com.sigwalt.priorityQueue.model;

public class QueueItem <T>{
	
	private T item;
	private int priority;
	
	public QueueItem(T item, int priority) {
		this.item = item;
		this.priority = priority;
	}
	
	
	public T getItem() {
		return item;
	}

	public int getPriority() {
		return priority;
	}
	
}
