//-----------------------------------------------------
// Title: Queue Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class implements the queue for using in BFS.
//-----------------------------------------------------

import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
    }

    public Queue() {
    	//--------------------------------------------------------
    	// Summary: Creates an empty queue.
    	//--------------------------------------------------------
    	
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
    	//--------------------------------------------------------
    	// Summary: Checks if table is empty or not.
    	//--------------------------------------------------------
    	
        return first == null;
    }

    public int size() {
    	//--------------------------------------------------------
    	// Summary: Returns the size.
    	//--------------------------------------------------------
    	
        return n;
    }

    public int length() {
    	//--------------------------------------------------------
    	// Summary: Returns the number of items in queue.
    	//--------------------------------------------------------
    	
        return n;
    }

    public Item peek() {
    	//--------------------------------------------------------
    	// Summary: Returns the last added item. (doesn't pops it)
    	//--------------------------------------------------------
    	
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    public void enqueue(Item item) {
    	//--------------------------------------------------------
    	// Summary: Adds item to queue.
    	//--------------------------------------------------------
    	
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item dequeue() {
    	//--------------------------------------------------------
    	// Summary: Returns the top item and removes it.
    	//--------------------------------------------------------
    	
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    public String toString() {
    	//--------------------------------------------------------
    	// Summary: toString method.
    	//--------------------------------------------------------
    	
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
}