//-----------------------------------------------------
// Title: Task2 Main Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class takes the input (the length, width and the shape of the maze) from the user and
//				creates the graph, DFS and Cycle algorithm.
//-----------------------------------------------------

import java.util.Scanner;
import java.util.NoSuchElementException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//--------------------------------------------------------
		// Summary: The main method of the program. Takes input from the user 
		//			and creates the graph. Also finds the circles and their lengths.
		//--------------------------------------------------------

		Scanner keyboard = new Scanner (System.in);
		
		//Taking the length and the width input
		System.out.println("Enter the length of the maze:");
        int length=keyboard.nextInt();
        System.out.println("Enter the width of the maze:");
        int width=keyboard.nextInt();
        //
		
	    //Creating the graph
	    Graph G = new Graph(width*length);
	    //
	        
	    //Taking the shape input
	    main.takeShape(G, width, length);
		//	
	    
	    //Founding cycles in the graph
	    boolean foundCycle = main.detectCycle(G);
        //
	    
        //Printing the results
        if(foundCycle) {
        	System.out.println("Cycle has been found.");
        }
        else
        	System.out.println("0 Cycles");
		//
        
	}
	
	public static void takeShape(Graph G, int width, int length) {
		//--------------------------------------------------------
		// Summary: Takes the shape input from the user and adds the edges
		// Precondition: Method takes a Graph, integer and length as input.
		// Postcondition: The input has been taken and edges has been added.
		//--------------------------------------------------------
		
		Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter the shape of the maze: ");
        
		//Getting the shape of the maze and adding edges
        for(int i=0; i<width; i++) {
			String line=keyboard.next();
			char[] chars = line.toCharArray();
			for(int ii=0; ii<length-1; ii++) {
				if(!(chars[ii]==chars[ii+1])) {
					G.addEdge(i, ii);
				}
			}
		}
        //
	}
	
	public static boolean detectCycle(Graph G) {
		//--------------------------------------------------------
		// Summary: Takes the graph and detects the cycles in it.
		// Precondition: Method takes a Graph as input.
		// Postcondition: The cycles has been found and returned the boolean value of it.
		//--------------------------------------------------------
		
        //Creating algorithms
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
        Cycle cycleFind = new Cycle(G);
        cycleFind.dfs(G,0,0);
        boolean foundCycle = cycleFind.hasCycle();
        //
		
        return foundCycle;

	}
	
}
