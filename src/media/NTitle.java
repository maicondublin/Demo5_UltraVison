/**
 * 
 */
package media;

/**
 * @author maiconalmeida
 *
 */
public abstract class NTitle extends MediaTitle { //obtian elements of media title class
	
	//storing data from a user inputs
	static String title;
	static String year;
	
	
	//getting input from a user 
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		NTitle.title = title;
	}
	public static String getYear() {
		return year;
	}
	public static void setYear(String year) {
		NTitle.year = year;
	}

}
