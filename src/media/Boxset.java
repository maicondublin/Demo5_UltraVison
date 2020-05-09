/**
 * 
 */
package media;

/**
 * @author washington
 *
 */
public class Boxset extends NTitle { // Boxset Class is taking elements from the NTitle class
	

	public Boxset (String title, String year) {
		
		NTitle.title = title;
		NTitle.year = year;
		
		
	}
	
	
	@Override
	public String toString(){
		
		
		//print out the new title added
		return " New title successfully added " + title + "Director" + year;
		
		}
}
