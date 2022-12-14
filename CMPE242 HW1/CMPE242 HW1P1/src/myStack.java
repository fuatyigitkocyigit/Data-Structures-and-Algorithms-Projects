//-----------------------------------------------------
// Title: CMPE242 HW1
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 1
// Description: This class defines a linked list and a stack named myStack
//-----------------------------------------------------

import java.util.Scanner;

public class myStack {
	//--------------------------------------------------------------
	// Summary: Creates a stack to use in VaccineStock.
	//--------------------------------------------------------------
	public int inSta = 0;
    public Node first = null;
    Scanner keyboard = new Scanner(System.in);
    
    public class Node{
    	//--------------------------------------------------------------
    	// Summary: Creates the LinkedList node.
    	//--------------------------------------------------------------
    	VaccineStock item;
    	Node next;
    	
    }
    
    public boolean isEmpty() { 
    	//--------------------------------------------------------------
    	// Summary: Checks if the stack is empty or not.
    	// Postcondition: Checked if the stack is empty or not and returns a boolean value.
    	//--------------------------------------------------------------
    	return first == null; 
    
    }
    
    public int size() {
		//--------------------------------------------------------------
		// Summary: Returns the size of stack.
		// Postcondition: Returned inSta variable which is integer.
		//--------------------------------------------------------------
		return inSta;
	}
    
    public void push(VaccineStock item) {
    	//--------------------------------------------------------------
    	// Summary: Pushes an item to top of the stack.
    	// Precondition: Method parameter is a VaccineStock variable.
    	// Postcondition: Pushed the given VaccineStock variable to top of the stack.
    	//--------------------------------------------------------------
   		Node oldfirst = first;
   		first = new Node();
   		first.item = item;
   		first.next = oldfirst;
   		inSta++;
    	
   	}
    
   	public VaccineStock pop() {
    	//--------------------------------------------------------------
    	// Summary: Pops an item from the top of the stack.
    	// Postcondition: Popped the first item from the top of the stack and returned it which is a VaccineStock object.
    	//--------------------------------------------------------------
   		VaccineStock item = first.item;
   		first = first.next;
   		inSta--;
   		return item;
   		
   	}
   	
   	public VaccineStock peek() {
    	//--------------------------------------------------------------
    	// Summary: Peeks the item at the top of the stack. It will not be removed.
    	// Postcondition: Peeked the item at the top of the stack and returned that item which is a VaccineStock object.
    	//--------------------------------------------------------------
   		VaccineStock item = first.item;
   		return item;
   		
   	}
   	
   	public void print() {
    	//--------------------------------------------------------------
    	// Summary: Prints all nodes of the stack. First node will be printed first.
    	// Postcondition: Printed all nodes of the stack.
    	//--------------------------------------------------------------
   		while(inSta>0) {
   			System.out.println(first.toString());
   			first = first.next;
   			inSta--;
   			
   		}
   	}
   	
}
