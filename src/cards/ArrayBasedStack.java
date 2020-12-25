/**
 * 
 */
package cards;

import java.util.EmptyStackException;

/**
 * @author nhalstead
 * @version 2019.02.10
 * @param <T>
 *            the generic used for the stack
 */
public class ArrayBasedStack<T> {
    private T[] stackArray;
    private int size;
    private int capacity;

    /**
     * creates a stack
     * 
     * @param capacity
     *            total number of items held before expansion
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int capacity) {
        stackArray = (T[])new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }


    /**
     * default constructor with a capacity of 100
     */
    public ArrayBasedStack() {
        this(100);
    }


    /**
     * Checks if the stack is empty.
     * 
     * @return {@code true} if the stack is empty;
     *         {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @throws EmptyStackException
     *             if stack is empty.
     * 
     * @return the item at the top of the stack.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[size - 1];
    }


    /**
     * Removes the item at the top of the stack.
     *
     * @throws EmptyStackException
     *             if stack is empty.
     * 
     * @return the item at the top of the stack.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        T temp = stackArray[size];
        stackArray[size] = null;
        return temp;
    }


    /**
     * Pushes an item onto the stack.
     * 
     * @param item
     *            the item to be pushed onto the stack.
     */
    public void push(T item) {
        if (size == capacity) {
            expandCapacity();
        }
        stackArray[size] = item;
        size++;
    }


    /**
     * gets the item at index T
     * 
     * @param index
     *            int denoting where to look for item
     * @return T object stored at index, null if invalid
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return stackArray[index];
    }


    /**
     * Checks if an item is in the stack.
     * 
     * @param item
     *            the item to be looked for.
     * 
     * @return {@code true}, if the item is somewhere in the stack;
     *         {@code false} otherwise.
     */
    public boolean contains(T item) {
        T[] tempStackArray = toArray();
        for (T tempItem : tempStackArray) {
            if (item.equals(tempItem)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Tells capacity of stack
     * 
     * @return size of array/capacity of stack
     */
    public int capacity() {
        return capacity;
    }


    /**
     * Number of items in the stack.
     * 
     * @return the number of items in the stack.
     */
    public int size() {
        return size;
    }


    /**
     * Clears the stack (removes all of the items from the stack).
     */
    public void clear() {
        while (size > 0) {
            pop();
        }
    }


    /**
     * Returns an array with a copy of each element in the stack with the top of
     * the stack being the last element
     *
     * @return the array representation of the stack
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy = (T[])new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }


    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>)other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
