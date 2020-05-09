/**
 * 
 */
package media;

/**
 * @author maiconalmeida
 *
 */
public class Boxset  extends NTitle{//boxset is obtain elements from NTile class
	
	public Boxset(String title, String year) {
		
	    NTitle.title = title;
		NTitle.year = year;
		
		
	}

	@Override
	public String toString() {
		//print out a new title added
		return "New Title successfuly added" + title + "director" + year;
	}
		
	}


