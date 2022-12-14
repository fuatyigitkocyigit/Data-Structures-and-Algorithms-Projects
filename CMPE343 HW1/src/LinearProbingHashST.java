//-----------------------------------------------------
// Title: Linear Probing Hash Table Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 1
// Description: This class implements the linear probing hashtable.
//-----------------------------------------------------

import java.io.*;
import java.util.*;

public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 16;

    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
    	//--------------------------------------------------------
    	// Summary: Creates an empty table
    	// Postcondition: New empty table has been initialized.
    	//--------------------------------------------------------
    	
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
    	//--------------------------------------------------------
    	// Summary: Creates an empty table with selected capacity.
    	// Precondition: Took an int from user which is the capacity of table.
    	// Postcondition: New empty table has been initialized with the given capacity.
    	//--------------------------------------------------------
    	
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
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
    	
        if (key == null) 
        	throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
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
    
    private int hash2(Key key) {
    	//--------------------------------------------------------
    	// Summary: Hashes the given key.
    	// Precondition: Takes key variable as input.
    	// Postcondition: Returned the int value which is the hash value of given key.
    	//--------------------------------------------------------
    	
    	return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
    	//--------------------------------------------------------
    	// Summary: Resizes the hash table and re-hash all keys
    	// Precondition: Takes the capacity int value as input.
    	// Postcondition: Hash table has been resized.
    	//--------------------------------------------------------
    	
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    public void put(Key key, Value val) {
    	//--------------------------------------------------------
    	// Summary: Inserts the given key and value pair to the table. Updates value if the table 
    	//			already has that key.
    	// Precondition: Takes key and value input.
    	// Postcondition: Key-value has been inserted to the table.
    	//--------------------------------------------------------
    	
        if (key == null) 
        	throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        //Resizing if table is half full 
        if (n >= m/2) resize(2*m);
        //

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(Key key) {
    	//--------------------------------------------------------
    	// Summary: Finds and returns the value of the given key.
    	// Precondition: Takes key as an input.
    	// Postcondition: Returned the value of the key.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public int getIndex(Key key) {
    	//--------------------------------------------------------
    	// Summary: Getting the index of the key in the table.
    	// Precondition: Takes key as an input.
    	// Postcondition: Returned the index of the key.
    	//--------------------------------------------------------
    	
    	for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
    		if (keys[i].equals(key))
    			return hash2(key);
    		return 0;
    }

    public void delete(Key key) {
    	//--------------------------------------------------------
    	// Summary: Deletes the given key and its value.
    	// Precondition: Takes key as an input.
    	// Postcondition: Deleted the key and its value.
    	//--------------------------------------------------------
    	
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;

        //Resizing if the table is less than quarter
        if (n > 0 && n <= m/8) resize(m/2);
        //

        assert check();
    }

    public Iterable<Key> keys() {
    	
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    private boolean check() {
    	//--------------------------------------------------------
    	// Summary: Checks the tables if it is full or not (or if needs any resize)
    	//--------------------------------------------------------

        if (m < 2*n) {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }

}
