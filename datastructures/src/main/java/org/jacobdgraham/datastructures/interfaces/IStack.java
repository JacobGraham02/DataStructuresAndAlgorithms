package org.jacobdgraham.datastructures.interfaces;

public interface IStack<T> {
    public int size();
    public boolean isEmpty();
    public void push(final T element);
    public T pop();
    public T peek();
}
