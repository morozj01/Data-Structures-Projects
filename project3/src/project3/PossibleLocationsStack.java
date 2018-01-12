package project3;


/**
 * This class represents a collection of Location objects stored within a singly linked list. Implemented as a stack
 * @author Justin Moroz
 */
public class PossibleLocationsStack  implements PossibleLocations {
	
	
/**
 * Represents a node within the singly linked list
 * @author Justin Moroz
 *
 */
	class Node{
		Location data;
		Node next;
		
		public Node (Location data){
			this.data = data;
			next = null;
			
		
		}
		
		public Node getNext(){
			return this.next;
			
		}
		
		public Location getData(){
			return this.data;
		}
		
	}
	//First element
	Node top;
	
	/**
	 * Constructor that initializes the top node to null
	 */
	public PossibleLocationsStack(){
	top = null;
	}
	
	/**
	 * Add a single Location object to the top of the stack
	 */
	public void add(Location s){
		Node toBeAdded = new Node(s);
		
		if (isEmpty()){
			top = toBeAdded;	
		}
		
		else{
			toBeAdded.next = top;
			top = toBeAdded;
		}	
	}
	
	/**
	 * Returns the top Location object within the stack
	 */
	public Location remove(){
		Node beingRemoved = top;
		top = top.next;
		return beingRemoved.data;
	}
	
	/**
	 * Returns true if stack is empty, false if not empty. 
	 */
	public boolean isEmpty(){
		if (top == null){
			return true;
		}
		else{
			return false;
		}
		
	}
}
