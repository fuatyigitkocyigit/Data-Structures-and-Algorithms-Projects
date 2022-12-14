//-----------------------------------------------------
// Title: Scheduler tester class
// Author: Fuat Yiðit Koçyiðit & Günsu Günaydýn
// ID: 16429085948 & 18098680134
// Section: 3
// Assignment: 4
// Description: This class defines a task object which holds the name, deadline and duration of the task and includes the main method
//-----------------------------------------------------

import java.util.*;
import java.io.*;  

public class Tasks {
	
	String Name;
	int Deadline;
	int Duration;
	
	public Tasks(String NameA, int DeadlineA, int DurationA){
		//--------------------------------------------------------
		// Summary: Constructor method of the object.
		//--------------------------------------------------------
		this.Name = NameA;
		this.Deadline = DeadlineA;
		this.Duration = DurationA;
		
	}
	
	//--------------------------------------------------------
	// Summary: Get/Set methods of the object.
	//--------------------------------------------------------
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDeadline() {
		return Deadline;
	}

	public void setDeadline(int deadline) {
		Deadline = deadline;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	//--------------------------------------------------------
	// Summary: toString method of the object
	//--------------------------------------------------------
	@Override
	public String toString() {
		return "Tasks [Name=" + Name + ", Deadline=" + Deadline + ", Duration=" + Duration + "]";
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//--------------------------------------------------------
		// Summary: The main part of the program.
		//--------------------------------------------------------
		
		int time = 0;
		int due = 2400;
		int deadlinesArray[] = new int[100];
		Tasks TaskArray[] = new Tasks[100];
		int taskCount=0;
		Scanner txt = new Scanner(new FileReader("C:\\Users\\fuatk\\eclipse-workspace\\CMPE242 HW4\\sampleinput1.txt"));
		
		//--------------------------------------------------------
		// Summary: Getting input from the txt file and creating the task object. Then inserting them to the priority queue.
		// Precondition: Variables and priority queue has been created and are empty.
		// Postcondition: The Task objects has been created and put in the array and the priority queue.
		//--------------------------------------------------------
		while(txt.hasNextLine()) {
			if(txt.next().equals("schedule")) {
				String name = txt.next();
				int deadline = txt.nextInt();
				int duration = txt.nextInt();
				TaskArray[taskCount] = new Tasks(name, deadline, duration);
				
				PriorityQueue.insert(TaskArray[taskCount].Deadline);
				taskCount++;
				System.out.println("0: adding "+name+" with deadline "+deadline+" and duration "+duration);
				
			}
			else if(txt.next().equals("run")) {
				due = txt.nextInt();
				
			}
	
		}
		
		//--------------------------------------------------------
		// Summary: Creating an array to hold the deadlines according to the priority queue
		// Precondition:
		// Postcondition: Deadlines has been extracted and put to the array in reverse order.
		//--------------------------------------------------------
		for(int i=taskCount-1; i>=0; i--) {
			deadlinesArray[i] = PriorityQueue.extractMax(); 
			
		}
		
		//--------------------------------------------------------
		// Summary: Scheduling the program according to the priority queue and then printing to the screen.
		// Precondition: Deadline array is ready.
		// Postcondition: The tasks are extracted according to the deadline array and printed the schedule.
		//--------------------------------------------------------
		int k=0;
		while(time <= due) {
			Tasks extractedTask=null;
			int deadlinee = deadlinesArray[k];
			
			for(int i=0; i<taskCount; i++) {
				if(TaskArray[i].Deadline == deadlinesArray[k]) {
					extractedTask = TaskArray[i];
					
				}
				
			}
			int pretime = time;
			System.out.println(time+": busy with "+extractedTask.Name+" with deadline "+extractedTask.Deadline+" and duration "+extractedTask.Duration);
			time += extractedTask.Duration;
			
			//--------------------------------------------------------
			// Summary: If the run's due has been reached, we will re-insert the remaining task again.
			//--------------------------------------------------------
			if(time > due) {
				int updatedtime = time - due;
				System.out.println(due+": adding "+extractedTask.Name+" with deadline "+extractedTask.Deadline+" and duration "+(extractedTask.Duration-(due-pretime)));
				Tasks remainingTask = new Tasks(extractedTask.Name, extractedTask.Deadline, (extractedTask.Duration-(due-pretime)));
				PriorityQueue.insert(remainingTask.Deadline);
				
				break;
				
			}
			
			System.out.println(time+": done with "+extractedTask.Name);
			k++;
	
		}

	}

}
