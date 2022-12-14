//-----------------------------------------------------
// Title: Movie
// Author: Fuat Yiðit Koçyiðit & Günsu Günaydýn
// ID: 16429085948 & 18098680134
// Section: 3
// Assignment: 3
// Description: This class defines a movie object.
//-----------------------------------------------------

public class Movie {
	static int count = 0;
	
	String Title;
	int Day, Month, Year;
	String DName, DLastName;
	String []AName = new String[100];
	String []ALastName = new String[100];
	String []ARole = new String[100];
	int ACount;
	
	public Movie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay, int releaseMonth, int releaseYear) {
		//--------------------------------------------------------
		// Summary: Constructor method of the object.
		//--------------------------------------------------------
		
		this.Title = movieTitle;
		this.Day = releaseDay;
		this.Month = releaseMonth;
		this.Year = releaseYear;
		this.DName = directorFirstName;
		this.DLastName = directorLastName;
		this.ACount = 0;
		
	}

	//--------------------------------------------------------
	// Summary: Get/Set methods of the object.
	//--------------------------------------------------------
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Movie.count = count;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getDLastName() {
		return DLastName;
	}

	public void setDLastName(String dLastName) {
		DLastName = dLastName;
	}

	public String[] getAName() {
		return AName;
	}

	public void setAName(String[] aName) {
		AName = aName;
	}

	public String[] getALastName() {
		return ALastName;
	}

	public void setALastName(String[] aLastName) {
		ALastName = aLastName;
	}

	public String[] getARole() {
		return ARole;
	}

	public void setARole(String[] aRole) {
		ARole = aRole;
	}

	public int getACount() {
		return ACount;
	}

	public void setACount(int aCount) {
		ACount = aCount;
	}

	//--------------------------------------------------------
	// Summary: toString method of the object
	//--------------------------------------------------------
	@Override
	public String toString() {
		return this.Title + ", " + this.Year + ", " + this.DName + " " + this.DLastName;
	}
	
}
