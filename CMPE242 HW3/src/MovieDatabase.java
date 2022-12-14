//-----------------------------------------------------
// Title: Movie Database
// Author: Fuat Yiðit Koçyiðit & Günsu Günaydýn
// ID: 16429085948 & 18098680134
// Section: 3
// Assignment: 3
// Description: This class includes main part, queries and creates a movie database.
//-----------------------------------------------------

public class MovieDatabase {
	static int count2 = 0;
	static Movie[] MovieArray = new Movie[100];
	static BST tree; 

	String DatabaseName;
	
	public MovieDatabase(String name) {
		this.DatabaseName = name;
		
	}

	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay, int releaseMonth, int releaseYear) {
		//--------------------------------------------------------
		// Summary: Creates a new movie and adds it to the tree and movie array.
		// Precondition: Took 3 string and 3 integer variables from the user
		// Postcondition: A new movie object is created and put to the array and tree
		//--------------------------------------------------------
		
		Movie newMovie = new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);
		MovieArray[count2] = newMovie;
		//tree.put(releaseYear, newMovie);
		count2++;
		System.out.println("INFO: Movie "+movieTitle+" has been added");
		
	}
	
	public void removeMovie(String movieTitle) {
		//--------------------------------------------------------
		// Summary: Removes a movie from the tree and movie array.
		// Precondition: Took 1 string from the user which is the movie title
		// Postcondition: Removed the movie from tree and movie array.
		//--------------------------------------------------------
		
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].Title.equals(movieTitle)) {
				MovieArray[i] = null;
				//tree.delete(MovieArray[i].Year);
				count2--;
				System.out.println("INFO: Movie "+movieTitle+" has been removed.");
				
			}
			
		}
		
	}
	
	public void addActor(String movieTitle, String actorFirstName, String actorLastName, String actorRole) {
		//--------------------------------------------------------
		// Summary: Adds an actor to a movie.
		// Precondition: Took 4 string from the user.
		// Postcondition: Added an actor to the movie.
		//--------------------------------------------------------
		
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].Title.equals(movieTitle)) {
				MovieArray[i].AName[MovieArray[i].ACount] = actorFirstName;
				MovieArray[i].ALastName[MovieArray[i].ACount] = actorLastName;
				MovieArray[i].ARole[MovieArray[i].ACount] = actorRole;
				MovieArray[i].ACount++;
				System.out.println("INFO: "+actorFirstName+" "+actorLastName+" has been added to the movie "+movieTitle);
				
			}
				
		}
		
	}
	
	public void removeActor(String movieTitle, String actorFirstName, String actorLastName) {
		//--------------------------------------------------------
		// Summary: Removes an actor of the movie.
		// Precondition: Took 3 string from the user
		// Postcondition: Removed the actor.
		//--------------------------------------------------------
		
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].Title.equals(movieTitle)) {
				if(MovieArray[i].AName[i].equals(actorFirstName) && MovieArray[i].ALastName[i].equals(actorLastName)) {
					MovieArray[i].AName[i] = null;
					MovieArray[i].ALastName[i] = null;
					MovieArray[i].ARole[i] = null;
					System.out.println("INFO: "+actorFirstName+" "+actorLastName+" has been removed from the movie "+movieTitle);

				}
				
			}
			
		}

	}
	
	public void showAllMovies() {
		//--------------------------------------------------------
		// Summary: Prints all movie's information.
		// Postcondition: Printed the all movie's information in the tree.
		//--------------------------------------------------------
		
		for(int i=0; i<count2; i++) {
			System.out.println(MovieArray[i].toString());
			System.out.println();
			
		}
		
	}
	
	public void showMovie(String movieTitle) {
		//--------------------------------------------------------
		// Summary: Prints the searched movie.
		// Precondition: Took 1 string from the user which is the movie title
		// Postcondition: Printed the information of the searched movie.
		//--------------------------------------------------------
		
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].Title.equals(movieTitle)) {
				System.out.println(MovieArray[i].Title);
				System.out.println(MovieArray[i].Day+"/"+MovieArray[i].Month+"/"+MovieArray[i].Year);
				System.out.println(MovieArray[i].DName+" "+MovieArray[i].DLastName);
				for(int x=0; x<MovieArray[i].ACount; x++) {
					System.out.println(MovieArray[i].AName[x]+" "+MovieArray[i].ALastName[x]+", "+MovieArray[i].ARole[x]);
					
				}
				
			}

		}
		
	}
	
	public void showActorRoles(String actorFirstName, String actorLastName) {
		//--------------------------------------------------------
		// Summary: Prints the roles of the searched actor.
		// Precondition: Took 2 string from the user.
		// Postcondition: Printed the roles of the searched actor.
		//--------------------------------------------------------
		
		for(int i=0; i<count2 ; i++) {
			for(int ii=0; ii<MovieArray[i].ACount; ii++) {
				if(MovieArray[i].AName[ii].equals(actorFirstName) && MovieArray[i].ALastName[ii].equals(actorLastName))
					System.out.println(MovieArray[i].ARole[ii]);

			}
			
		}

	}
	
	public void showDirectorMovies(String directorFirstName, String directorLastName) {
		//--------------------------------------------------------
		// Summary: Prints the movies of the searched director.
		// Precondition: Took 2 string from the user.
		// Postcondition: Printed the movies of the searched director.
		//--------------------------------------------------------
		
		System.out.println(directorFirstName+" "+directorLastName);
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].DName.equals(directorFirstName) && MovieArray[i].DLastName.equals(directorLastName)) {
				System.out.println(MovieArray[i].Title+", "+MovieArray[i].Day+"/"+MovieArray[i].Month+"/"+MovieArray[i].Year);
				
			}
			
		}
		
	}
	
	public void showMovies(int releaseYear) {
		//--------------------------------------------------------
		// Summary: Prints the movies that are released in the given year.
		// Precondition: Took 1 integer from the user which is the movie release year.
		// Postcondition: Printed the movies that are released in the given year.
		//--------------------------------------------------------
		
		System.out.println(releaseYear);
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].Year == releaseYear) 
				System.out.println(MovieArray[i].toString());
			
		}
		
	}
	
	public void showMovies(int startYear, int endYear) {
		//--------------------------------------------------------
		// Summary: Prints the movies that are released in the given period.
		// Precondition: Took 2 integer from the user which are the period.
		// Postcondition: Printed the movies that are released in the given period.
		//--------------------------------------------------------
		
		System.out.println(startYear+"-"+endYear);
		for(int i=0; i<count2 ; i++) {
			if(MovieArray[i].Year >= startYear && MovieArray[i].Year <= endYear)
				System.out.println(MovieArray[i].toString());
			
		}
		
	}

	// // // // //
	
	public static void main(String[] args) {
		//--------------------------------------------------------
		// Summary: The main part of the program.
		//--------------------------------------------------------
		
		// TODO Auto-generated method stub

		MovieDatabase md = new MovieDatabase("Test");
		
		md.showAllMovies();
		
		System.out.println();
		
		md.addMovie("Eyes Wide Shut", "Stanley", "Kubrick", 22, 10, 1999);
		md.addMovie("Family Plot", "Alfred", "Hitchock", 9, 4, 1972);
		md.addMovie("Psycho", "Alfred", "Hitchock", 20, 5, 1960);
		md.addMovie("Sweet and Lowdown", "Woody", "Allen", 26, 1, 1999);
		md.addMovie("Midnight in Paris", "Woody", "Allen", 30, 9, 2011);
		md.addMovie("Barton Fink", "Coen", "Brothers", 21, 8, 1991);
		md.addMovie("The Interpreter", "Sydney", "Pollack", 22, 4, 2005);
		md.addMovie("Psycho", "Alfred", "Hitchock", 20, 5, 1960);
		
		System.out.println();
		
		md.showAllMovies();
		
		System.out.println();
		
		md.removeMovie("Midnight in Paris ");
		
		System.out.println();
		
		md.showAllMovies();
		
		System.out.println();
		
		md.showMovie("Eyes Wide Shut");
		
		System.out.println();
		
		md.addActor("Barton Fink", "John", "Turturro", "Barton Fink");
		md.addActor("Barton Fink", "John", "Goodman", "Charlie Meadows");
		md.addActor("Barton Fink", "Judy", "Davis", "Audrey Taylor");
		md.addActor("Barton Fink", "Michael", "Lerner", "Jack Lipnick");
		md.addActor("Eyes Wide Shut", "Tom", "Cruise", " Bill Harford");
		md.addActor("Eyes Wide Shut", "Nicole", "Kidman", "Alice Harford");
		md.addActor("Eyes Wide Shut", "Madison", "Eginton", "Helena Harford");
		md.addActor("Eyes Wide Shut", "Jackie", "Sawaris", "Roz");
		md.addActor("Eyes Wide Shut", "Sydney", "Pollack", "Victor Ziegler");
		md.addActor("Midnight in Paris", "Woody", "Allen", "Woody Allen");
		md.addActor("The Interpreter", "Nicole", "Kidman", "Silvia Broom");
		md.addActor("The Interpreter ", "Sean", "Penn", "Tobin Keller");
		md.addActor("The Interpreter ", "Earl", "Cameron", "Zuwanie");
		
		System.out.println();
		
		md.showMovie("Barton Fink");
		
		System.out.println();
		
		md.showMovie("Eyes Wide Shut");
		
		System.out.println();
		
		md.removeActor("Eyes Wide Shut", "Jackie", "Sawaris");
		
		System.out.println();
		
		md.showMovie("Eyes Wide Shut");
		
		System.out.println();
		
		md.showActorRoles("Nicole", "Kidman");
		
		System.out.println();
		
		md.showActorRoles("Judy", "Davis");
		
		System.out.println();
		
		md.showDirectorMovies("Alfred", "Hitchock");
		
		System.out.println();
		
		md.showDirectorMovies("Stanley", "Kubrick");
		
		System.out.println();
		
		md.showMovies(1999);
		
		System.out.println();
		
		md.showMovies(1972, 2005);
		
		System.exit(0);
		
	}

}
