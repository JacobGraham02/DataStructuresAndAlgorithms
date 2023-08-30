package org.jacobdgraham.datastructures;

import java.util.Arrays;

import org.jacobdgraham.datastructures.interfaces.IStack;

public class Stack<T> implements IStack<T> {
    private int size;
    private int capacity;
    private T[] data;

    public Stack() {
        this.capacity = 16;
        data =  (T[]) new Object[this.capacity];
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public void push(final T element) {
        if (this.size == this.capacity) {
            doubleCapacity();
        }
        data[this.size++] = element;
    }

    private void doubleCapacity() {
        this.capacity *= 2;
        this.data = Arrays.copyOf(data, this.capacity);
    }
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        this.size--;
        T top_stack_element = (T)data[this.size];
        data[this.size] = null;
        return top_stack_element;
    }
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } 
        T top_stack_element = (T)data[this.size-1];
        return top_stack_element;
    }
}
