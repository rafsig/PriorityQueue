package priorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.DequeueItem;

public class DequeueItemTest {

	PriorityQueue<Integer> priorityQueue;

	DequeueItem<Integer> dequeueItem;
	
	int[] dequeueOrder =  {2, 5, 4, 11, 16, 7, 3, 19, 24, 9, 27, 30, 15, 8, 1, 31, 34, 20, 35, 22, 12, 26, 29, 13, 6, 14, 32, 17, 25, 10, 33, 21, 28, 18, 23};
	int[] priorityOrder = {1, 1, 3,  1,  1, 3, 4 , 1, 1, 3 , 1, 1, 3, 4, 5, 1, 1, 3, 1, 3, 4, 3, 3, 4, 5, 7, 3, 4, 4, 5, 4, 5, 7, 9, 5};

	@BeforeEach
	public void setup() {
		priorityQueue = new PriorityQueue<Integer>(priorityOrder.length);
		Map<Integer, Integer> priorityCounting = priorityQueue.getPriorityCounting();
		dequeueItem = new DequeueItem<Integer>(priorityQueue);
		
		Map<Integer, List<QueueItem<Integer>>> items = priorityQueue.getQueue();
		int priority = 1;
		ArrayList<QueueItem<Integer>> itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(2, priority));
		itemsList.add(new QueueItem<Integer>(5, priority));
		itemsList.add(new QueueItem<Integer>(11, priority));
		itemsList.add(new QueueItem<Integer>(16, priority));
		itemsList.add(new QueueItem<Integer>(19, priority));
		itemsList.add(new QueueItem<Integer>(24, priority));
		itemsList.add(new QueueItem<Integer>(27, priority));
		itemsList.add(new QueueItem<Integer>(30, priority));
		itemsList.add(new QueueItem<Integer>(31, priority));
		itemsList.add(new QueueItem<Integer>(34, priority));
		itemsList.add(new QueueItem<Integer>(35, priority));
		items.put(priority, itemsList);
		priorityCounting.put(priority, 0);
		
		priority = 3;
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(4, priority));
		itemsList.add(new QueueItem<Integer>(7, priority));
		itemsList.add(new QueueItem<Integer>(9, priority));
		itemsList.add(new QueueItem<Integer>(15, priority));
		itemsList.add(new QueueItem<Integer>(20, priority));
		itemsList.add(new QueueItem<Integer>(22, priority));
		itemsList.add(new QueueItem<Integer>(26, priority));
		itemsList.add(new QueueItem<Integer>(29, priority));
		itemsList.add(new QueueItem<Integer>(32, priority));
		items.put(priority, itemsList);
		priorityCounting.put(priority, 0);
		
		priority = 4;
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(3, priority));
		itemsList.add(new QueueItem<Integer>(8, priority));
		itemsList.add(new QueueItem<Integer>(12, priority));
		itemsList.add(new QueueItem<Integer>(13, priority));
		itemsList.add(new QueueItem<Integer>(17, priority));
		itemsList.add(new QueueItem<Integer>(25, priority));
		itemsList.add(new QueueItem<Integer>(33, priority));
		items.put(priority, itemsList);
		priorityCounting.put(priority, 0);
		
		priority = 5;
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(1, priority));
		itemsList.add(new QueueItem<Integer>(6, priority));
		itemsList.add(new QueueItem<Integer>(10, priority));
		itemsList.add(new QueueItem<Integer>(21, priority));
		itemsList.add(new QueueItem<Integer>(23, priority));
		items.put(priority, itemsList);
		priorityCounting.put(priority, 0);
		
		priority = 7;
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(14, priority));
		itemsList.add(new QueueItem<Integer>(28, priority));
		items.put(priority, itemsList);
		priorityCounting.put(priority, 0);
		
		priority = 9;
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(18, priority));
		items.put(priority, itemsList);
		priorityCounting.put(priority, 0);
		
		priorityQueue.setCurrentSize(dequeueOrder.length);	
	}

	@Test
	public void allItemsAreDequedInOrder() throws Exception {
		for(int i = 0 ; i < dequeueOrder.length; i++) {
			QueueItem<Integer> item = dequeueItem.execute();
			assertEquals(dequeueOrder[i], item.getItem());
			assertEquals(priorityOrder[i], item.getPriority());
		}
	}
	
	@Test
	public void throwsExceptionWhenListIsEmpty() throws Exception {
		for(int i = 0 ; i < dequeueOrder.length; i++) {
			dequeueItem.execute();
		}
		assertThrows(Exception.class, ()-> {dequeueItem.execute();});
	}
	
	@Test
	public void listSizeDecreasesWhenItemIsDequeued() throws Exception {
		int initialSize = priorityQueue.getCurrentSize();
		dequeueItem.execute();
		int finalSize = priorityQueue.getCurrentSize();

		assertEquals(initialSize - 1, finalSize);
	}

}
