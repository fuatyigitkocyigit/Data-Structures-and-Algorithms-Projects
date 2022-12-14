//-----------------------------------------------------
// Title: main Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class takes the input from the user or input file and
//				creates the directed graph, topological sort algorithm and the command system.
//-----------------------------------------------------

import java.util.NoSuchElementException;
import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//Creating scanners
		Scanner keyboard = new Scanner(System.in);
		Scanner inputFile = new Scanner(new FileReader("C:\\Users\\fuatk\\eclipse-workspace\\CMPE343 HW3\\sampleinput.txt"));
		//
		
		//Getting V value (number of tasks)
		int V = main.takeNumberofTasks(inputFile);
		//
		
		//Creating string array and directed graph
		String tasks[] = new String[V];
		Digraph G = new Digraph(V);
		//
		
		inputFile.nextLine();
		
		//Getting the task names
		main.getTheTasks(tasks, inputFile, V);
		//
		
		//Getting dependencies and adding to the directed graph
		main.getDependencies(inputFile, G, tasks);
		//
		
		//Creating topological order
		Topological ts = new Topological(G);
		//
		
		//Starting the command loop
		main.sortTasksLoop(ts, keyboard, V, tasks);
		//
		
	}
	
	public static int takeNumberofTasks(Scanner inputFile) {
		//--------------------------------------------------------
		// Summary: Takes the number of tasks from the scanner.
		// Precondition: inputFile is scanner which is the input of the project.
		// Postcondition: Number of tasks has been returned.
		//--------------------------------------------------------
		
		System.out.println("Enter the number of tasks:");
		int V = inputFile.nextInt();
		System.out.println("The number of tasks is "+V);
		System.out.println();
		return V;
		
	}
	
	public static void getTheTasks(String tasks[], Scanner inputFile, int V) {
		//--------------------------------------------------------
		// Summary: Gets the name of tasks from the scanner and puts it to the string array.
		// Precondition: tasks is the string array, inputFile is the scanner and V is the number of
		//				tasks.
		// Postcondition: The name of the tasks has been stored to the string array.
		//--------------------------------------------------------
		
		for(int i=0; i<V; i++) {
			System.out.println("Please enter the task with ID "+i+":");
			tasks[i] = inputFile.next();
			System.out.println("Task "+i+" is "+tasks[i]);
			
		}
		System.out.println();
		
	}
	
	public static void getDependencies(Scanner inputFile, Digraph G, String tasks[]) {
		//--------------------------------------------------------
		// Summary: Gets the dependencies of the tasks from the input and adds to the directed graph.
		// Precondition: inputFile is scanner, G is the directed graph and tasks is the string array.
		// Postcondition: The dependencies has been determined and edges added to the directed graph.
		//--------------------------------------------------------
		
		System.out.println("Please add the dependencies of the tasks with the task ID's:");
		while(true) {
			
			int v = inputFile.nextInt();
			int w = inputFile.nextInt();
			
			if(v == -1 && w == -1) {
				break;
			}
			System.out.println("Task "+w+" ("+tasks[w]+") is depended to "+v+" ("+tasks[v]+")");
			
			G.addEdge(v, w);
			
		}
		System.out.println();
		
	}
	
	public static void sortTasksLoop(Topological ts, Scanner keyboard, int V, String tasks[]) {
		//--------------------------------------------------------
		// Summary: Creates a command loop that makes 3 things
		//			0 ends the program
		//			1 lists the order of the tasks in the weeks
		//			2 checks the order of 2 given tasks.
		// Precondition: ts is the topological order, keyboard is the scanner, V is number of tasks
		//				and tasks is the string array
		// Postcondition: The command loop has been started.
		//--------------------------------------------------------
		
		while(true) {
			System.out.println("Enter choice (0: Exit, 1: List schedule, 2: Check order): ");
			int input = keyboard.nextInt();
			//0 command
			if(input == 0) {
				System.out.println("The program has been stopped.");
				System.exit(0);
			}
			//
			
			//1 command
			else if(input == 1) {
				if(ts.hasOrder() == false) {
					System.out.println("The tasks doesn't have a topological order.");
					break;
				}
				else {
					System.out.println(ts.order());
					
					//Finding maximum rank (number of weeks
					int maxRank = 0;
					for(int i=0; i<V; i++) {
						if(ts.rank(i) > maxRank) {
							maxRank = ts.rank(i);
						}
					}
					//
					
					//Printing the weeks according to the ranks of the tasks in the topological sort
					//(rank means the week of the task)
					for(int i=0; i<maxRank; i++) {
						System.out.println("Week "+(i+1)+" :");
						for(int ii=0; ii<V; ii++) {
							if(ts.rank(ii) == i) {
								System.out.println(tasks[ii]);
							}
						}	
					}
				}
			}
			//
			
			//2 command
			else if(input == 2) {
				System.out.println("Enter first task: ");
				String comp1 = keyboard.next();
				System.out.println("Enter second task:");
				String comp2 = keyboard.next();
				int c1 = -1;
				int c2 = -1;
				
				for(int i=0; i<V; i++) {
					if(tasks[i].equals(comp1)) {
						c1 = i;
					}
					if(tasks[i].equals(comp2)) {
						c2 = i;
					}
				}
				
				if(c1 == -1 || c2 == -1) {
					System.out.println("The given task has not been found.");
					
				}
				else {
					if(ts.rank(c1) == ts.rank(c2)) {
						System.out.println("You should do "+comp1+" and "+comp2+" on the same week.");
						
					}
					else if(ts.rank(c1) < ts.rank(c2)) {
						System.out.println("You should do "+comp2+" before "+comp1+".");
						
					}
					else if(ts.rank(c2) < ts.rank(c1)) {
						System.out.println("You should do "+comp1+" before "+comp2+".");
						
					}
				}
				
			}
			else {
				System.out.println("Wrong input. Please enter the command again.");
			}
		}
		//
		
	}

}
