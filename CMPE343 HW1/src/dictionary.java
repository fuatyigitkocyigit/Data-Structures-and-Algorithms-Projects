//-----------------------------------------------------
// Title: Dictionary Tester Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 1
// Description: This class tests takes the input (words that will be added to dictionary) from the user and
//				puts distinct words to the hashtables while recording the duplications.
//-----------------------------------------------------

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dictionary {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//--------------------------------------------------------
		// Summary: The main method of the program. Takes input from the user 
		//			and puts the words to the hash tables. Also calculates the elapsed time.
		//--------------------------------------------------------
		
		//Creating the input tools
		Scanner keyboard = new Scanner (System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//
		
		//Creating a string array and getting the input with it then splitting it with spaces.
		String[] str;
		str = br.readLine().split(" ");
		//
		
		//Implementing hash tables
		LinearProbingHashST<String, Integer> lphst = new LinearProbingHashST<String, Integer>();
		SeparateChainingHashST<String, Integer> schst = new SeparateChainingHashST<String, Integer>();
		//
		
		//Creating word array to hold the saved words.
		int wordCount = 0;
		String [] savedWords = new String [100];
		String key="";
		//
		
		//Putting words to the linear probing hash table and calculating the elapsed time
		System.out.println("Implementing linear probing hash table:");
		long start = System.nanoTime();
		for (int i=0; i<str.length; i++) {

			key = str[i];
        	
			//Put to the table if it is distinct
			if(lphst.get(key) == null) {
				lphst.put(key, 1);
				
				savedWords[wordCount] = key;
				wordCount++;
			}
			//
			//Update the value if it is not distinct (to hold the repeat times)
			else {
				int l = lphst.get(key);
				
				lphst.put(key, l+1);
			}
            //
        }
		long end = System.nanoTime();
		long elapsedTime = end - start; 
		System.out.println("All words are added to the linear probing hash table.");
		System.out.println();
		System.out.println("Elapsed time to put words to linear probing hash table is "+elapsedTime+" nanoseconds");
		//
		
		//Getting a random word to test the speed
		start = System.nanoTime();
		int test = lphst.get(savedWords[5]);
		end = System.nanoTime();
		elapsedTime = end - start; 
		System.out.println("Elapsed time to get a random word from linear probing hash table is "+elapsedTime+" nanoseconds");
		System.out.println("////");
		//
		
		
		//Putting words to the linear probing hash table and calculating the elapsed time
		System.out.println("Implementing seperate chaining hash table:");
		start = System.nanoTime();
		for (int i=0; i<str.length; i++) {

			key = str[i];
        	
			//Put to the table if it is distinct
			if(schst.get(key) == null) {
				schst.put(key, 1);

			}
			//
			//Update the value if it is not distinct (to hold the repeat times)
			else {
				int s = schst.get(key);

				schst.put(key, s+1);
			}
			//
        }
		end = System.nanoTime();
		elapsedTime = end - start; 
		System.out.println("All words are added to the seperate chaining hash table.");
		System.out.println();
		System.out.println("Elapsed time to put words to seperate chaining hash table is "+elapsedTime+" nanoseconds");
		//
		
		//Getting a random word to test the speed
		start = System.nanoTime();
		test = schst.get(savedWords[5]);
		end = System.nanoTime();
		elapsedTime = end - start; 
		System.out.println("Elapsed time to get a random word from seperate chaining hash table is "+elapsedTime+" nanoseconds");
		System.out.println("////");
		//
		
		System.out.println("Final table sizes for linear probing and separate chaining are "+lphst.size()+" and " +schst.size()+".");
		System.out.println("Top 3 most used words, their indexes for linear probing, their node indexes for separate chaining and their number of occurrences:");
		int max1=0;
		String max1s="";
		int max2=0;
		String max2s="";
		int max3=0;
		String max3s="";

		//Finding the top 3 words
		for(int i=0; i<wordCount; i++) {
			int c = lphst.get(savedWords[i]);
			if(c>max1) {
				max1=c;
				max1s=savedWords[i];
			}
			else if(c>max2) {
				max2=c;
				max2s=savedWords[i];
			}
			else if(c>max3) {
				max3=c;
				max3s=savedWords[i];
			}
		}
		//
		System.out.println(max1s+" "+ lphst.getIndex(max1s) +" "+ schst.getIndex(max1s) +" "+ max1);
		System.out.println(max2s+" "+ lphst.getIndex(max2s) +" "+ schst.getIndex(max2s) +" "+ max2);
		System.out.println(max3s+" "+ lphst.getIndex(max3s) +" "+ schst.getIndex(max3s) +" "+ max3);

	}

}
