//-----------------------------------------------------
// Title: IndexMinPQ Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 4
// Description: This class implements the IndexMinPQ to use in PrimMST class.
//-----------------------------------------------------

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int maxN;
    private int n;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int maxN) {
		//--------------------------------------------------------
		// Summary: Initializes an empty indexed priority queue with indices between 0 and maxN - 1.
		//--------------------------------------------------------
    	
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];                   // make this of length maxN??
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    public boolean isEmpty() {
		//--------------------------------------------------------
		// Summary: Returns true if this priority queue is empty.
		//--------------------------------------------------------
    	
        return n == 0;
    }

    public boolean contains(int i) {
		//--------------------------------------------------------
		// Summary: Is i an index on this priority queue?
		//--------------------------------------------------------
    	
        validateIndex(i);
        return qp[i] != -1;
    }

    public int size() {
		//--------------------------------------------------------
		// Summary: Returns the number of keys on this priority queue.
		//--------------------------------------------------------
    	
        return n;
    }

    public void insert(int i, Key key) {
		//--------------------------------------------------------
		// Summary: Associates key with index i.
		//--------------------------------------------------------
    	
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int minIndex() {
		//--------------------------------------------------------
		// Summary: Returns an index associated with a minimum key.
		//--------------------------------------------------------
    	
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    
    public Key minKey() {
		//--------------------------------------------------------
		// Summary: Returns a minimum key.
		//--------------------------------------------------------
    	
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    public int delMin() {
		//--------------------------------------------------------
		// Summary: Removes a minimum key and returns its associated index.
		//--------------------------------------------------------
    	
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;
        keys[min] = null;
        pq[n+1] = -1;
        return min;
    }

    public Key keyOf(int i) {
		//--------------------------------------------------------
		// Summary: Returns the key associated with index i.
		//--------------------------------------------------------
    	
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    public void changeKey(int i, Key key) {
		//--------------------------------------------------------
		// Summary: Change the key associated with index {@code i} to the specified value.
		//--------------------------------------------------------
    	
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    @Deprecated
    public void change(int i, Key key) {
		//--------------------------------------------------------
		// Summary: Change the key associated with index i to the specified value.
		//--------------------------------------------------------
    	
        changeKey(i, key);
    }

    public void decreaseKey(int i, Key key) {
		//--------------------------------------------------------
		// Summary: Decrease the key associated with index i to the specified value.
		//--------------------------------------------------------
    	
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) < 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the priority queue");
        keys[i] = key;
        swim(qp[i]);
    }

    public void increaseKey(int i, Key key) {
		//--------------------------------------------------------
		// Summary: Increase the key associated with index i to the specified value.
		//--------------------------------------------------------
    	
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) > 0)
            throw new IllegalArgumentException("Calling increaseKey() with a key strictly less than the key in the priority queue");
        keys[i] = key;
        sink(qp[i]);
    }

    public void delete(int i) {
		//--------------------------------------------------------
		// Summary: Remove the key associated with index i.
		//--------------------------------------------------------
    	
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    private void validateIndex(int i) {
		//--------------------------------------------------------
		// Summary: throw an IllegalArgumentException if i is an invalid index
		//--------------------------------------------------------
    	
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() { 
		//--------------------------------------------------------
		// Summary: Returns an iterator that iterates over the keys on the priority queue in ascending order.
		//--------------------------------------------------------
    	
    	return new HeapIterator(); 
    	}

    private class HeapIterator implements Iterator<Integer> {
        private IndexMinPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMinPQ<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext()  { 
        	return !copy.isEmpty();                     
        }
        
        public void remove()      { 
        	throw new UnsupportedOperationException();  
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}