package project2;

import project2.OrderedLinkedList.Node;
/**
 * Class meant to represent a sorted linked list
 * @author Justin Moroz
 *
 * @param <E>
 */
public class OrderedLinkedList  <E extends Comparable<E>>  implements OrderedList<E> {
	
	/**
	 * Nested class meant to represent elements within OrderedLinkedList class
	 * @author Justin Moroz
	 *
	 * @param <E>
	 */
	
	class Node<E>{
		private E element;
		private Node<E> nextNode;
		/**
		 * Constructs Node<E> object
		 * @param e
		 */
		public Node(E e){
			element = e;
			nextNode = null;
		}
		/**
		 * Returns element within Node<E>
		 * @return E
		 */
		public E getElement(){
			return element;}
		
		/**
		 * Returns next Node<E> in linked list
		 * @return Node <E>
		 */
		public Node<E> getNext(){
			return nextNode;}
		
		
		/**
		 * Sets next element of Node<E>
		 */
		public void setNext(Node<E> n){
			nextNode = n;}
		
		}
	// ------------------- End of Node<> Subclass ----------------------
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	
	/**
	 * Constructor for OrderedLinkedList
	 */
	public OrderedLinkedList(){}
	
	// Access methods
	
	/**
	 * Tests whether the list is empty 
	 * @return boolean
	 */
	public boolean isEmpty(){
		return size ==0;}
	
	/**
	 * Return first element
	 * @return Node<E>
	 */
	public Node<E> first(){
		if(isEmpty()) return null;
		return head;
	}
	
	/**
	 * Return last element
	 * @return Node<E>
	 */
	public Node<E> last(){
		if(isEmpty()) return null;
		return tail;
	}
	
	/**
	 * Returns the Node<E> representation of the object at given index
	 * @param index
	 * @return Node<E>
	 */
	
	public Node<E> getListInstance(int index){
		Node<E> current = head; 
		if (index > size || index<0){
			throw new IndexOutOfBoundsException();
		}
		while(current.getNext()!=null){
		//for (int x = 1; x<index; x++){
			current = current.getNext();
		}
		return current;
		
	}
	
	/**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range 
     * <tt>(index < 0 || index >= size())</tt>
     */
	public E get(int index){
		
		if (index > size || index<0){
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> current = head; 
		for (int i = 0; i < index; i++){ 
			current = current.getNext();
		}
		return current.getElement();
	}
	
	// Updater methods
	/**
     * Adds the specified element to  this list in a sorted order. 
     *
     * <p>The element added must implement Comparable<E> interface. This list 
     * does not permit null elements. 
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> if this collection changed as a result of the call
     * @throws ClassCastException if the class of the specified element
     *         does not implement Comparable<E> 
     * @throws NullPointerException if the specified element is null
     */
	public boolean add(E object){
		if (object == null){
			throw new NullPointerException();
		}
		
	   Node<E> insertThis = new Node<E>(object);
	   
		if (head == null){
			head = insertThis;
			size++;
			return true;
		}
		
		for (int x = 0; x<size; x++){
			
			if(insertThis.getElement().compareTo(get(x))>0){
				insertThis.setNext(null);
				getListInstance(x).setNext(insertThis);
				size++;
				return true;	
			}
		}	
			
			
			getListInstance(size).nextNode=insertThis;
			size++;
				
		
		return false;
		}
	
	
	/**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
	public void clear(){
		head = null;
		tail = null;
		size = 0; 
		}
		
	/**
     * Returns a shallow copy of this list. (The elements
     * themselves are not cloned.)
     *
     * @return a shallow copy of this list instance
     * @throws CloneNotSupportedException - if the object's class does 
     *         not support the Cloneable interface
     */
	public OrderedLinkedList<E> clone(){
		OrderedLinkedList<E> clone = this;	
		return clone;
	}
	
	/**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * @throws NullPointerException if the specified element is null **/
		
	public boolean contains (Object checkForThis){
		for (int x = 0; x<size;x++){
			if (get(x).equals(checkForThis)){
				return true;
			}
			
		}
		
			return false;
	}
	
	/**
     * Compares the specified object with this list for equality.  Returns
     * {@code true} if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements {@code e1} and
     * {@code e2} are <i>equal</i> if {@code e1.equals(e2)}.)  
     * In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.<p>
     *
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
	public boolean equals(OrderedLinkedList<E> compareThis){
		if (compareThis == this){
			return true;
		}
		else{
			return false;
		}
	}
	
	 /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	public int indexOf(Object checkForThis){
		if (checkForThis == null){
			throw new NullPointerException();
		}
		
		for (int x = 0; x<size; x++){
			if (checkForThis.equals(get(x))){
				return x;
			}
		}
		return -1; 
	}
	
	 /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices if such exist).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException  if the index is out of range 
     * <tt>(index < 0 || index >= size())</tt>
     */
	public E remove(int index){
		E currentObj = get(index);
		getListInstance(index-1).setNext(getListInstance(index+1));
		size--;
		return currentObj; 
	}
	
	
	 /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * <tt>(o.equals(get(i))</tt>
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     */
	public boolean remove(Object removeThis){
		if (contains(removeThis)){
			this.remove(indexOf(removeThis));
			size--;
			return true;
		}
		return false; 
	}
	
	
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
	public int size(){
		return size;
	}
	
	
	/**
     * Returns a string representation of this list.  The string
     * representation consists of a list of the list's elements in the
     * order they are stored in this list, enclosed in square brackets
     * (<tt>"[]"</tt>).  Adjacent elements are separated by the characters
     * <tt>", "</tt> (comma and space).  Elements are converted to strings 
     * by the {@code toString()} method of those elements.
     *
     * @return a string representation of this list
     */
	public String toString(){
		String fullString = new String();
		for (int x =0; x<size; x++){
			Color current =  (Color)get(x);
			fullString +=current.toString()+"/n";
		}
		return fullString;
	}
		
}
	


