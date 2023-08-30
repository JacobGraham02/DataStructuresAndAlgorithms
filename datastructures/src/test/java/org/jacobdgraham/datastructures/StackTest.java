package org.jacobdgraham.datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        assertNull(stack.peek());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.peek());
        assertEquals(3, stack.size());
    }
}
