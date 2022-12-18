package src;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    
    DoubleLinkedList<String> d;

    void initTest(){

        d = new DoubleLinkedList<String>();
        d.insert("blue");
		d.insert("yellow");
		d.insert("green");
		d.insert("purple");

        assertEquals("blue", d.getHead());
        assertEquals("purple", d.getTail());
        assertEquals("yellow", d.get(1));

        d.delete("yellow");
        d.delete("green");
        d.delete("blue");

        d.insert("peach");
		d.insert("teal");
		d.insert("lime green");
		d.insert("violet");

        assertEquals("purple", d.getHead());
        assertEquals("violet", d.getTail());
        assertEquals("lime green", d.get(3));


    }

    void prevAndNext(){
        Node <String> curr = d.getHead();
        curr = curr.next.next;
        assertTrue(curr.element.equals("teal"));
    }
}

    
