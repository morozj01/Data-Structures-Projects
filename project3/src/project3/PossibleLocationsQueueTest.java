package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsQueueTest {


	@Test
	public void testPossibleLocationsQueue() {
		PossibleLocationsQueue testQueue = new PossibleLocationsQueue();
		assertEquals("Did not instantiate a stack with a first value of null", null, testQueue.queueArray[0]);
	}

	@Test
	public void testPossibleLocationsQueueInt() {
		PossibleLocationsQueue testQueue = new PossibleLocationsQueue(10);
		assertEquals("Did not instantiate a stack with a first value of null", null, testQueue.queueArray[0]);
		assertEquals("Array length did not match parameter",10,testQueue.queueArray.length);
	
	}

	@Test
	public void testAdd() {
		//Create a test Queue and add several objects to it
		PossibleLocationsQueue testQueue = new PossibleLocationsQueue();
		Location l1 = new Location(1,1);
		Location l2 = new Location(2,2);
		Location l3 = new Location(3,3);
		
		testQueue.add(l1);
		testQueue.add(l3);
		testQueue.add(l2);
		
		//Check for correct size
		assertEquals("Queue is does not contain correct amount of elements",3,testQueue.size);
		
		//Remove an object and check that the correct object has been removed
		Location removed = testQueue.remove();
		assertEquals("Incorrect element removed", l1, removed);
	}

	@Test
	public void testRemove() {
		
		//Create a test Queue and add several objects to it
		PossibleLocationsQueue testQueue = new PossibleLocationsQueue();
		Location l1 = new Location(1,1);
		Location l2 = new Location(2,2);
		Location l3 = new Location(3,3);
		
		testQueue.add(l1);
		testQueue.add(l2);
		testQueue.add(l3);
		
		//Remove several elements and check that they are removed in the correct order
		try{
			Location firstElement = testQueue.remove();
			assertEquals("Did not return correct reference", l1, firstElement);		
			
		} catch (NullPointerException e){
			fail("Returned null value");
		}
		
		try{
			Location secondElement = testQueue.remove();
			assertEquals("Did not return correct reference", l2, secondElement);
		} catch (NullPointerException e){
			fail("Returned null value");
		}
		
		try{
			Location thirdElement = testQueue.remove();
			assertEquals("Did not return correct reference", l3, thirdElement);
		} catch (NullPointerException e){
			fail("Returned null value");
		}
	}

	@Test
	public void testIsEmpty() {
		
		//Create a new test Queue and check that it is empty
		PossibleLocationsQueue testQueue = new PossibleLocationsQueue();
		assertTrue("Should return true", testQueue.isEmpty());
		
		//Add elements to the queue
		Location l1 = new Location(1,1);
		Location l2 = new Location(2,2);
		Location l3 = new Location(3,3);
		
		testQueue.add(l1);
		testQueue.add(l2);
		testQueue.add(l3);
		
		//Check again that is is empty
		assertFalse("Should return false", testQueue.isEmpty());
		
	}

}
