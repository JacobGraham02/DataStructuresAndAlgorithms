package org.jacobdgraham.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testSizeAndIsEmpty() {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());

        linkedList.addLast(1);
        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddFirst() {
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        assertEquals(2, linkedList.size());
        assertEquals(2, linkedList.first().intValue());
    }

    @Test
    public void testAddLast() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        assertEquals(2, linkedList.size());
        assertEquals(2, linkedList.last().intValue());
    }

    @Test
    public void testRemoveAt() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        int removedValue = linkedList.removeAt(1);
        assertEquals(2, removedValue);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemove() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.remove(Integer.valueOf(2));
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains(2));
    }

    @Test
    public void testIndexOf() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        assertEquals(1, linkedList.indexOf(2));
        assertEquals(-1, linkedList.indexOf(4));
    }

    @Test
    public void testIterator() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        int sum = 0;
        for (Integer value : linkedList) {
            sum += value;
        }
        assertEquals(6, sum);
    }
}
