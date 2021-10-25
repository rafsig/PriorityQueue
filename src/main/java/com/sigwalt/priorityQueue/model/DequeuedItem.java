package com.sigwalt.priorityQueue.model;

public class DequeuedItem<T> {
	
	private QueueItem<T> item;
	private int nextPriority;
	
	public DequeuedItem(QueueItem<T> item, int nextPriority) {
		super();
		this.item = item;
		this.nextPriority = nextPriority;
	}

	public QueueItem<T> getItem() {
		return item;
	}

	public int getNextPriority() {
		return nextPriority;
	}
	
	

}
