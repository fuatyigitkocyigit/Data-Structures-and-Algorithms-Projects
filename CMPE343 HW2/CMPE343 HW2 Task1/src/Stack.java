//-----------------------------------------------------
// Title: Queue Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class implements the stack for using in BFS.
//-----------------------------------------------------

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
    	//--------------------------------------------------------------
    	// Summary: Initializes an empty stack.
    	//--------------------------------------------------------------
    	
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
    	//--------------------------------------------------------------
    	// Summary: Checks if the stack is empty or not.
    	// Postcondition: Checked if the stack is empty or not and returned a boolean value.
    	//--------------------------------------------------------------
    	
        return first == null;
    }

    public int size() {
		//--------------------------------------------------------------
		// Summary: Returns the size of stack.
		// Postcondition: Returned integer variable which is size.
		//--------------------------------------------------------------
    	
        return n;
    }

    public void push(Item item) {
    	//--------------------------------------------------------------
    	// Summary: Pushes an item to top of the stack.
    	// Precondition: Takes an Item as input.
    	// Postcondition: Pushed the given Item to top of the stack.
    	//--------------------------------------------------------------
    	
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
    	//--------------------------------------------------------------
    	// Summary: Pops an item from the top of the stack.
    	// Postcondition: Popped the first item from the top of the stack and returned it which is an Item.
    	//--------------------------------------------------------------
    	
        if (isEmpty()) 
        	throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public Item peek() {
    	//--------------------------------------------------------------
    	// Summary: Peeks the item at the top of the stack. It will not be removed.
    	// Postcondition: Peeked the item at the top of the stack and returned that item which is an Item.
    	//--------------------------------------------------------------
    	
        if (isEmpty()) 
        	throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
    	//--------------------------------------------------------------
    	// Summary: Prints all nodes of the stack. First node will be printed first.
    	// Postcondition: Printed all nodes of the stack.
    	//--------------------------------------------------------------
    	
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    
    public Iterator<Item> iterator() {
		//--------------------------------------------------------
		// Summary: Returns an iterator to this stack that iterates through the items in LIFO order.
		//--------------------------------------------------------
    	
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

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