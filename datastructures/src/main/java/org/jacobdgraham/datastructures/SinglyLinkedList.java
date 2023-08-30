package org.jacobdgraham.datastructures;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private SinglyLinkedListNode<T> head = null;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        SinglyLinkedListNode<T> traversal_node = head;

        while (traversal_node != null) {
            SinglyLinkedListNode<T> next = traversal_node.next;
            traversal_node.next = null;
            traversal_node.data = null;
            traversal_node = next;
        }
        head = null;
        size = 0;
    }

    public void addLast(final T element) {
        if (isEmpty()) {
            this.head = new SinglyLinkedListNode<T>(element, null);
            this.size = 1;
        } else {
            SinglyLinkedListNode current = this.head;
            SinglyLinkedListNode node = new SinglyLinkedListNode(element, null);
            node.data = element;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
            this.size++;
        }
    }

    public void addFirst(final T element) {
        if (isEmpty()) {
            this.head = new SinglyLinkedListNode<T>(element,null);
            this.size=1;
        } else {
            SinglyLinkedListNode old_head = this.head;
            SinglyLinkedListNode new_head_node = new SinglyLinkedListNode<T>(element,null);
            this.head = new_head_node;
            new_head_node.next = old_head;
            this.size++;
        }
    }

    public T first() {
        if(isEmpty()) {
            return null;
        } else {
            return head.data;
        }
    }

    public T last() {
        if (this.head == null) {
            return null;
        }
        if (isEmpty()) {
            return null;
        } else {
            SinglyLinkedListNode current_head = this.head;
            while (current_head.next != null) {
                current_head = current_head.next;
            }
            return (T) current_head.data;
        }
    }

    public T remove(final SinglyLinkedListNode<T> data) {
        if (head == null) {
            return null;
        }

        if (this.head.data.equals(data)) {
            T data_to_return = head.data;
            head = head.next;
            return data_to_return;
        }

        SinglyLinkedListNode current_head = this.head;
        while (current_head.next != null) {
            if (current_head.data.equals(data)) {
                T data_to_return = (T) current_head.data;
                current_head.next = current_head.next.next;
                size--;
                return data_to_return;
            }
            current_head = current_head.next;
        }
        return null;
    }

    public T removeAt(final int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        if (index == 0) {
            return removeFirst();
        }
        SinglyLinkedListNode<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T dataToRemove = current.next.data;
        current.next = current.next.next;
        size--;
        return dataToRemove;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T data = head.data;
        head = head.next;
        size--;

        return data;
    }

    public T remove(final T element) {
        if (this.head == null) {
            return null;
        }

        if (this.head.data.equals(element)) {
            T data_to_return = head.data;
            head = head.next;
            size--;
            return data_to_return;
        }
        SinglyLinkedListNode current_head = this.head;

        while (current_head.next != null) {

            if (current_head.data.equals(element)) {
                T data_to_return = (T) current_head.data;
                current_head.next = current_head.next.next;
                size--;
                return data_to_return;
            }
            current_head = current_head.next;
        }
        return null;
    }

    public int indexOf(final T element) {
        if (this.head == null) {
            return -1;
        }

        if (this.head.data.equals(element)) {
            return 0;
        }

        SinglyLinkedListNode current_head = this.head;
        int counter = 0;

        while (current_head.next != null) {
            
            if (current_head.data.equals(element)) {
                return counter;
            }
            current_head = current_head.next;
            counter++;
        }
        return -1;
    }

    public boolean contains(final T element) {
        if (this.head == null) {
            return false;
        }
        SinglyLinkedListNode current_head = this.head;
        
        while (current_head.next != null) {
            
            if (current_head.data.equals(element)) {
                return true;
            }
            current_head = current_head.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private SinglyLinkedListNode<T> linked_list_head = head;
            
            @Override
            public boolean hasNext() {
                return linked_list_head != null;
            }

            @Override
            public T next() {
                T data = linked_list_head.data;
                linked_list_head = linked_list_head.next;
                return data;
            }
        };
    }
}
