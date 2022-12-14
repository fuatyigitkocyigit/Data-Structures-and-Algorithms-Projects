//-----------------------------------------------------
// Title: Task1 Main Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class takes the input (the intial, target and forbidden codes) from the user and
//				creates the graph, BFS and Cycle algorithm.
//-----------------------------------------------------

import java.util.Scanner;
import java.util.NoSuchElementException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//--------------------------------------------------------
		// Summary: The main method of the program. Takes input from the user 
		//			and assigns the values. Also finds the required button presses with the BFS.
		//--------------------------------------------------------
		
		Scanner keyboard = new Scanner (System.in);
		
		//Creating variables
		int[] initial = new int[4];
		int[] target = new int[4];
		int forbiddenCount;
		int[] forbidden = new int[4];
		//
		
		//Creating graph
		Graph G = new Graph(10000);
		//
		
		//Adding edges to the graph
		for(int i=1000; i<=9998; i++) {
			G.addEdge(i, i+1);
			
		}
		//
		
		//Taking inputs from the user and calculating it to integer
		for(int i=0; i<4; i++) {
			initial[i] = keyboard.nextInt();
			
		}
		int initialNum = main.calculateNumber(initial);
		System.out.println("The initial code is: "+initialNum);

		
		for(int i=0; i<4; i++) {
			target[i] = keyboard.nextInt();
			
		}
		int targetNum = main.calculateNumber(target);
		System.out.println("The target code is: "+targetNum);
		
		
		forbiddenCount = keyboard.nextInt();
		int[] forbiddenNum = new int[forbiddenCount];
		
		for(int ii=0; ii<forbiddenCount; ii++) {
			for(int i=0; i<4; i++) {
				forbidden[i] = keyboard.nextInt();
				
			}
			forbiddenNum[ii] = main.calculateNumber(forbidden);
			System.out.println("Forbidden code "+(ii+1)+" is: "+forbiddenNum[ii]);
		}
		//
		
		//Finding the shortest path
		int path = main.findPath(G, targetNum);
		System.out.println("The minimum button presses required is: "+path);
		//
		
	}
	
	public static int calculateNumber(int x[]) {
		//--------------------------------------------------------
		// Summary: Calculates the integer value of the given array.
		// Precondition: Method takes an integer array as input.
		// Postcondition: The value of the array has been returned.
		//--------------------------------------------------------

		int xNum = x[0]*1000+x[1]*100+x[2]*10+x[3];
		
		return xNum;
		
	}
	
	public static int findPath(Graph G, int target) {
		//--------------------------------------------------------
		// Summary: Finds the shortest path to the target with the BFS.
		// Precondition: Method takes a Graph and an integer as input.
		// Postcondition: The shortest distance has been returned as integer value.
		//--------------------------------------------------------

		BreadthFirstPaths bfs = new BreadthFirstPaths(G, target);
		int dist = bfs.distTo(target);
		
		return dist;
		
	}

}
