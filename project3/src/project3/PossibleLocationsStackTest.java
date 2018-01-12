package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsStackTest {

	@Test
	public void testPossibleLocationsStack() {
		PossibleLocationsStack testStack = new PossibleLocationsStack();
		assertEquals("Did not instantiate a stack with a top value of null", null, testStack.top);
	}

	@Test
	public void testAdd() {
		PossibleLocationsStack testStack = new PossibleLocationsStack();
		Location l1 = new Location(1,1);
		Location l2 = new Location(2,2);
		Location l3 = new Location(3,3);
		
		testStack.add(l1);
		testStack.add(l3);
		testStack.add(l2);
		
		assertEquals("Returned incorrect reference as top of stack", l2, testStack.top.getData());
		assertEquals("Returned incorrect reference as second element of stack",l3, testStack.top.getNext().getData());
	}


	@Test
	public void testRemove() {
		PossibleLocationsStack testStack = new PossibleLocationsStack();
		Location l1 = new Location(1,1);
		Location l2 = new Location(2,2);
		Location l3 = new Location(3,3);
		
		testStack.add(l1);
		testStack.add(l3);
		testStack.add(l2);
		
		try{
			Location firstElement = testStack.remove();
			assertEquals("Did not return correct reference", l2, firstElement);
		} catch (NullPointerException e){
			fail("Returned null value");
		}
		
		try{
			Location secondElement = testStack.remove();
			assertEquals("Did not return correct reference", l3, secondElement);
		} catch (NullPointerException e){
			fail("Returned null value");
		}
		
		try{
			Location thirdElement = testStack.remove();
			assertEquals("Did not return correct reference", l1, thirdElement);
		} catch (NullPointerException e){
			fail("Returned null value");
		}
		
	}

	@Test
	public void testIsEmpty() {
		PossibleLocationsStack testStack = new PossibleLocationsStack();
		assertTrue("Should return true", testStack.isEmpty());
		
		Location l1 = new Location(1,1);
		testStack.add(l1);
		
		assertFalse("Should return false", testStack.isEmpty());
		
	}

}
