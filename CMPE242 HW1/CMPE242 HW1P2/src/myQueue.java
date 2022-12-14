//-----------------------------------------------------
// Title: CMPE242 HW1
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 1
// Description: This class defines a linked list and a queue named myQueue
//-----------------------------------------------------

public class myQueue {
	//--------------------------------------------------------------
	// Summary: Creates a queue to use in Vaccine class.
	//--------------------------------------------------------------
	public int size=4;
	public int inQue=0;
    public Node first;
    public Node last;
    
    public class Node {
    	//--------------------------------------------------------------
    	// Summary: Creates LinkedList node.
    	//--------------------------------------------------------------
    	Vaccine item;
    	Node next;
    	
    }
    
    public boolean isEmpty() { 
    	//--------------------------------------------------------------
    	// Summary: Checks if the queue is empty or not.
    	// Postcondition: Checked if the queue is empty or not and returned a boolean value.
    	//--------------------------------------------------------------
    	return inQue == 0; 
    	
    }
    
    public boolean isFull() {
    	//--------------------------------------------------------------
    	// Summary: Checks if the queue is full or not.
    	// Precondition: size is an integer value.
    	// Postcondition: Checked if the queue is full or not and returned a boolean value.
    	//--------------------------------------------------------------
    	return inQue >= size;
    	
    }
    
    public int size() {
    	//--------------------------------------------------------------
    	// Summary: Gives the size of queue.
    	// Precondition: size is an integer value.
    	// Postcondition: Returns the size value of the queue which is an integer value.
    	//--------------------------------------------------------------
    	return inQue;
    	
    }
    
    public void enqueue(Vaccine item) {
    	//--------------------------------------------------------------
    	// Summary: Adds a Vaccine object to the back of the queue. If we reached the size limit, size will be doubled.
    	// Precondition: item is a Vaccine object.
    	// Postcondition: item has been added to the back of the queue.
    	//--------------------------------------------------------------
    	if(this.inQue == 3) {
    		this.size = this.size*2;
    		
    	}
    	
    	Node oldlast = last;
    	last = new Node();
    	last.item = item;
    	last.next = null;
    	if (isEmpty()) 
    		first = last;
    	else 
    		oldlast.next = last;
    	inQue++;
    	
    }
    
    public Vaccine dequeue() {
    	//--------------------------------------------------------------
    	// Summary: Removes the first item in the queue. If we have less than half of size, size will be halved.
    	// Precondition: item is a Vaccine object. 
    	// Postcondition: Returned the first item in the queue which is a Vaccine object.
    	//--------------------------------------------------------------
    	Vaccine item = first.item;
    	first = first.next;
    	if (isEmpty()) 
    		last = null;
    	inQue--;
    	if(this.inQue < (this.size/2)) {
    		this.size = this.size/2;
    		
    	}
    	return item;
    	
    } 
    
    public Vaccine peek() {
    	//--------------------------------------------------------------
    	// Summary: Peeks the first item in the queue. It will not be removed.
    	// Postcondition: Peeked the first item of the stack and returned that item which is a Vaccine object.
    	//--------------------------------------------------------------
    	Vaccine item = first.item;
    	return item;
    	
    }  
    
	public void print() {
    	//--------------------------------------------------------------
    	// Summary: Prints all nodes of the queue. First node will be printed first.
    	// Postcondition: Printed all nodes of the queue.
    	//--------------------------------------------------------------
		while(inQue > 0) {
			System.out.println(dequeue().toString());
		
		}
	}
	
}
