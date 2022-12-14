//-----------------------------------------------------
// Title: main Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 4
// Description: This class takes the input from the input file and
//				creates the Edge Weighted Graph, Prim's Algorithm, Dijkstra's Algorithm and prints the results.
//-----------------------------------------------------

import java.io.File;
import java.util.Scanner;

public class main2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\fuatk\\eclipse-workspace\\CMPE343 HW4 Task1\\sample_input2.txt");
		Scanner input2 = new Scanner(file);
		
		int totalCity = input2.nextInt();
		int totalRoad = input2.nextInt();
		
		String city[] = new String[totalCity];
		int coordX[] = new int[totalCity];
		int coordY[] = new int[totalCity];
		
		//Taking City names, coordinates and putting them to String array
		for(int i=0; i<city.length; i++) {
			
			coordX[i] = input2.nextInt();
			coordY[i] = input2.nextInt();
			city[i] = input2.next();
			//System.out.println("cities"+city[i]);
			
		}
		//
		
		//Creating Edge Weighted Graph
		EdgeWeightedGraph ewg2 = new EdgeWeightedGraph(city.length);
		//
		
		//Calculating the lengths of the roads and creating edges according to input file and results
		while(totalRoad>0) {
			int from = input2.nextInt();
			int to = input2.nextInt();
			
			int fromX = coordX[from];
			int fromY = coordY[from];
			int toX = coordX[to];
			int toY = coordY[to];
			
			double km = Math.sqrt((toX-fromX)*(toX-fromX) + (toY-fromY)*(toY-fromY));
			
			Edge road = new Edge(from, to, km);
			
		}
		//
		
		//Creating Prim's Algorithm
		PrimMST pmst2 = new PrimMST(ewg2);
		//
		
		System.out.println(pmst2.weight());
		
		for(Edge e: pmst2.edges()) {
			
			System.out.println(e);
			
		}
		
		//Creating Dijkstra's Algorithm to find the shortest path
		DijkstraUndirectedSP djksp = new DijkstraUndirectedSP(ewg2, 0);
		//
		
		//Printing the results
		System.out.println(djksp.toString());
		//
		
	}

}
