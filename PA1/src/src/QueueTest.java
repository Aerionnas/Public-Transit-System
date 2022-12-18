package src;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class QueueTest {
    
    //test cases for enqueue and dequeue methods
    

    /**
     * testing if one number is enqueued
     * number:10
     * the head should be and the tail should also be 10
     */
    @Test
    void Enqueue() {
        Queue test1 = new Queue(4);
        test1.enqueue(10);
        assertEquals(10, test1.front());
        assertEquals(10, test1.getTail());
    }

    /**
     * testing if two numbers are enqueued
     * numbers:10, 41
     * the head should be 10 and the tail should be 41
     */
    @Test
    void Enqueue1() {
        Queue test1 = new Queue(4);
        test1.enqueue(10);
        test1.enqueue(41);
        assertEquals(10, test1.front());
        assertEquals(41, test1.getTail());
    }

    /**
     * testing if more  numbers are enqueued
     * number:10, 41, 55 , 999
     * the head should be 10 and the tail should be 41
     */
    @Test
    void Enqueue2() {
        Queue test1 = new Queue(4);
        test1.enqueue(10);
        test1.enqueue(41);
        test1.enqueue(55);
        test1.enqueue(999);
        
        assertEquals(10, test1.front());
        assertEquals(999, test1.getTail());
    }

     /**
     * testing if dequeue method works 
     * number:7, 5, 500
     * the head should be 10 and the tail should be 41
     */
    @Test
    void Enqueue4() {
        Queue test1 = new Queue(5);
        test1.enqueue(7);
        test1.enqueue(5);
        test1.enqueue(500);
        test1.dequeue();
        test1.dequeue();
        assertEquals(500, test1.front());
        assertEquals(500, test1.getTail());
    }

     /**
     * testing if two numbers are enqueued
     * numbers:10, 41, 55
     * the head should be 10 and the tail should be 55
     */
    @Test
    void Enqueue3() {
        Queue test1 = new Queue(4);
        test1.enqueue(10);
        test1.enqueue(41);
        test1.enqueue(55);
        assertEquals(10, test1.front());
        assertEquals(55, test1.getTail());
    }

}
