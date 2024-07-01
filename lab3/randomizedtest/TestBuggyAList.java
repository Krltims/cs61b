package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList
{
    @Test
    public void testThreeAddThreeRemove()
    {
        AListNoResizing<Integer> l1 = new AListNoResizing<>();
        BuggyAList<Integer> l2 = new BuggyAList<>();
        for (int i = 5; i <= 15; i+=5) {
            //System.out.println(i);
            l1.addLast(i);
            l2.addLast(i);
        }
        assertEquals(l1.size(), l2.size());
        assertEquals(l1.removeLast(), l2.removeLast());
        assertEquals(l1.removeLast(), l2.removeLast());
        assertEquals(l1.removeLast(), l2.removeLast());
        assertEquals(l1.size(), l2.size());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0,4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                if (L.size()==0){
                    continue;
                }
                else{
                    assertEquals(L.removeLast(), L2.removeLast());
                }
            }
            else if (operationNumber == 2) {
                if (L.size()==0){
                    continue;
                }
                else{
                    assertEquals(L.getLast(), L2.getLast());
                }

            }
        }
    }
}
