package com.sigwalt.priorityQueue.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.sigwalt.priorityQueue.services.AddItemToQueue;
import com.sigwalt.priorityQueue.services.DequeueItem;

public class PriorityQueue <T>{
	
	private final Map<Integer, List<QueueItem<T>>> queue = new HashMap<Integer, List<QueueItem<T>>>();
	private int maxSize;
	private int currentSize = 0;
	private int nextPriority = 0;
	private final Map<Integer, Integer> priorityCounting  = new HashMap<Integer, Integer>();
	private final AddItemToQueue<T> addItemToQueue = new AddItemToQueue<T>(this.queue);
	private final DequeueItem<T> dequeueItem = new DequeueItem<T>(this.queue);
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public PriorityQueue(int maxSize){
		this.maxSize = maxSize;
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

	public void addItem(QueueItem<T> item) throws Exception {
		lock.writeLock().lock();
		try {
			addItemToQueue.execute(new QueueParameters<T>(maxSize, currentSize, nextPriority, priorityCounting, item));
			this.currentSize++;
		}
		finally {
			lock.writeLock().unlock();
		}	
	}
	
	public QueueItem<T> dequeueItem() throws Exception {
		lock.writeLock().lock();
		DequeuedItem<T> dequeuedItem = null;
		try {
			dequeuedItem = dequeueItem.execute(new QueueParameters<T>(maxSize, currentSize, nextPriority, priorityCounting));
			this.currentSize--;
			this.nextPriority = dequeuedItem.getNextPriority();
			return dequeuedItem.getItem();
		}
		finally {
			lock.writeLock().unlock();
		}
	}
	
}
