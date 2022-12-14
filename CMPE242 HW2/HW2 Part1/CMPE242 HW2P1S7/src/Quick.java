//-----------------------------------------------------
// Title: Quick sort class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 2
// Description: This class sorts the given persons according to their id's in descending order with quick sort
//-----------------------------------------------------

public class Quick {

	public static void sort(Comparable[] a){ //STEP 8
		//--------------------------------------------------------
		// Summary: Sorts the given array with using the quick sort algorithm
		// Precondition: Gets the array a from the user.
		// Postcondition: Sorted the array with descending order and printed in a line.
		//--------------------------------------------------------
		
		//StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		
	}
	  
	private static void sort(Comparable[] a, int lo, int hi){
		if (hi <= lo) 
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
		
	}
	  
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi+1;
		Comparable v = a[lo];
		while(true){
			while(less(v, a[++i])) 
				if(i == hi) 
					break;
			while(less(a[--j], v)) 
				if(j == lo) 
					break;
			if(i >= j) 
				break;
			exch(a, i, j);
	 	}
		exch(a, lo, j);
		return j;
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
			System.out.println(a[i].toString());
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
	  
	public static void main(String[] args){
		//--------------------------------------------------------
		// Summary: Sets the person arrays and sorts it with the quick sort algorithm
		//--------------------------------------------------------
		
		Person[] persons = {new Person("Fuat Yiðit", "Koçyiðit", 1642908594), new Person("Ali", "Veli", 1548963158),
	                     	new Person("Berkay", "Can", 1589621563), new Person("Cem", "Malik", 1152354895),
	                     	new Person("John", "Apple", 1058956455), new Person("Mehmet", "Bal", 1899652305),
	                     	new Person("Ahmet", "Paþa", 1589653206), new Person("Selin", "Yýlmaz", 1025623489),
	                     	new Person("Kemal", "Has", 1325689556), new Person("Hakan", "Taþ", 1665498530)};
	      
		
		
		System.out.println("Input:");
		show(persons);

		if(isSorted(persons)==true) {
	    	show(persons);
	    	System.exit(0);
	    	
	    }
		
		sort(persons);

		System.out.println("Array after quick sorting:");
		show(persons);
		
	}
}
