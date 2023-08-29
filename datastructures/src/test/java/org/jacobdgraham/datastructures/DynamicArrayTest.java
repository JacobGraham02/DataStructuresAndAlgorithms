package org.jacobdgraham.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    private DynamicArray<Integer> dynamicArray;

    @BeforeEach
    public void setUp() {
        dynamicArray = new DynamicArray<>(3);
    }

    @Test
    public void testAddAndGet() {
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);

        assertEquals(10, dynamicArray.get(0));
        assertEquals(20, dynamicArray.get(1));
        assertEquals(30, dynamicArray.get(2));
    }

    @Test
    public void testSizeAndIsEmpty() {
        assertTrue(dynamicArray.isEmpty());

        dynamicArray.add(10);
        dynamicArray.add(20);

        assertEquals(2, dynamicArray.size());
        assertFalse(dynamicArray.isEmpty());
    }

    @Test
    public void testRemoveAt() {
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);

        assertEquals(20, dynamicArray.removeAt(1));
        assertEquals(2, dynamicArray.size());
        assertFalse(dynamicArray.contains(20));
    }

    @Test
    public void testRemove() {
        dynamicArray.add(10);
        dynamicArray.add(20);

        assertTrue(dynamicArray.remove(10));
        assertFalse(dynamicArray.contains(10));
        assertEquals(1, dynamicArray.size());
    }

    @Test
    public void testIndexOfAndContains() {
        dynamicArray.add(10);
        dynamicArray.add(20);

        assertEquals(0, dynamicArray.indexOf(10));
        assertEquals(1, dynamicArray.indexOf(20));
        assertTrue(dynamicArray.contains(20));
        assertFalse(dynamicArray.contains(30));
    }

    @Test
    public void testClear() {
        dynamicArray.add(10);
        dynamicArray.add(20);

        dynamicArray.clear();

        assertTrue(dynamicArray.isEmpty());
        assertEquals(0, dynamicArray.size());
    }

    @Test
    public void testIterator() {
        dynamicArray.add(10);
        dynamicArray.add(20);

        StringBuilder result = new StringBuilder();
        for (Integer num : dynamicArray) {
            result.append(num).append(" ");
        }

        assertEquals("10 20 ", result.toString());
    }

    @Test
    public void testToString() {
        dynamicArray.add(10);
        dynamicArray.add(20);

        assertEquals("[10, 20]", dynamicArray.toString());
    }
}
