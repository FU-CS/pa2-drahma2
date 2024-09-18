package pa2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAdd() {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals("1 2 3 ", list.traverse());
    }

    @Test
    void testRemoveFirst() {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(3);
        list.remove(1);
        assertEquals("2 3 ", list.traverse());
    }

    @Test
    void testRemoveMid() {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(3);
        list.remove(2);
        assertEquals("1 3 ", list.traverse());
    }

    @Test
    void testRemoveLast() {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(3);
        list.remove(3);
        assertEquals("1 2 ", list.traverse());
    }



    @Test
    void testRemoveInvalidAddNegAddDoub(){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(-3);
        list.add(1);
        list.remove(7);
        assertEquals("-3 1 1 2 ", list.traverse_recur(list.head));
    }

    @Test
    void testRemoveAllElementsAndTraverseRecur() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        assertEquals("", list.traverse_recur(list.head));

    }
    @Test
    void testReverse(){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("3 2 1 ", list.reverse(list.head));
    }

    @Test
    void testMerge() {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        LinkedList list2 = new LinkedList();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        LinkedList mergedList = LinkedList.merge(list1, list2);
        assertEquals("1 2 3 4 5 6 ", mergedList.traverse());
    }

    @Test
    void testMergeEmptyList(){
        LinkedList list1 = new LinkedList();
        list1.add(4);
        list1.add(7);
        list1.add(9);

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.remove(1);

        LinkedList mergedList = LinkedList.merge(list1, list2);
        assertEquals("4 7 9 ", mergedList.traverse());
    }

    @Test
    void testReverseRemove(){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("3 1 ", list.reverse(list.head));
    }

    @Test
    void testMerge2(){
        LinkedList list1 = new LinkedList();
        list1.add(4);
        list1.add(7);
        list1.add(9);

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(6);
        list2.add(7);
        list2.add(3);
        list2.add(2);
        list2.add(8);
        

        LinkedList mergedList = LinkedList.merge(list1, list2);
        assertEquals("1 2 3 4 6 7 7 8 9 ", mergedList.traverse());
    }

}



