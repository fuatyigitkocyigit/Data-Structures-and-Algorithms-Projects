//-----------------------------------------------------
// Title: Merge sort class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 2
// Description: This class sorts the given int input in descending order with merge sort
//-----------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Merge { //STEP 4

	private static Comparable[] aux;
	  
	public static void sort(Comparable[] a){
		//--------------------------------------------------------
		// Summary: Sorts the given array with using the merge algorithm
		// Precondition: Gets the array a from the user.
		// Postcondition: Sorted the array with ascending order and printed in a line.
		//--------------------------------------------------------
		
		aux = new Comparable[a.length];  
		sort(a, 0, a.length - 1);
	       
	}
	  
	private static void sort(Comparable[] a, int lo, int hi){
		if (hi <= lo) 
			return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);  
		merge(a, lo, mid, hi);
	       
	}  
	  
	private static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)  
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++)
			if(i > mid)                
				a[k] = aux[j++];
			else if (j > hi )                
				a[k] = aux[i++];
			//else if (less(aux[j], aux[i]))   
			//	a[k] = aux[j++];
			else if (less(aux[i], aux[j]))   
				a[k] = aux[j++];
			else                            
				a[k] = aux[i++];     
		
	}
	  
	private static boolean less(Comparable v, Comparable w){  
		//--------------------------------------------------------
		// Summary: Compares if the v is bigger or not.
		// Precondition: Gets 2 value from user.
		// Postcondition: Returns a boolean value which is the result of the compare.
		//--------------------------------------------------------
		
		return v.compareTo(w) < 0;  
	       
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
		// Summary: Gets the input from the .txt file and sorts it with the merge sort algorithm
		//--------------------------------------------------------
		
		File file = new File("C:\\Users\\fuatk\\Desktop\\inputt.txt");
			   
		BufferedReader input = new BufferedReader(new FileReader(file));

		int N = Integer.parseInt(input.readLine());
		      
		Integer[] a = new Integer[N];
		      
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(input.readLine());
		      
		System.out.println("Input:");
		show(a);
		
		if(isSorted(a)==true) {
	    	show(a);
	    	System.exit(0);
	    	
	    }
		      
		sort(a);
		      
		System.out.println();
		System.out.println("Array after merge sorting:");
		show(a);
		    
	}     
}
