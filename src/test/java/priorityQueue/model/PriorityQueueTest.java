package priorityQueue.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sigwalt.priorityQueue.model.DequeuedItem;
import com.sigwalt.priorityQueue.model.PriorityQueue;
import com.sigwalt.priorityQueue.model.QueueItem;
import com.sigwalt.priorityQueue.services.AddItemToQueue;
import com.sigwalt.priorityQueue.services.DequeueItem;

public class PriorityQueueTest {
	
	@InjectMocks
	PriorityQueue<Integer> priorityQueue = new PriorityQueue(10);
	
	@Mock
	AddItemToQueue<Integer> addItemToQueue;
	@Mock
	DequeueItem<Integer> dequeueItem;
	
	QueueItem<Integer> queueItem;
	
	
	@BeforeEach
	public void setup() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		queueItem = new QueueItem<>(1,1);
		DequeuedItem<Integer> dequeuedItem = new DequeuedItem<Integer>(queueItem, 1);
		
		doNothing().when(addItemToQueue).execute(any());
		when(dequeueItem.execute(any())).thenReturn(dequeuedItem);
	}
	
	@AfterEach
	public void finalize() {
	}
	
	@Test
	public void whenItemIsAddedToQueueCurrentSizeIsIncremented() throws Exception {
		int currentSize = priorityQueue.getCurrentSize();
		priorityQueue.addItem(queueItem);
		assertEquals(currentSize + 1, priorityQueue.getCurrentSize());
	}
	
	@Test
	public void whenItemIsDequeuedItemIsSentBackAndCurrentSizeIsDecremented() {
		
	}

}
