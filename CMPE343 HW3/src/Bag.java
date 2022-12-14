//-----------------------------------------------------
// Title: Bag Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class implements the Bag to use in digraph class.
//-----------------------------------------------------

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
		//--------------------------------------------------------
		// Summary: Initializes an empty bag.
		//--------------------------------------------------------
    	
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
		//--------------------------------------------------------
		// Summary: Returns true if this bag is empty, false if otherwise.
		//--------------------------------------------------------
    	
        return first == null;
    }

    public int size() {
		//--------------------------------------------------------
		// Summary: Returns the number of items in this bag.
		//--------------------------------------------------------
    	
        return n;
    }

    public void add(Item item) {
		//--------------------------------------------------------
		// Summary: Adds the item to this bag.
		// Precondition: Method takes a Item input.
		// Postcondition: The Item has been added.
		//--------------------------------------------------------
    	
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Iterator<Item> iterator()  {
		//--------------------------------------------------------
		// Summary: Returns an iterator that iterates over the items in this bag in arbitrary order.
		//--------------------------------------------------------
    	
        return new LinkedIterator(first);  
    }

    private class LinkedIterator implements Iterator<Item> {
    	
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { 
        	return current != null;                     
        	}
        public void remove()      { 
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