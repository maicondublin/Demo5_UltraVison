/**
 * 
 */
package plan;

/**
 * @author maiconalmeida
 *
 */
public abstract class Customer {
	
	//variables
	protected String name;
	protected String plan;
	protected String credcard;
	protected int points;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getCredcard() {
		return credcard;
	}
	public void setCredcard(String credcard) {
		this.credcard = credcard;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
