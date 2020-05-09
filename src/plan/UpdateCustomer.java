package plan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import home.Main;

/**
 * @author Washington
 *
 */

public class UpdateCustomer {
	
	//record inputs from the user
	
	protected static String name;
	protected static String memship;
	protected static String newName;
	static String newPlan;
	protected static String newCredcard;
	
	public void UpdateCustomer() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("********* UPdate Customer ********");
		System.out.println("Customer Name: ");
		name = input.next();
		
		
		
		System.out.println("Memship number: ");
		memship = input.next();
		
		System.out.println("Update Name ");
		newName = input.next();
		
		System.out.println("Update to a new plan ");
		newPlan = input.next();
		
		System.out.println("Update Credit Card Number ");
		newCredcard = input.next();
		
		System.out.println("Confirm the Customer Update ?");
		System.out.println("Digit 1 for YES");
		System.out.println("Digit 2 for NO");
		int Option = input.nextInt();
		
		try {
			// a set of permissions to get into the SQL
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(dbServer, user, password) ;
			Statement stmt = con.createStatement() ;
			String UpdateCustomer = "UPDATE Customer SET plan ='" + newPlan + "', name = '"+ newName +"', creditcard ="+ newCredcard + " where memship= " + memship +"";
			
			
			//Query used to update a DB with new info
			
			if(Option ==(1)) {
				stmt.executeUpdate(UpdateCustomer);
				System.out.println("****** Customer update Successfully");
			}
			
			if (Option == (2)) {
				// go back to the main page
				Main Update = new Main();
				Update.Main();
				
			}
			else {
				
			}
			
		}catch(Exception e) {System.out.print(e);}
		
			
		}
		
	}
	
	


