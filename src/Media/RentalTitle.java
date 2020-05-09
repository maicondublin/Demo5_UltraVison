/**
 * 
 */
package Media;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import home.Principal;

/**
 * @author maiconalmeida
 *
 */
public class RentalTitle {
	
	protected String name;
	protected String cust_memship;
	protected String titleRental;
	
	//array to record the data from a DB
      String Customer[] = new String[5];
      Scanner input = new Scanner(System.in);

public void RentalTitle() {// not sure if i need this line here?!?!
	
}
public RentalTitle() {
	
	System.out.println("********* Rental Title **********");
	System.out.println("CUSTOMER NAME:");
	name = input.next();
	
	System.out.println("Membership Number");
	cust_memship = input.next();
	
	
	//inside of a try/catch shall have a set of stment where 
	//an exception cpuld occur
	//set of permission where it will get into the SQL
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(dbServer, user, password);
		Statement stmt = con.createStatement();
		
		//select a DB
		String search = "Select * from customer where cust_memship =" + cust_memship +" and name=" + name +"";
		ResultSet data = stmt.executeQuery(search);
		
		//obtain inputs from a user(s)
		//checked if it has the same as a DB
		while(data.next()) {
			Customer[0] = data.getString("cust_memship");
			Customer[1] = data.getString("name");
			Customer[2] = data.getString("credCard");
			Customer[3] = data.getString("plan");
			Customer[4] = data.getString("points");
		//	Customer[5] = data.getString(memship);
		//	Customer[6] = data.getString(memship);
		//	Customer[7] = data.getString(memship);
		//	Customer[0] = data.getString(memship);
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	//posting a user(s) to other class accord with their subspt plan
	if(("VL").matches(Customer[3])) {
		//if a customer is a VL
		//shall send to rent video
		RentalVideoLovers();
	}
	if(("ML").matches(Customer[3])){
		
		//if a customer is ML
		//shal send to RentMusicLovers
		RentalMusicLovers();
	}
	if(("TV").matches(Customer[3])) {
		
		//if a customer is a TV Lovers
		//shall send to RentTVLovers
		RentalTVLovers();
	}
	if(("PR").matches(Customer[3])) {
		
		//if a custoemr is a PR
		//shal send to RentPremiun
		RentalPremium();
	}
	else {
		//goes to the beginning of the menu to start the process again[supposedly]
		Principal principal = new Principal();
		principal.Principal();
	}
}

//if a customer has VL subscpt
//rent shall be made by a RentVideoLovers 
public void RentalVideoLovers() {
	
	String title;
	
	String TitleD[] = new String[15];
	
	  //inside of a try/catch shall have a set of stment where 
      //an exception cpuld occur
     //set of permission where it will get into the SQL
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(dbServer, user, password);
		Statement stmt = con.createStatement();
		String search = "Select title from movie";
		ResultSet data = stmt.executeQuery(search);
		
		//obtain the data from a DB
		//save into an array
		for(int i = 0; i < TitleD.length; i++) {
			if(data.next()) {
				TitleD[i] = data.getString("title");
				i++;
			}
		}
		System.out.println("************* Video Lovers Rent Title *************");
		
		//print a title from the movie DB
		System.out.println(TitleD[0]);
		System.out.println(TitleD[1]);
		System.out.println(TitleD[2]);
		System.out.println(TitleD[4]);
		System.out.println(TitleD[6]);
		System.out.println(TitleD[8]);
		System.out.println(TitleD[10]);
		System.out.println(TitleD[12]);
		System.out.println(TitleD[14]);
		
		//posting to the RentDataBaseVl [??!!]
		RentalDataBaseVL();
		
		System.out.println("Rent Canceled");
	
	} catch(Exception e) {
		System.out.println(e);
	}
}
	
