//-----------------------------------------------------
// Title: CMPE242 HW1
// Author: Fuat Yiğit Koçyiğit
// ID: 16429085948
// Section: 3
// Assignment: 1
// Description: This class defines a Vaccine object and includes the main function.
//-----------------------------------------------------

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Vaccine {
	//--------------------------------------------------------------
	// Summary: The class which holds the properties of the groups and creates Vaccine object.
	//--------------------------------------------------------------
	static int X;
	public String Gname;
	public int Gnumber;
	
	public Vaccine(String b, int c) {
    	//--------------------------------------------------------------
    	// Summary: Constructor of the Vaccine class.
    	// Precondition: Gname is a string and Gnumber is an integer value.
    	// Postcondition: Created a Vaccine object with given parameters.
    	//--------------------------------------------------------------
		this.Gname = b;
		this.Gnumber = c;
		
	}
	
	public int getX() {
    	//--------------------------------------------------------------
    	// Summary: Get method of the X value which is an integer (and which is the daily capacity).
    	//--------------------------------------------------------------
		return X;
	}
	
	public void setX(int x) {
    	//--------------------------------------------------------------
    	// Summary: Set method of the X value which is an integer (setting the daily capacity).
    	//--------------------------------------------------------------
		X = x;
	}
	
	public String getGname() {
		//--------------------------------------------------------------
    	// Summary: Get method of the Gname value which is a string.
    	//--------------------------------------------------------------
		return Gname;
	}
	
	public void setGname(String gname) {
		//--------------------------------------------------------------
    	// Summary: Set method of the Gname value which is a string.
    	//--------------------------------------------------------------
		Gname = gname;
	}
	
	public int getGnumber() {
		//--------------------------------------------------------------
    	// Summary: Get method of the Gnumber value which is an integer.
    	//--------------------------------------------------------------
		return Gnumber;
	}
	
	public void setGnumber(int gnumber) {
		//--------------------------------------------------------------
    	// Summary: Set method of the Gnumber value which is an integer.
    	//--------------------------------------------------------------
		Gnumber = gnumber;
	}

	public String toString() {
    	//--------------------------------------------------------------
    	// Summary: toString method of the Vaccine object to use it when printing the object info to the screen.
    	//--------------------------------------------------------------
		return this.Gname + " " + this.Gnumber;
	}
	
	public static void main(String args[]) throws FileNotFoundException {
    	//--------------------------------------------------------------
    	// Summary: Main function of the project.
    	//--------------------------------------------------------------
		Scanner keyboard = new Scanner(System.in);
		File inFile = new File("C:\\Users\\fuatk\\eclipse-workspace\\CMPE242 HW1P2\\COVID19.txt");
		Scanner scannerFile = new Scanner(inFile);
		
		myQueue vaccineQueue = new myQueue();
		String input2;
		int input3;
		Vaccine Groupp;
		
		//--------------------------------------------------------------
    	// Summary: Gets the daily capacity input from the user which is an integer value.
    	//--------------------------------------------------------------
		String i1 = scannerFile.nextLine();
		int input1 = Integer.parseInt(i1);
		X = input1;
		
		while(true) {
	    	//--------------------------------------------------------------
	    	// Summary: Gets the input about the groups from the user and creates Vaccine object. Then adds that object to the queue.
	    	//--------------------------------------------------------------
			if(scannerFile.hasNextLine()) {
				String i2 = scannerFile.nextLine();
				input2 = i2.substring(0,i2.indexOf(" "));
				String i3 = i2.substring((i2.indexOf(" ")+1));
				input3 = Integer.parseInt(i3);
			}
			else 
				break;
			
			Groupp = new Vaccine(input2, input3);
			vaccineQueue.enqueue(Groupp);
			
		}
		
		int count = 1;
		int sumDay = 0;
		int totalsum = 0;
		while(true) {
	    	//--------------------------------------------------------------
	    	// Summary: Finds which group will be printed in which day and also calculates the total student and total day.
	    	//--------------------------------------------------------------
			if(vaccineQueue.isEmpty()==true) {
				System.out.println("");
				break;
			}
			Vaccine Grupdeque = vaccineQueue.dequeue();
			sumDay = sumDay + Grupdeque.Gnumber;
			totalsum = totalsum + Grupdeque.Gnumber;
			System.out.print("Day"+count+": "+Grupdeque.toString() + " ");
			
			if(vaccineQueue.isEmpty()==true) {
				System.out.println("");
				break;
			}
			while(true) {
				if(sumDay + vaccineQueue.peek().Gnumber <= X) {
					Grupdeque = vaccineQueue.dequeue();
					sumDay = sumDay + Grupdeque.Gnumber;
					totalsum = totalsum + Grupdeque.Gnumber;
					System.out.print(Grupdeque.toString()+" ");
					
				}
				else
					break;
				
			}
			System.out.println("");
			sumDay = 0;
			count++;
			
		}
		System.out.println("Total Student: "+totalsum);
		System.out.println("Total Day: "+count);
		
	}
	
}
