package project3;

/**
 * This class represents a collection of Location objects, organized as a queue
 * @author Justin Moroz
 *
 */
public class PossibleLocationsQueue implements PossibleLocations {
	
	
	Location[] queueArray;
	int size;
	
	/**
	 * Initializes the queue with an array of size 100 and 0 number of elements
	 */
	public PossibleLocationsQueue(){
		
	 queueArray = new Location[100];
	 size = 0;
	}
	
	/**
	 * Initializes the queue with an array size based on parameter
	 * @param arraySize
	 */
	public PossibleLocationsQueue(int arraySize){
		
		 queueArray = new Location[arraySize];
		 size = 0;
	}
	
	
	
	/**
	 * Adds a single location object to the queue.
	 */
	public void add(Location s){
	
		//Check if array size limit has been reached and double it if needed
		if (queueArray.length == size){
			Location[] expanded = new Location[size*2];
			for (int x=0; x<size; x++){
				expanded[x]=queueArray[x];
			}
		expanded[size] = s;
		queueArray = expanded;
		size++;
		}
		
		else{
			queueArray[size] = s;
			size++;
		}
		
	}
	
	/**
	 * Removes the first element added from the queue and returns it
	 */
	public Location remove(){
		if(size == 0){
			return null;
		}
		
		else{
			Location returnThis = queueArray[0];
			for (int x = 0; x<=size-1; x++){
				queueArray[x]=queueArray[x+1];
			}
			size --;
			return returnThis;
		}
		
	}

	/**
	 * Boolean that returns true if the queue does not contain any elements and false if it does
	 */
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else{
			return false; 
		}
		
	}
}	
	
