//-----------------------------------------------------
// Title: Sorting Algorithm test class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 2
// Description: This class tests the runtimes of the 5 sort method with 2 different array.
//-----------------------------------------------------

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class SortingAlgorithmTester {

	public static int[]ascendingarr (int a[]){
		//--------------------------------------------------------
		// Summary: Makes the array an ascending array.
		// Precondition: Gets the int array from user.
		// Postcondition: Ascending array returned.
		//--------------------------------------------------------
		
		for(int i=0; i<a.length; i++) {
			for(int ii=i; ii<a.length; ii++) {
				if(a[i] > a[ii]) {
					int temp = a[ii];
					a[ii] = a[i];
					a[i] = temp;
				}
			}				
		}
		return a;
		
	}
	
	public static int[]descendingarr (int a[]){
		//--------------------------------------------------------
		// Summary: Makes the array an descending array.
		// Precondition: Gets the int array from user.
		// Postcondition: Descending array returned.
		//--------------------------------------------------------
		
		for(int i=0; i<a.length; i++) {
			for(int ii=i; ii<a.length; ii++) {
				if(a[i] < a[ii]) {
					int temp = a[ii];
					a[ii] = a[i];
					a[i] = temp;
				}
			}				
		}
		return a;
		
	}
	
	public static int[]randomarr (int a[]){
		//--------------------------------------------------------
		// Summary: Creates a random array.
		// Precondition: Gets the array from user.
		// Postcondition: Fills the array with random values.
		//--------------------------------------------------------
		
		Random random = new Random();
		for(int i=0; i<a.length; i++) {
			a[i] = random.nextInt()*100000;
			
		}
		return a;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//--------------------------------------------------------
		// Summary: Sets 6 different array. Ascending with size 100, descending with size 100, random with size 100
		// 			ascending with size 10000, descending with size 10000, random with size 10000. After creating arrays,
		//			test every sort with every array and how many times the sort algorithm used.
		//--------------------------------------------------------
		
		Scanner keyboard = new Scanner(System.in);
		//2 different sized array
		int[] array100 = new int[100];
		int[] array10000 = new int[10000];
		
		//putting random values to the arrays
		int[] randomarray100 = randomarr(array100);
		int[] randomarray10000 = randomarr(array10000);
		
		//making 2 descending array
		int[] descendingarray100 = descendingarr(randomarray100);
		int[] descendingarray10000 = descendingarr(randomarray10000);
		
		//making 2 ascending array
		int[] ascendingarray100 = ascendingarr(randomarray100);
		int[] ascendingarray10000 = ascendingarr(randomarray10000);
		
		//
		
		System.out.println("Run-times of the sorts:");
		System.out.println();
		
		//100 size
		Long sort1time1start = System.currentTimeMillis();
		int[] sortedarray = SortingAlgorithms.sort1(randomarray100, 1642908594L);
		Long sort1time1end = System.currentTimeMillis();
		Long sort1time1 = sort1time1end - sort1time1start;
		System.out.println("Sort 1 with size 100 and random array: "+sort1time1);
		
		Long sort1time2start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort1(ascendingarray100, 1642908594L);
		Long sort1time2end = System.currentTimeMillis();
		Long sort1time2 = sort1time2end - sort1time2start;
		System.out.println("Sort 1 with size 100 and ascending array: "+sort1time2);
		
		Long sort1time3start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort1(descendingarray100, 1642908594L);
		Long sort1time3end = System.currentTimeMillis();
		Long sort1time3 = sort1time3end - sort1time3start;
		System.out.println("Sort 1 with size 100 and descending array: "+sort1time3);
		System.out.println();
		//10000 size
		Long sort1time4start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort1(randomarray10000, 1642908594L);
		Long sort1time4end = System.currentTimeMillis();
		Long sort1time4 = sort1time4end - sort1time4start;
		System.out.println("Sort 1 with size 10000 and random array: "+sort1time4);
		
		Long sort1time5start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort1(ascendingarray10000, 1642908594L);
		Long sort1time5end = System.currentTimeMillis();
		Long sort1time5 = sort1time5end - sort1time5start;
		System.out.println("Sort 1 with size 10000 and ascending array: "+sort1time5);
		
		Long sort1time6start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort1(descendingarray10000, 1642908594L);
		Long sort1time6end = System.currentTimeMillis();
		Long sort1time6 = sort1time6end - sort1time6start;
		System.out.println("Sort 1 with size 10000 and descending array: "+sort1time6);
		System.out.println("-----");
		
		////
		//Sort 2
		////
		
		//100 size
		Long sort2time1start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort2(randomarray100, 1642908594L);
		Long sort2time1end = System.currentTimeMillis();
		Long sort2time1 = sort2time1end - sort2time1start;
		System.out.println("Sort 2 with size 100 and random array: "+sort2time1);
		
		Long sort2time2start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort2(ascendingarray100, 1642908594L);
		Long sort2time2end = System.currentTimeMillis();
		Long sort2time2 = sort2time2end - sort2time2start;
		System.out.println("Sort 2 with size 100 and ascending array: "+sort2time2);
		
		Long sort2time3start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort2(descendingarray100, 1642908594L);
		Long sort2time3end = System.currentTimeMillis();
		Long sort2time3 = sort2time3end - sort2time3start;
		System.out.println("Sort 2 with size 100 and descending array: "+sort2time3);
		System.out.println();
		//10000 size
		Long sort2time4start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort2(randomarray10000, 1642908594L);
		Long sort2time4end = System.currentTimeMillis();
		Long sort2time4 = sort2time4end - sort2time4start;
		System.out.println("Sort 2 with size 10000 and random array: "+sort2time4);
		
		Long sort2time5start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort2(ascendingarray10000, 1642908594L);
		Long sort2time5end = System.currentTimeMillis();
		Long sort2time5 = sort2time5end - sort2time5start;
		System.out.println("Sort 2 with size 10000 and ascending array: "+sort2time5);
		
		Long sort2time6start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort2(descendingarray10000, 1642908594L);
		Long sort2time6end = System.currentTimeMillis();
		Long sort2time6 = sort2time6end - sort2time6start;
		System.out.println("Sort 2 with size 10000 and descending array: "+sort2time6);
		System.out.println("-----");
		
		////
		//Sort 3
		////
		
		//100 size
		Long sort3time1start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort3(randomarray100, 1642908594L);
		Long sort3time1end = System.currentTimeMillis();
		Long sort3time1 = sort3time1end - sort3time1start;
		System.out.println("Sort 3 with size 1000 and random array: "+sort3time1);
		
		Long sort3time2start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort3(ascendingarray100, 1642908594L);
		Long sort3time2end = System.currentTimeMillis();
		Long sort3time2 = sort3time2end - sort3time2start;
		System.out.println("Sort 3 with size 1000 and ascending array: "+sort3time2);
		
		Long sort3time3start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort3(descendingarray100, 1642908594L);
		Long sort3time3end = System.currentTimeMillis();
		Long sort3time3 = sort3time3end - sort3time3start;
		System.out.println("Sort 3 with size 1000 and descending array: "+sort3time3);
		System.out.println();
		//10000 size
		Long sort3time4start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort3(randomarray10000, 1642908594L);
		Long sort3time4end = System.currentTimeMillis();
		Long sort3time4 = sort3time4end - sort3time4start;
		System.out.println("Sort 3 with size 10000 and random array: "+sort3time4);
		
		Long sort3time5start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort3(ascendingarray10000, 1642908594L);
		Long sort3time5end = System.currentTimeMillis();
		Long sort3time5 = sort3time5end - sort3time5start;
		System.out.println("Sort 3 with size 10000 and ascending array: "+sort3time5);
		
		Long sort3time6start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort3(descendingarray10000, 1642908594L);
		Long sort3time6end = System.currentTimeMillis();
		Long sort3time6 = sort3time6end - sort3time6start;
		System.out.println("Sort 3 with size 10000 and descending array: "+sort3time6);
		System.out.println("-----");
		
		////
		//Sort 4
		////
		
		//100 size
		Long sort4time1start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort4(randomarray100, 1642908594L);
		Long sort4time1end = System.currentTimeMillis();
		Long sort4time1 = sort4time1end - sort4time1start;
		System.out.println("Sort 4 with size 100 and random array: "+sort4time1);
		
		Long sort4time2start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort4(ascendingarray100, 1642908594L);
		Long sort4time2end = System.currentTimeMillis();
		Long sort4time2 = sort4time2end - sort4time2start;
		System.out.println("Sort 4 with size 100 and ascending array: "+sort4time2);
		
		Long sort4time3start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort4(descendingarray100, 1642908594L);
		Long sort4time3end = System.currentTimeMillis();
		Long sort4time3 = sort4time3end - sort4time3start;
		System.out.println("Sort 4 with size 100 and descending array: "+sort4time3);
		System.out.println();
		//10000 size
		Long sort4time4start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort4(randomarray10000, 1642908594L);
		Long sort4time4end = System.currentTimeMillis();
		Long sort4time4 = sort4time4end - sort4time4start;
		System.out.println("Sort 4 with size 10000 and random array: "+sort4time4);
		
		Long sort4time5start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort4(ascendingarray10000, 1642908594L);
		Long sort4time5end = System.currentTimeMillis();
		Long sort4time5 = sort4time5end - sort4time5start;
		System.out.println("Sort 4 with size 10000 and ascending array: "+sort4time5);
		
		Long sort4time6start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort4(descendingarray10000, 1642908594L);
		Long sort4time6end = System.currentTimeMillis();
		Long sort4time6 = sort4time6end - sort4time6start;
		System.out.println("Sort 4 with size 10000 and descending array: "+sort4time6);
		System.out.println("-----");
		
		////
		//Sort 5
		////
		
		//100 size
		Long sort5time1start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort5(randomarray100, 1642908594L);
		Long sort5time1end = System.currentTimeMillis();
		Long sort5time1 = sort5time1end - sort5time1start;
		System.out.println("Sort 5 with size 100 and random array: "+sort5time1);
		
		Long sort5time2start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort5(ascendingarray100, 1642908594L);
		Long sort5time2end = System.currentTimeMillis();
		Long sort5time2 = sort5time2end - sort5time2start;
		System.out.println("Sort 5 with size 100 and ascending array: "+sort5time2);
		
		Long sort5time3start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort5(descendingarray100, 1642908594L);
		Long sort5time3end = System.currentTimeMillis();
		Long sort5time3 = sort5time3end - sort5time3start;
		System.out.println("Sort 5 with size 100 and random array: "+sort5time3);
		System.out.println();
		//10000 size
		Long sort5time4start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort5(randomarray10000, 1642908594L);
		Long sort5time4end = System.currentTimeMillis();
		Long sort5time4 = sort5time4end - sort5time4start;
		System.out.println("Sort 5 with size 10000 and random array: "+sort5time4);
		
		Long sort5time5start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort5(ascendingarray10000, 1642908594L);
		Long sort5time5end = System.currentTimeMillis();
		Long sort5time5 = sort5time5end - sort5time5start;
		System.out.println("Sort 5 with size 10000 and ascending array: "+sort5time5);
		
		Long sort5time6start = System.currentTimeMillis();
		sortedarray = SortingAlgorithms.sort5(descendingarray10000, 1642908594L);
		Long sort5time6end = System.currentTimeMillis();
		Long sort5time6 = sort5time6end - sort5time6start;
		System.out.println("Sort 5 with size 10000 and descending array: "+sort5time1);
		System.out.println("-----");
		
	}

}
