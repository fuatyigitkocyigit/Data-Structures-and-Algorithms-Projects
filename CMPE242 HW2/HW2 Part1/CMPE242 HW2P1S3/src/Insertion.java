//-----------------------------------------------------
// Title: Insertion sort class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 2
// Description: This class sorts the given double input in ascending order with insertion sort
//-----------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Insertion { //STEP 3

	public static void sort(Comparable[] a){
		//--------------------------------------------------------
		// Summary: Sorts the given array with using the insertion algorithm
		// Precondition: Gets the array a from the user.
		// Postcondition: Sorted the array with ascending order and printed in a line.
		//--------------------------------------------------------
		
		int N = a.length;
		for (int i = 1; i < N; i++){
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
				exch(a, j, j-1);
	           
	       	}
	       
	}
	  
	private static boolean less(Comparable v, Comparable w){  
		//--------------------------------------------------------
		// Summary: Compares if the v is bigger or not.
		// Precondition: Gets 2 value from user.
		// Postcondition: Returns a boolean value which is the result of the compare.
		//--------------------------------------------------------
		
		return v.compareTo(w) < 0;  
	       
	}  
	  
	private static void exch(Comparable[] a, int i, int j){
		//--------------------------------------------------------
		// Summary: Exchanges the 2 elements given by the user.
		// Precondition: Get an array and 2 int from user.
		// Postcondition: Exchanges the i. and j. element of array.
		//--------------------------------------------------------
		
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	       
	}
	  
	private static void show(Comparable[] a){
		//--------------------------------------------------------
		// Summary: Prints all the elements of array.
		// Precondition: Gets the array that will be printed.
		// Postcondition: Array is printed in a line.
		//--------------------------------------------------------
		
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	       
	}
	
	public static boolean isSorted(Comparable[] a){
		//--------------------------------------------------------
		// Summary: Checks if the given array is already sorted.
		// Precondition: Gets the array from the user.
		// Postcondition: Array checked and returned a boolean value which is our check result.
		//--------------------------------------------------------
		
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) 
				return false;
		return true;
			
	}
	  
	public static void main(String[] args) throws Exception {
		//--------------------------------------------------------
		// Summary: Gets the input from the .txt file and sorts it with the insertion algorithm
		//--------------------------------------------------------
		
		File file = new File("C:\\Users\\fuatk\\Desktop\\inputt.txt");
			   
		BufferedReader input = new BufferedReader(new FileReader(file));

		int N = Integer.parseInt(input.readLine());
			      
		Double[] a = new Double[N];
			      
		for (int i = 0; i < N; i++)
			a[i] = Double.parseDouble(input.readLine());
			      
		System.out.println("Input:");
		show(a);
			      
		if(isSorted(a)==true) {
	    	show(a);
	    	System.exit(0);
	    	
	    }
		
		sort(a);
			      
		System.out.println();
		System.out.println("Array after insertion sorting:");
		show(a);
	}        
}
