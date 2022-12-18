/**
 * Queue.java
 * This class implements the Circular Queue data structure using an array.
 * Elements are inserted and removed according to the First In, First Out
 * Principle (FIFO).
 * 
 * @author:Aerionna Stephenson
 * date:December 12, 2022
 */

package src;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Queue<T> {

	T[] q;
	int head; // front
	int tail; // rear
	int numOfElements;
	int size;

	public Queue(int size) {

		this.head = this.tail = 0; 
		this.size = size;
		this.numOfElements = 0;

		q = (T[]) new Object[size];

	}

	/**
	 * This method adds an element to the Circular Queue.
	 * @param element This is the element that is being added 
	 * to the rear of the Queue.
	 * 
	 */
	public void enqueue(T element) {

		// if the queue's tail is the last position of the array and the head is not 0
		// if the the queue is empty
		if ((tail == size - 1 && head != 0) || (tail == head && q[head] == null)) {
			tail = 0;
			q[tail] = element;
			numOfElements += 1;

		}

		else if (q[tail + 1] != null) {

			System.out.println("There is no space in the queue. The element cannot be added.");

		}

		else {

			tail = tail + 1;
			q[tail] = element;
			numOfElements += 1;

		}

	}

	/**
	 * This methods removes the element from the head of the queue. 
	 * @exception NoSuchElement If the there are no elements in the 
	 * queue, this exception is thrown
	 * @return the element that is being removed 
	 */
	public T dequeue() {

		T x = q[head];
		q[head] = null;

		//if the head is located at the last position of the array
		if (head == size - 1 && numOfElements != 0) {
			head = 0;
		} 

		//if there are no elements in the queue
		else if (numOfElements == 0) {
			throw new NoSuchElementException("There are no elements in the queue.");
		} 

		//if there is only one element in the queue;
		else if (head == tail && numOfElements == 1) {
			numOfElements = 0;
		} 

		else {
			numOfElements -= 1;
			head += 1;
		}

		// System.out.println(x + " was dequeued");
		return x;
	}

	/**
	 * This method returns returns the element at the head of the queue.
	 * @exception NoSuchElement If the there are no elements in the 
	 * queue, this exception is thrown
	 * @return the element located at the head
	 */
	public T front() {
		if (numOfElements == 0) {
			throw new NoSuchElementException("There is elements in the queue");
		}
		return q[head];

	}

	/**
	 * This method returns returns the element at the rear of the queue.
	 * @exception NoSuchElement If the there are no elements in the 
	 * queue, this exception is thrown
	 * @return the element located at the rear
	 */
	public T getTail() {
		if (numOfElements == 0) {
			throw new NoSuchElementException("There is elements in the queue");
		}
		return q[tail];
	}

	/**
	 * This method gets the amount of elements in queue.
	 * @return the number of elements in the queue
	 */
	public int length() {

		return numOfElements;
	}

	/**
	 * This method checks whether the queue is empty or not
	 * @return true of false
	 */
	public boolean isEmpty() {
		if (numOfElements == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return  is the string representation of the queue's elments.
	 */
	public String toString() {
		return Arrays.toString(q) + "\n";
	}

	public static void main(String[] args) {
		// Queue test = new Queue(4);

		// test.enqueue(3);
		// test.dequeue();
		// test.enqueue(5);
		// test.dequeue();
		// test.enqueue(9);
		// test.enqueue(50);
		// test.dequeue();
		// test.enqueue(91);
		// test.enqueue(12);
		// test.enqueue(12);
		// test.dequeue();
		// test.dequeue();
		// test.dequeue();
		// test.dequeue();
		// test.dequeue();

		// System.out.println("Number of Elements: " + test.length());
		// System.out.println("Head: " + test.head);
		// System.out.println("Tail: " + test.tail);
		// System.out.println("size: " + test.length());
		// System.out.println(test.isEmpty());

		// System.out.println(test.toString());
	}

}
