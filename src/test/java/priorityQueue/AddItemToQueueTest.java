package priorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.AddItemToQueue;

public class AddItemToQueueTest {
	
	PriorityQueue<Integer> priorityQueue;
	
	AddItemToQueue<Integer> addItemToQueue;

	
	@BeforeEach
	public void setup() {
		priorityQueue = new PriorityQueue<Integer>(10);
		addItemToQueue = new AddItemToQueue<Integer>(priorityQueue);

	}
	
	@Test
	public void addAnItemToQueue() throws Exception {
		int priority = 1;
		int item = 10;
		addItemToQueue.execute(priority, item);
		Map<Integer, List<QueueItem<Integer>>> items = priorityQueue.getQueue();
		List<QueueItem<Integer>> priorityItems = items.get(priority);
		assertEquals(1 ,priorityItems.size());
		assertEquals(item , priorityItems.get(0).getItem());	
		
	}
	
	@Test
	public void addMoreItemsThanTheQueueCanHoldThrowsException() throws Exception {
		for(int i = 1; i <= 10; i++) {
			addItemToQueue.execute(i, i);
		}
		assertThrows(Exception.class,() -> { addItemToQueue.execute(11, 11); });
	}
	
	@Test
	public void priorityEqualsToZeroThrowsAnException() {
		assertThrows(Exception.class,() -> { addItemToQueue.execute(0, 11); });
	}
	
	@Test
	public void negativePriorityThrowsAnException() {
		assertThrows(Exception.class,() -> { addItemToQueue.execute(-1, 11); });
	}

}
