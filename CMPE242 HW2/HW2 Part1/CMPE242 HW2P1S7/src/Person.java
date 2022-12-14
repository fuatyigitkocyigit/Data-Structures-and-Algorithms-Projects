//-----------------------------------------------------
// Title: Person class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 3
// Assignment: 2
// Description: This class is the person class that we will use. It has the name, surname and id of the persons
//-----------------------------------------------------

public class Person implements Comparable<Person> { //STEP 7
	
	public String Name;
	public String Surname;
	public long Id;
  
	public Person(String nameA, String surnameA, long idA){
		//--------------------------------------------------------
		// Summary: Constructor of the person class
		//--------------------------------------------------------
		
		this.Name = nameA;
		this.Surname = surnameA;
		this.Id = idA;
		
	}
  
   public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		this.Surname = surname;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public int compareTo(Person comp){
		//--------------------------------------------------------
		// Summary: Compares which person's ID is bigger.
		// Precondition: Gets an person object from user.
		// Postcondition: Compared two person's ID and returned an int value which is the result of the comprasion.
		//--------------------------------------------------------
		
		if(this.Id > comp.Id)//bigger
			return +1;
		if(this.Id < comp.Id)//smaller
			return -1;
		else//equal
			return 0;
       
	}
  
	public String toString(){
		//--------------------------------------------------------
		// Summary: toString method of person class
		//--------------------------------------------------------
		
		return this.Id + " " + this.Name + " " + this.Surname;
       
	}
}