/**
 * 
 */
package Media;

/**
 * @author maiconalmeida
 *
	 */
	public class Boxset extends NTitle { // boxset clas is obtain elements from NTitle class
		
		
		public Boxset(String title, String year) {
			
			NTitle.title = title;
			NTitle.year = year;
			
		}
		@Override
		public String toString() {
			
			//print out the new title added
					return "New title successfully added " + title + " Director" + year;
			
			
		}
		
	
	}
