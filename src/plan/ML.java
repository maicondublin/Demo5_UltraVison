/**
 * 
 */
package plan;

/**
 * @author maiconalmeida
 *
 */
public class ML extends Customer{// ML [music lovers]
	
	public ML (String name, String plan, String credcard, int points) {
		
		this.name = name;
		this.plan = "ML";
		this.credcard = credcard;
		this.points = 1;
	}
	
	public String toString() {
		//print out a new customer saved into a DB
		return("Customer was successfully recorded" + name + "credcard number " + credcard);
		
	}

}
