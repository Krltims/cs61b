package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testnoprime() {
        IntList lst = IntList.of(2,4,6,8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 6 -> 8", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testnonegativeprime() {
        IntList lst = IntList.of(0,-1,5,6,8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("0 -> -1 -> 25 -> 6 -> 8", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testallzero() {
        IntList lst = IntList.of(0,0,0,0);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("0 -> 0 -> 0 -> 0", lst.toString());
        assertFalse(changed);
    }
    @Test
    public void testemptylist() {
        IntList lst = IntList.of(0);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("0", lst.toString());
        assertFalse(changed);
    }
    @Test
    public void regularlist() {
        IntList lst = IntList.of(1,2,3,4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 9 -> 4", lst.toString());
        assertTrue(changed);
    }
}
