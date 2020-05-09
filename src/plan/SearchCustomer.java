package plan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import home.Main;

/**
 * @author Washington
 *
 */


public class SearchCustomer {
	
	static final String SearchCustomer = null;
	
	//record inputs from the user
	
	protected static String name;
	protected static String memship;
	static String plan;
	
	
	public void SearchCustomer() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("********** Search Customer ********");
		System.out.println("Customer Name");
		name = input.next();
		
		
		System.out.println("******* Membership number: ");
		memship = input.next();
		
		System.out.println("Search Name");
		name = input.next();
		
		System.out.println("Search Plan");
		plan = input.next();
		
		System.out.println("Confirm the Customer Search: ");
		System.out.println("Digit 1 for YES");
		System.out.println("Digit 2 for NO");
		int Option =input.nextInt();
		
		
		try {
			
			//a set of permissions to get into the SQL
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(dbServer, user, password) ;
			Statement stmt = con.createStatement() ;
			String SearchCustomer = "SEARCH Customer Membership ='" + plan + "', name = '"+ name +"',  where customer= " + memship +"";
			
			//Query used to update a DB with new info
			
			if(Option ==(1));
			stmt.execute(SearchCustomer);
			System.out.println("*********** Customer found successfully ************");
			
			
		}
		
		if(Option ==(2)) {
			//go back to the main page
			Main searchCustomer = new Main();
			searchCustomer.Main();
		}
		else {
			
		}
		
	}catch(Exception e) {System.out.print(e); }
}

}
