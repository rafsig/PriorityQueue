package com.sigwalt.priorityQueue.model;

public class QueueItem <T>{
	
	private T item;
	private int priority;
	
	public QueueItem() {}
	public QueueItem(T item, int priority) {
		this.item = item;
		this.priority = priority;
	}
	
	
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

}
