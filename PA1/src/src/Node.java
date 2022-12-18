/**
 * Node.java
 * This class provides the implementation of a doubly linked list node. These nodes should have a 
 * pointer to the next node, a pointer to the previous node, and data.
 * @author:Aerionna Stephenson
 * date:December 12, 2022
 */
package src;

public class Node<T> {

	T element;
	Node<T> next;
	Node<T> prev;

	public Node(T data) {
		this.element = data;
		
		this.next = null;
		this.prev = null;
	}

	//getters
	public T getElement() {
		return this.element;
	}
	
	public Node<T> getNext() {
		
		return this.next;
	}
	public Node<T> getPrev(){
		return this.prev;
	}

	//setters
	public void setElement(T element) {
		this.element = element;
	}

	public void setNext(Node<T> next) {
		this.next= next;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev=prev;
	}


	/**
	 *@return returns the String representation of this node’s element
	 */
	public String toString() {
		return "element : " + element;
	}
		
}
