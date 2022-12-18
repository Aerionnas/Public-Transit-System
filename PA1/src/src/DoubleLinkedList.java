/**
 * DoubleLinkedList.java
 * This class provides the implementation of a generic non-circular doubly linked list.
 * 
 * @author:Aerionna Stephenson
 * date:December 12, 2022
 */
package src;

public class DoubleLinkedList<T> {

	Node<T> head;
	Node<T> tail;
	int length;

	public DoubleLinkedList() {

		length = 0;
		this.head = null;
		this.tail = null;

	}

	// getters
	public Node<T> getHead() {

		return head;

	}

	public Node<T> getTail() {

		return tail;

	}

	/**
	 * This method adds an element to the end of this list.
	 * 
	 * @param key is the key for the element that will be insertd
	 * @return the inserted element
	 */
	public Node<T> insert(T key) {

		Node<T> x = new Node<T>(key);

		// if the linked list is empty
		if (head == null) {

			head = x;
			tail = x;
			length++;
			head.prev = null;
			head.next = null;
			tail.next = null;
			tail.prev = null;

		}

		else {
			length++;
			tail.next = x;
			x.prev = tail;
			tail = x;
			x.next = null;
		}

		return x;

	}

	/**
	 * This method deletes the first element from this list that matches the
	 * provided key. If the provided key does not exist in the list, return null.
	 * 
	 * @param key is the element that is being deleted
	 */
	public void delete(T key) {

		Node<T> x = new Node<T>(key);
		Node<T> curr = head;
		// if list is empty
		if (curr.element == null) {

			System.out.println("Element cannot be found. There are no elements in this linked list.");

		}

		while (curr.element != null) {

			if (curr.element == x) {
				// conditions for the next pointer

				length--;

				// if curr is not the head
				if (curr.prev != null) {
					curr.prev.next = curr.next;

				}

				// if the x is the head
				else {
					head = curr.next;
					head.prev = null;
				}

				// condtions for the prev pointer
				// if the x is not the tail
				if (curr.next != null) {
					curr.next.prev = curr.prev;
				}

				// if x is the tail
				else {
					tail = curr.prev;
					tail.next = null;
				}

			}

			else {
				System.out.println("Element cannot be found in the linked list.");
			}
		}

	}

	/**
	 * This method returns the element in in the provided position.
	 * 
	 * @param pos is the index of the element to be returned
	 * @ IndexOutOfBoundException if the position is out of bounds of the
	 * doubly linked list
	 * @return the element in the provided position
	 */
	public T get(int pos) {

		// edge case : index is out of bounds
		if (pos < 0 || pos > length) {

			throw new IndexOutOfBoundsException();

		}

		else {
			int count = 0;
			Node<T> curr = head;

			while (count <= pos) {

				if (count == pos) {

					return curr.element;

				}

				curr = curr.next;
				count++;

			}

			return curr.element;
		}

	}

	/**
	 * returns a String representation of this list’s elements
	 */
	public String toString() {

		String fullList = "";
		Node<T> curr = head;

		while (curr != null) {

			fullList += curr.element + "\n";
			curr = curr.next;

		}

		return fullList;

	}

}
