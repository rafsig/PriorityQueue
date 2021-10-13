package priorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.AddItemToQueue;
import com.sigwalt.priorityQueue.services.DequeueItem;

public class DequeueItemTest {

	PriorityQueue<Integer> priorityQueue;

	DequeueItem<Integer> dequeueItem;
	
	int[] dequeueOrder = {2,5,4,6,3,1};
	int[] priorityOrder = {2,2,5,5,6,8};

	@BeforeEach
	public void setup() {
		priorityQueue = new PriorityQueue<Integer>(10);
		dequeueItem = new DequeueItem<Integer>(priorityQueue);
		
		Map<Integer, List<QueueItem<Integer>>> items = priorityQueue.getQueue();
		ArrayList<QueueItem<Integer>> itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(1, 8));
		items.put(8, itemsList);
		
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(2, 2));
		itemsList.add(new QueueItem<Integer>(5, 2));
		items.put(2, itemsList);
		
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(4, 5));
		itemsList.add(new QueueItem<Integer>(6, 5));
		items.put(5, itemsList);
		
		itemsList = new ArrayList<QueueItem<Integer>>();
		itemsList.add(new QueueItem<Integer>(3, 6));
		items.put(6, itemsList);
	}

	@Test
	public void allItemsAreDequedInOrder() {
		for(int i = 0 ; i < dequeueOrder.length; i++) {
			QueueItem<Integer> item = dequeueItem.execute();
			
			assertEquals(dequeueOrder[i], item.getItem());
			assertEquals(priorityOrder[i], item.getPriority());
		}
	}
	
	@Test
	public void returnsNullWhenListIsEmpty() {
		for(int i = 0 ; i < dequeueOrder.length; i++) {
			QueueItem<Integer> item = dequeueItem.execute();
		}
		
		QueueItem<Integer> item = dequeueItem.execute();
		assertNull(item);
	}

}
