package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    @Test
    public void SimpleMaxArrayTest() {

        MyComparator myComparator = new MyComparator();

        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(myComparator);

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front_line");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        lld1.removeLast();
        lld1.addLast("last_line");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        System.out.println(lld1.max());
        assertTrue("", lld1.max().equals("front_line"));
    }
}