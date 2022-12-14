//-----------------------------------------------------
// Title: CMPE242 HW1
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 1
// Description: This class defines a VaccineStock object and includes the main function.
//-----------------------------------------------------

import java.util.Scanner;

public class VaccineStock {
	//--------------------------------------------------------------
	// Summary: The class which holds the properties of the Vaccine and creates Vaccine object.
	//--------------------------------------------------------------
	static myStack vaccineStack = new myStack();
	Scanner keyboard = new Scanner(System.in);
	int serialNumber;
    String countryName;
    int numberOfVaccines;
    
    public VaccineStock(int serialNumberA, String countryNameA, int numberOfVaccinesA) {
    	//--------------------------------------------------------------
    	// Summary: Constructor of the VaccineStock class.
    	// Precondition: serialNumber is an integer, countryName is a string and numberOfVaccines is an integer.
    	// Postcondition: Created a VaccineStock object with given parameters.
    	//--------------------------------------------------------------
        this.serialNumber = serialNumberA;
        this.countryName = countryNameA;
        this.numberOfVaccines = numberOfVaccinesA;
        
    }
    
    public int getSerialNumber() {
    	//--------------------------------------------------------------
    	// Summary: Get method of the SerialNumber value which is an integer.
    	//--------------------------------------------------------------
        return serialNumber;
    }
    
    public String getCountryName() {
    	//--------------------------------------------------------------
    	// Summary: Get method of the countryName value which is an integer.
    	//--------------------------------------------------------------
        return countryName;
    }
    
    public int getNumberOfVaccines() {
    	//--------------------------------------------------------------
    	// Summary: Get method of the numberOfVaccines value which is an integer.
    	//--------------------------------------------------------------
        return numberOfVaccines;
    }
    
    public void setSerialNumber(int serialNumber) {
    	//--------------------------------------------------------------
    	// Summary: Set method of the serialNumber value which is an integer.
    	//--------------------------------------------------------------
		this.serialNumber = serialNumber;
	}

	public void setCountryName(String countryName) {
		//--------------------------------------------------------------
    	// Summary: Set method of the countryName value which is an integer.
    	//--------------------------------------------------------------
		this.countryName = countryName;
	}

	public void setNumberOfVaccines(int numberOfVaccines) {
		//--------------------------------------------------------------
    	// Summary: Set method of the numberOfVaccines value which is an integer.
    	//--------------------------------------------------------------
		this.numberOfVaccines = numberOfVaccines;
	}

	public String toString() {
    	//--------------------------------------------------------------
    	// Summary: toString method of the VaccineStock class to use it when printing the object info to the screen.
    	//--------------------------------------------------------------
        return this.serialNumber+", " +this.countryName+", " +this.numberOfVaccines;
    }
    
	public void popItem() {
		//--------------------------------------------------------------
    	// Summary: Pops an item from the top of the stack.
    	// Postcondition: Popped the first item from the top of the stack and printed it which is a VaccineStock object.
    	//--------------------------------------------------------------
		System.out.println(vaccineStack.pop().toString());
		
	}
	
	public void pushItem(VaccineStock item) {
		//--------------------------------------------------------------
    	// Summary: Pushes an item to top of the stack.
    	// Precondition: Method parameter is a VaccineStock variable.
    	// Postcondition: Pushed the given VaccineStock variable to top of the stack.
    	//--------------------------------------------------------------
		vaccineStack.push(item);
		
	}
	
	public int action() {
		//--------------------------------------------------------------
    	// Summary: Reads the command from the user and gets input from the user according to that command and does 
		//			the required process.
    	// Postcondition: Took the command from the user and returned an integer value according to the input.
    	//--------------------------------------------------------------
		System.out.println("Enter Command?");
   		String input1 = keyboard.next();
   		switch(input1) {
    	//--------------------------------------------------------------
    	// Summary: Reads the command from the user and gets input from the user according to that command and does 
		//			the required process.
    	//--------------------------------------------------------------
		case "ADD":
			return 1;
			
		case "DELETE":
			return 2;
		
		case "EXIT":
			return 3;

		default:
			return 4;
		
		}
	}
	
    public static void main(String[] args) {
    	//--------------------------------------------------------------
    	// Summary: Main function of the project.
    	//--------------------------------------------------------------
    	Scanner keyboard = new Scanner(System.in);
    	
    	while(true) {
        	//--------------------------------------------------------------
        	// Summary: Prints the action menu and gets the input from the user.
        	//--------------------------------------------------------------
    		
    		System.out.println("Enter Command?");
       		String input1 = keyboard.next();
       		
    		switch(input1) {
        	//--------------------------------------------------------------
        	// Summary: Reads the command from the user and gets input from the user according to that command and does 
    		//			the required process.
        	//--------------------------------------------------------------
    		case "ADD": //ADD
    			System.out.println("Enter ITEM DATA?");
    			//--------------------------------------------------------------
            	// Summary: Gets 2 more input from the user to create the VaccineStock object. Then pushes it to the stack.
            	//--------------------------------------------------------------
    			int input2 = keyboard.nextInt();
    			String input3 = keyboard.next();
    			int input4 = keyboard.nextInt();
    			
    			VaccineStock newVac = new VaccineStock(input2, input3, input4);
    			vaccineStack.push(newVac);
    			break;
    			
    		case "DELETE": //DELETE
    			//--------------------------------------------------------------
            	// Summary: Pops the item at the top of the stack and prints it.
            	//--------------------------------------------------------------
    			VaccineStock item = vaccineStack.pop();
    			System.out.println(item.toString());
    			break;
    		
    		case "EXIT": //EXIT
    			//--------------------------------------------------------------
            	// Summary: Prints all the remaining items and ends the program.
            	//--------------------------------------------------------------
    			while(!(vaccineStack.isEmpty())){
    				System.out.println(vaccineStack.pop());
    				
    			}
    			System.exit(0);
    			break;
   
    		default: //others
    			//--------------------------------------------------------------
            	// Summary: Not a valid command.
            	//--------------------------------------------------------------
    			System.out.println("Invalid Input");
    			break;
    		
    		}
    	}
    	
    }
    
}