	public void RentalDataBaseVL() {
		
		//obtain inputs from the user rent or not a title
		System.out.println("Select a title to rent, please?");
		titleRental = input.next();
		
		System.out.println("Would you like to rent this title?");
		System.out.println("1: YES");
		System.out.println("2: No");
		int Option = input.nextInt();
		
		//date & return of the rent is set as static
		String rent_date = ("2020-04-20");
		String return_date = ("2020-04-23");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			
			//get connection to a database
			Connection con = DriverManager.getConnection(dbServer, user, password);
			
			Statement stmt = con.createStatement();
			String InsertRental = "INSERT INTO rental" 
			+ "(title, customer, cust_membship, rented_date, return_date) "
			+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";
			
			//Strings that hold a query that insert data into DB
			
			if(Option == (1)){
				
				//if a user select to rent  title
				//execute a query
				stmt.executeUpdate(InsertRental);
				
				//print out a confirmation of the title rented
				System.out.println("Title was rent succesfully, return date" + return_date);
				
			}
			if(Option == (2)) {
				
				//if a user selected not to rent  a title
				//shall print a rent cancelled & send back to a principal "page"
				System.out.println("Rental cancel.");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//if a customer has ML subscpt
	//rent shall be made by RentalMusicLovers 
	public void RentalMusicLovers() {
		
		
		String title;
		
		String TitleD[] = new String[15];
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(dbServer, user, password);
			Statement stmt = con.createStatement();
			String search = "Select title from music";
			ResultSet data = stmt.executeQuery(search);
			
			
			//obatin the data from a DB
			//save into a array
			for(int i = 0; i < TitleD.length; i++) {
				if(data.next()) {
					TitleD[i] = data.getString("title");
					i++;
				}
			}
			System.out.println("********Music Lovers Rental Title **********");
			
			//print title from a movie DB
			System.out.println("TitleD[0]");
			System.out.println("TitleD[2]");
			System.out.println("TitleD[4]");
			System.out.println("TitleD[6]");
			System.out.println("TitleD[8]");
			System.out.println("TitleD[10]");
			System.out.println("TitleD[12]");
			System.out.println("TitleD[14]");
			//System.out.println("TitleD[0]");
			
			RentalDataBaseML();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
		public void RentalDataBaseML() {
			
			System.out.println("Select a title to rental: ");
			titleRental = input.next();
			
			//obtain a input from a user to rent or not a title
			System.out.println("Would you like to rental this title?");
			System.out.println("1: YES");
			System.out.println("2: No");
			int Option = input.nextInt();
			
			//date & return from the rent is set up static
			String rent_date = ("2020-04-20");
			String return_date = ("2020-04-23");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
				String user = "root";
				String password = "root";
				
				//get connection to a DB
				Connection con = DriverManager.getConnection(dbServer, user, password);
				
				//get a stmt from a connection
				Statement stmt = con.createStatement();
				String InsertRental = "INSERT INTO rental" 
				+ "(title, customer, cust_membship, rented_date, return_date) "
				+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";
				//strings that hold a query that insert data into DB
				
				if(Option == (1)) {
					
					//if a user selected a rental title
					//execute the query
					stmt.executeLargeUpdate(InsertRental);
					
					//print out the confirmation for the title
					System.out.println("Title rental succesfully, return data " + return_date);
				}
				if(Option == (2)) {
					//if a user selected not to rental a title
					//shal print rent cancelled and send back to the principal "page"
					System.out.println("Rental cancelled");
				}
					
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}
		 
		//if a customer has TV subscpt
		//rental shall be made by RentalTVLovers 
		
		public void RentalTVLovers() {
			
			String title;
			
			String TitleD[] = new String[15];
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
				String user = "root";
				String password = "root";
				Connection con = DriverManager.getConnection(dbServer, user, password);
				Statement stmt = con.createStatement();
				String search = "Select title from boxset";
				ResultSet data = stmt.executeQuery(search);
				
				//obtain the data from a Db
				//save into a array 
				for(int i = 0; i < TitleD.length; i++) {
					if(data.next()) {
						TitleD[i] = data.getString("title");
						i++;
					}
				}
				
				System.out.println("********** TV Lovers Rental Title **********");
				
				//print a title from a movie DB
				System.out.println(TitleD[0]);
				System.out.println(TitleD[2]);
				System.out.println(TitleD[4]);
				System.out.println(TitleD[6]);
				System.out.println(TitleD[8]);
				System.out.println(TitleD[10]);
				System.out.println(TitleD[12]);
				System.out.println(TitleD[14]);
				
				RentalDataBaseTV();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public void RentalDataBaseTV() {
			
			System.out.println("Select a title to rent");
			titleRental = input.next();
			
			//obtain a input from a user to rent or not a title
			System.out.println("Would you like to rental this title?");
			System.out.println("1: YES");
			System.out.println("2: No");
			int Option = input.nextInt();
			
			//date & return from the rent is set up static
			String rent_date = ("2020-04-20");
			String return_date = ("2020-04-23");
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
				String user = "root";
				String password = "root";
				
				//obtain connection to a DB
				Connection con = DriverManager.getConnection(dbServer, user, password);
				Statement stmt = con.createStatement();
				
				//obatain a stmt from a connection 
				String InsertRental = "INSERT INTO rental" 
						+ "(title, customer, cust_membship, rented_date, return_date) "
						+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";
						//strings that hold a query that insert data into DB
				
				if(Option == (1)) {
					
					//if a user select to rent a title
					//execute a query
					stmt.executeUpdate(InsertRental);
					
					//print out a confirmation for a title rent
					System.out.println("Title rent succesfully, return date" + return_date);
				}
				
				if(Option == (2)) {
					//if a use select not to rent a title
					//shall print rent cancelled and send back to the principal "main"
					System.out.println("Rental cancel");
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
			//i f a customer has a PR subscpt
			//rent shall be made by a RentalPremium
			
			public void RentalPremium() {
				
				String title;
				
				String TitleD[] = new String[15];
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
					String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
					String user = "root";
					String password = "root";
					Connection con = DriverManager.getConnection(dbServer, user, password) ;
					Statement stmt = con.createStatement();
					String search = "Select title, title, title from boxset, movie, music";
					ResultSet data = stmt.executeQuery(search);
					
					//obtain a data from a DB
					//save into a array
					for(int i = 0; i < TitleD.length; i++) {
						if(data.next()) {
							TitleD[i] = data.getString("title");
							i++;
						}
					}
					
					System.out.println("************ TV Lovers Rental Title**********");
					
					//printthe title from movie DB
					System.out.println(TitleD[0]);
					System.out.println(TitleD[2]);
					System.out.println(TitleD[4]);
					System.out.println(TitleD[6]);
					System.out.println(TitleD[8]);
					System.out.println(TitleD[10]);
					System.out.println(TitleD[12]);
					System.out.println(TitleD[14]);
					
					RentalDataBasePR();
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		public void RentalDataBasePR() {
			
			System.out.println("Select a title to rent?");
			titleRental = input.next();
			
			System.out.println("Would you like to rent this title?");
			System.out.println("1: Yes");
			System.out.println("2: No");
			int Option = input.nextInt();
			
			//The date of rent and return is set up as a static 
			String rent_date = ("2020-04-20");
			String return_date = ("2019-04-23");
			
		
			try {

				Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
				String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
				String user = "root";
				String password = "root";
				
				// obtain a connection to a DB
				Connection con = DriverManager.getConnection(dbServer, user, password) ;
				

				Statement stmt = con.createStatement() ;
				
				//obtain  a stment from the connection
				String InsertRental = "INSERT INTO rental" 
						+ "(title, customer, cust_memship, rent_date, return_date) "
						+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";	
				//Strings that hold a query that insert data into database

				if (Option== (1)) {

					//if the user select  to rent the title
					// Execute the query
					stmt.executeUpdate(InsertRental);
					//print  out the confirmation for a title rent

					System.out.println("Title was rent succesfully, return  date " + return_date);
				}

				if(Option== (2)) {
					//if the user select not to rent a title
					//shall print a rent cancelled and send back to the principal "page"
					System.out.println("Rent Cancelled");
					}

				}catch(Exception e) {
					System.out.print(e);
				}		
				
	}
}
	












































