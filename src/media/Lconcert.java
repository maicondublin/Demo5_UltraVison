package media;

// @author washington

public class Lconcert extends NTitle { // Lconcert is taking elements from a NTitle class 

	public Lconcert (String title, String year, String set, String band) {
		
	//recording data from a user input
		NTitle.title = title;
		NTitle.year = year;
		//this.set = set;
		NTitle.band = band;
		
	}
	@Override
	public String toString() {
		//print out the live concerts input
		return "New Live Concert / Music successfully recorded " + title + " Band" + band;
		
		
	}
}
