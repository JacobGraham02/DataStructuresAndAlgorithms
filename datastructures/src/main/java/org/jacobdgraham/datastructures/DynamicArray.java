package org.jacobdgraham.datastructures;

import java.util.Iterator;

/**
 * This array class contains the methods that most Collections have
 * size(): returns the number of elements within the array, not the actual capacity of the array
 * get(final int index): returns the object at the specified numerical index inside of the array
 * set(final int index, final T element): overwrites a specified index location in the array with a specified object
 * clear(): converts all of the indexes in the array to null and resets the number of array elements pointer to 0
 * isEmpty(): returns a boolean value indicating if there are any elements in the array
 * add(final T element): adds a new object to the end of the array and increments the array elements pointer
 * remove(final T element): removes the specified object from the array
 * removeAt(final int removal_index): removes an object from the array at the specified location
 * indexOf(final T element): returns the numerical index of the specified object
 * contains(final T element): returns a boolean value indicating if the array contains the specified element
 * @param <T> Any object type
 */
public class DynamicArray<T> implements Iterable<T> {

    private Object[] array_elements;
    // The array capacity which the invoker believes is the array size
    private int user_assigned_array_length = 0;
    // The array capacity which the array class internally uses
    private int actual_array_capacity = 0;

    public DynamicArray(final int array_capacity) {
        if (array_capacity < 0) {
            throw new IllegalArgumentException("You must provide an array capacity that is greater than 0");
        }
        this.actual_array_capacity = array_capacity;
        this.array_elements = (T[]) new Object[array_capacity];
    }

    public int size() {
        return user_assigned_array_length;
    }

    public T get(final int index) {
        return (T)array_elements[index];
    }

    public void set(final int index, final T element) {
        array_elements[index] = element;
    }

    public void clear() {
        for (int i = 0; i < user_assigned_array_length; i++) {
            array_elements[i] = null;
        }
        user_assigned_array_length = 0;
    }

    public boolean isEmpty() {
        return user_assigned_array_length == 0;
    }

    public void add(final T element) {
        if (user_assigned_array_length+1 >= actual_array_capacity) {
            if (actual_array_capacity == 0) {
                actual_array_capacity = 1;
            } else {
                actual_array_capacity *= 2;
            }
            T[] new_array = (T[]) new Object[actual_array_capacity];

            for (int i = 0; i < user_assigned_array_length; i++) {
                new_array[i] = (T) array_elements[i];
            }
            this.array_elements = new_array;
        }
        this.array_elements[user_assigned_array_length] = element;
        user_assigned_array_length++;

    }

    public T removeAt(final int removal_index) {
        if (removal_index >= user_assigned_array_length || removal_index < 0) {
            throw new IndexOutOfBoundsException("The removal index must be between 0 and "
                    + this.user_assigned_array_length);
        }
        final T data_to_remove = (T) array_elements[removal_index];
        T[] new_array = (T[]) new Object[user_assigned_array_length-1];

        for (int i = 0; i < removal_index; i++) {
            new_array[i] = (T) this.array_elements[i];
        }
        for (int i = removal_index + 1; i < user_assigned_array_length; i++) {
            new_array[i-1] = (T) this.array_elements[i];
        }
        this.array_elements = new_array;
        this.user_assigned_array_length--;

        return data_to_remove;
    }

    public boolean remove(final T element) {
        final int index_of_element = indexOf(element);
        if (index_of_element == -1) {
            return false;
        }
        removeAt(index_of_element);
        return true;
    }

    public int indexOf(final T element) {
        for (int i = 0; i < user_assigned_array_length; i++) {
            if (array_elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(final T element) {
        return indexOf(element) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int start_index = 0;

            @Override
            public boolean hasNext() {
                return start_index < user_assigned_array_length;
            }
            @Override
            public T next() {
                return (T) array_elements[start_index++];
            }
        };
    }

    @Override
    public String toString() {
        if (user_assigned_array_length == 0) {
            return "[]";
        }
        StringBuilder string_builder = new StringBuilder(user_assigned_array_length).append("[");
        for (int i = 0; i < user_assigned_array_length - 1; i++) {
            string_builder.append(array_elements[i] + ", ");
        }
        return string_builder.append(array_elements[user_assigned_array_length-1] + "]").toString();
    }
}
