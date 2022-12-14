//-----------------------------------------------------
// Title: PriorityQueue class
// Author: Fuat Yiðit Koçyiðit & Günsu Günaydýn
// ID: 16429085948 & 18098680134
// Section: 3
// Assignment: 4
// Description: This defines a heap-based priority queue to use for scheduling
//-----------------------------------------------------

import java.util.*;

public class PriorityQueue {
	 
	static int []Heap = new int[50];
	static int size = -1;

	static int parent(int i){
		//--------------------------------------------------------
		// Summary: Returns the index of the given node's parent.
		// Precondition: Gets an integer variable.
		// Postcondition: Returned the index of the given node's parent.
		//--------------------------------------------------------
		return (i - 1)/2;
		
	}
	 
	static int leftChild(int i){
		//--------------------------------------------------------
		// Summary: Returns the index of the given node's left child.
		// Precondition: Gets an integer variable.
		// Postcondition: Returned the index of the given node's left child.
		//--------------------------------------------------------
		return ((2 * i) + 1);
		
	}
	 
	static int rightChild(int i){
		//--------------------------------------------------------
		// Summary: Returns the index of the given node's right child.
		// Precondition: Gets an integer variable.
		// Postcondition: Returned the index of the given node's right child.
		//--------------------------------------------------------
		return ((2 * i) + 2);
		
	}
	
	static void shiftUp(int i){
		//--------------------------------------------------------
		// Summary: Shifting up the node to maintain the heap property.
		// Precondition: Gets an integer variable.
		// Postcondition: Shifted up the node.
		//--------------------------------------------------------
		while (i > 0 && Heap[parent(i)] < Heap[i]){
			swap(parent(i), i);
			i = parent(i);
		}
		
	}
	
	static void shiftDown(int i){
		//--------------------------------------------------------
		// Summary: Shifting down the node to maintain the heap property.
		// Precondition: Gets an integer variable.
		// Postcondition: Shifted down the node.
		//--------------------------------------------------------
		int maxIndex = i;
		int l = leftChild(i);
		if (l <= size && Heap[l] > Heap[maxIndex])
			maxIndex = l;
		
		int r = rightChild(i);
		
		if (r <= size && Heap[r] > Heap[maxIndex])
			maxIndex = r;
		
		if (i != maxIndex){
			swap(i, maxIndex);
			shiftDown(maxIndex);
		}
		
	}
	
	static void insert(int p){
		//--------------------------------------------------------
		// Summary: Inserting a new element to the heap.
		// Precondition: Gets an integer variable.
		// Postcondition: Inserted the new element.
		//--------------------------------------------------------
		size = size + 1;
		Heap[size] = p;
		shiftUp(size);
		
	}
	
	static int extractMax(){
		//--------------------------------------------------------
		// Summary: Extracting the element which has the max priority.
		// Precondition:
		// Postcondition: Extracted the element with the max priority.
		//--------------------------------------------------------
		int result = Heap[0];
		Heap[0] = Heap[size];
		size = size - 1;
		shiftDown(0);
		return result;
		
	}
	
	static void changePriority(int i, int p){
		//--------------------------------------------------------
		// Summary: Changing the priority of element.
		// Precondition: Gets two integer variable.
		// Postcondition: Changed the priority of element.
		//--------------------------------------------------------
		int oldp = Heap[i];
		Heap[i] = p;
		if (p > oldp)
			shiftUp(i);
		else
			shiftDown(i);
		
	}
	
	static int getMax(){
		//--------------------------------------------------------
		// Summary: Getting the maximum element in the heap.
		// Precondition:
		// Postcondition: Returned the maximum element in the heap.
		//--------------------------------------------------------
		return Heap[0];
	  
	}
	
	static void remove(int i){
		//--------------------------------------------------------
		// Summary: Removing the element at the given index.
		// Precondition:
		// Postcondition: Removed the element in the given index.
		//--------------------------------------------------------
		Heap[i] = getMax() + 1;
		shiftUp(i);
		extractMax();
		
	}
	   
	static void swap(int i, int j){
		//--------------------------------------------------------
		// Summary: Swapping two elements.
		// Precondition: Gets two integer variable.
		// Postcondition: Swapped two elements.
		//--------------------------------------------------------
		int temp= Heap[i];
		Heap[i] = Heap[j];
		Heap[j] = temp;
		
	}
	
}
