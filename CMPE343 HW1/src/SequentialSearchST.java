//-----------------------------------------------------
// Title: Sequential Search Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 1
// Description: This class implements the sequential search for using in hashtables.
//-----------------------------------------------------

import java.io.*;
import java.util.*;

public class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;


    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    	//--------------------------------------------------------
    	// Summary: Initializing an empty symbol table.
    	//--------------------------------------------------------
    	
    }

    public int size() {
    	//--------------------------------------------------------
    	// Summary: Returns the size.
    	//--------------------------------------------------------
    	
        return n;
    }

    public boolean isEmpty() {
    	//--------------------------------------------------------
    	// Summary: Checks if table is empty or not.
    	//--------------------------------------------------------
    	
        return size() == 0;
    }

    public boolean contains(Key key) {
    	//--------------------------------------------------------
    	// Summary: Deletes the given key and its value.
    	// Precondition: Takes key as an input.
    	// Postcondition: Deleted the key and its value.
    	//--------------------------------------------------------
    	
        return get(key) != null;
    }

    public Value get(Key key) {
    	//--------------------------------------------------------
    	// Summary: Returns vale of the given key.
    	//--------------------------------------------------------
    	
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
    	//--------------------------------------------------------
    	// Summary: Inserts the given key and value pair to the table.
    	//--------------------------------------------------------
    	
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public void delete(Key key) {
    	//--------------------------------------------------------
    	// Summary: Deletes the given key and its value.
    	//--------------------------------------------------------
    	
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
    	//--------------------------------------------------------
    	// Summary: Deletes the given key in linkedlist beginning at given node.
    	//--------------------------------------------------------
    	
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
    
}