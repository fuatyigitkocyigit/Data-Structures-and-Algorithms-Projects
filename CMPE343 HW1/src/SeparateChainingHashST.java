//-----------------------------------------------------
// Title: Separate Chaining Hash Table Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 1
// Description: This class implements the separate chaining hashtable.
//-----------------------------------------------------

import java.io.*;
import java.util.*;

public class SeparateChainingHashST <Key, Value>{
    private static final int INIT_CAPACITY = 16;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables

    public SeparateChainingHashST() {
    	//--------------------------------------------------------
    	// Summary: Creates an empty table
    	// Postcondition: New empty table has been initialized.
    	//--------------------------------------------------------
    	
        this(INIT_CAPACITY);
    } 

    public SeparateChainingHashST(int m) {
    	//--------------------------------------------------------
    	// Summary: Creates an empty table with selected chains.
    	// Precondition: Took an int from user which is the chain number of table.
    	// Postcondition: New empty table has been initialized with the given chain number.
    	//--------------------------------------------------------
    	
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    private void resize(int chains) {
    	//--------------------------------------------------------
    	// Summary: Resizes the hash table and re-hash all keys
    	// Precondition: Takes the chain number int value as input.
    	// Postcondition: Hash table has been resized.
    	//--------------------------------------------------------
    	
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    private int hashTextbook(Key key) {
    	//--------------------------------------------------------
    	// Summary: Hashes the given key.
    	// Precondition: Takes key variable as input.
    	// Postcondition: Returned the int value which is the hash value of given key.
    	//--------------------------------------------------------
    	
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private int hash(Key key) {
    	//--------------------------------------------------------
    	// Summary: Hashes the given key in more advanced way.
    	// Precondition: Takes key variable as input.
    	// Postcondition: Returned the int value which is the hash value of given key.
    	//--------------------------------------------------------
    	
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m-1);
    }

    public int size() {
    	//--------------------------------------------------------
    	// Summary: Returns the size of the symbol table.
    	// Postcondition: Returned the size of the table.
    	//--------------------------------------------------------
    	
        //return n;
    	return m;
    } 

    public boolean isEmpty() {
    	//--------------------------------------------------------
    	// Summary: Checks if the table is empty or not.
    	// Postcondition: Returned true if table is empty, false if it is not.
    	//--------------------------------------------------------
    	
        return size() == 0;
    }

    public boolean contains(Key key) {
    	//--------------------------------------------------------
    	// Summary: Checks if the table contains the key.
    	// Precondition: Key variable is input.
    	// Postcondition: Returned true if table contains the key, false if not.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    public Value get(Key key) {
    	//--------------------------------------------------------
    	// Summary: Finds and returns the value of the given key.
    	// Precondition: Takes key as an input.
    	// Postcondition: Returned the value of the key.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 
    
    public Value getIndex(Key key) {
    	//--------------------------------------------------------
    	// Summary: Getting the index of the key in the table.
    	// Precondition: Takes key as an input.
    	// Postcondition: Returned the index of the key.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    public void put(Key key, Value val) {
    	//--------------------------------------------------------
    	// Summary: Inserts the given key and value pair to the table. Updates value if the table 
    	//			already has that key.
    	// Precondition: Takes key and value input.
    	// Postcondition: Key-value has been inserted to the table.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        //Resizes if average length is so big
        if (n >= 10*m) resize(2*m);
        //

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    public void delete(Key key) {
    	//--------------------------------------------------------
    	// Summary: Deletes the given key and its value.
    	// Precondition: Takes key as an input.
    	// Postcondition: Deleted the key and its value.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        //Resizes if average length is so less
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
        //
    } 

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 
}
