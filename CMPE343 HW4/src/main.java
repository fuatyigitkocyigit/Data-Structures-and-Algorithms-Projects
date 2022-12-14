//-----------------------------------------------------
// Title: main Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 4
// Description: This class takes the input from the input file and
//				creates the Edge Weighted Graph, Prim's Algorithm and prints the results.
//-----------------------------------------------------

import java.io.File;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		File file = new File("C:\\Users\\fuatk\\eclipse-workspace\\CMPE343 HW4 Task1\\sample_input1.txt");
		Scanner input = new Scanner(file);
		
		String city[] = new String[7];
		
		//Taking City names and putting them to String array
		for(int i=0; i<city.length; i++) {
			
			city[i] = input.next();
			//System.out.println("cities"+city[i]);
			
		}
		//
		
		//Creating Edge Weighted Graph
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(city.length);
		//
		
		//Creating edges according to input file
		while(true) {
			int from=0;
			int to=0;
			
			String fromString = input.next();
			//System.out.println("from "+fromString);
			for(int i=0; i<city.length; i++) {
				if(city[i].equals(fromString))
					from = i;
			}
			
			String toString = input.next();
			//System.out.println("to "+toString);
			for(int i=0; i<city.length; i++) {
				if(city[i].equals(fromString))
					to = i;
			}
			
			double km = (input.nextInt());
			//System.out.println("km "+km);
			//System.out.println();
			
			Edge road = new Edge(from, to, km);
			
			ewg.addEdge(road);	
			
			if(input.hasNextLine()==false) {
				break;
			}
			
		}
		//
		
		//Creating Prim's Algorithm		
		PrimMST pmst = new PrimMST(ewg);
		//
		
		//Printing Results	
		System.out.println(pmst.weight());
		
		for(Edge e: pmst.edges()) {
			
			System.out.println(e);
			
		}
		//
		
	}

}
