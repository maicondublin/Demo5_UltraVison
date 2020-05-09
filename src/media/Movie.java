package media;

/////// @author washington

public class Movie  extends NTitle{

	
	public Movie(String title, String genre, String set, String director, String year) {
		
		//storing data from the user input
		NTitle.title = title;
		NTitle.genre = genre;
		NTitle.set = set;
		NTitle.director = director;
		NTitle.year = year;
	}
	
	@Override
	public String toString() {
		//print out a movie input
		return " New title successfully added " + title + " Director" + director;
	}
}
