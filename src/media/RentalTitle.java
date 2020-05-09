/**
 * 
 */
package media;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import home.Main;

/**
 * @author maiconalmeida
 *
 */
public class RentalTitle {
	
	
	protected String name;
	protected String memship;
	protected String titleRental;
	
	
	//array to record a data collected from a DB
String Customer[] = new String [5]; // example

Scanner input = new Scanner(System.in);

public void RentalTitle() {
	
	
}

public RentalTitle() {
	
	
	System.out.println("******** Rental Title **********");
	System.out.println("Customer NAME: ");
	name = input.next();
	
	

	System.out.println("Membership Number");
	memship = input.next();
	
	
	//set stmt where an exception could occur
	//set permissions where it shall get into a SQL
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
		String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(dbServer, user, password) ;
		Statement stmt = con.createStatement();
		
		//select a  DB
		String search = "Select * from customer where memship = " + memship +" and name = '" + name +"'";
		ResultSet data = stmt.executeQuery(search) ;
		
		//obtain input from a user
		//checked if it is the same as in a DB
		while(data.next()) {
			Customer[0]=data.getString("memship");
			Customer[1]=data.getString("name");
			Customer[2]=data.getString("credcard");
			Customer[3]=data.getString("plan");
			Customer[4]=data.getString("points");
		}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
  //posting a user to other class accord with their subscption plan
   if (("VL").matches(Customer[3])) {
	
	//If the customer is a VL, it will send to RentVideo
	RentalVideoLovers(); 

}
  if (("ML").matches(Customer[3])){
	
	//If the customer is a ML, shall send to RentMusicLovers
	RentalMusicLovers(); 
}
  if (("TV").matches(Customer[3])){
	
	//If the customer is a TV lover, shall  send to RentTVLovers
	RentalTVLovers(); 
}
 if (("PR").matches(Customer[3])){
 	
	//If the customer is a PR, shall send to RentPremium
	RentalPremium(); 
	
}else {
	
	//dispatch to the beginning to start again the process
		Main main = new Main();
		main.Main();
	}

}
	//if a customer has VL subscript [video lovers - VL]
//rental shall be made by a RentalVideoLovers
public void RentalVideoLovers() {
	
	String title;
	
	String TitleD[] = new String[15]; //example
	
	//set stmt where an exception could occur
	//set permissions where it shall get into a SQL
     try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
		String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(dbServer, user, password) ;
		Statement stmt = con.createStatement() ;
		String search = "Select title from movie";
		ResultSet data = stmt.executeQuery(search) ;

		//obtain the data from a DB 
		// saving into an array
		for(int i =0; i<TitleD.length; i++) {
			if (data.next()) {

				TitleD[i]=data.getString("title");
				i++;
			}

		}
		
		System.out.println("************* Video Lovers Rental Title *************");
		
		//print the titles from the movie DB
		System.out.println(TitleD[0]);
		System.out.println(TitleD[2]);
		System.out.println(TitleD[4]);
		System.out.println(TitleD[6]);
		System.out.println(TitleD[8]);
		System.out.println(TitleD[10]);
		System.out.println(TitleD[12]);
		System.out.println(TitleD[14]);
		
        // post to the RentalDataBaseVL
		RentalDataBaseVL();

		System.out.println("Rent cancelled");
	}catch(Exception e) {
		System.out.print(e);
		}	
}

public void RentalDataBaseVL() {
	
	
	//obtian inputs from a user to rent or not a title
	System.out.println("Please, select a title to rent: ");
	titleRental = input.next();
	
	System.out.println("Would you like to rent this title?");
	System.out.println("1: YES");
	System.out.println("2: NO");
	int Option = input.nextInt();
	
	//the date of rent & return is set up as a static
	String rent_date = ("2020-04-20");
	String return_date = ("2020-04-23");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
		String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
		String user = "root";
		String password = "root";
		
		// Get a connection to the database
		Connection con = DriverManager.getConnection(dbServer, user, password) ;
	

		Statement stmt = con.createStatement() ;
		
		// Get a stment from the connection
		String InsertRental = "INSERT INTO rental" 
				+ "(title, customer, memship, rent_date, return_date) "
				+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";	
		//Strings that hold a query that insert data into database
		
		if(Option == (1)) {
			
			//if  a user select to rent a title
			//execute the query
			stmt.executeLargeUpdate(InsertRental);
			//print out a confirmation for a title rent
			System.out.println("Title was rent successfuly, retunt date" + return_date);
		}
		
		if(Option == (2)) {
			//if  a user selected not to rent a title
			//will print a rent cancelation E send back to the Main
			System.out.println("Rent has been cancel");
			
		}
	}catch(Exception e) {
		System.out.println(e);
	}
}
	
	//if a customer has a ML [music lovers] subscrption 
	//a rent must be made by RentalMusicLovers 
	public void RentalMusicLovers() {
		
		String title;
		
		String TitleD[] = new String[15];
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(dbServer, user, password) ;
			Statement stmt = con.createStatement() ;
			String search = "Select title from music";
			ResultSet data = stmt.executeQuery(search) ;

			//obtain the data from a DB 
			//save into  an array
			for(int i =0; i<TitleD.length; i++) {
				if (data.next()) {

					TitleD[i]=data.getString("title");
					i++;
				}

			}
			System.out.println("************** Music Lovers Rent Title");
			
			//print a title from a movie DB
			System.out.println(TitleD[0]);
			System.out.println(TitleD[2]);
			System.out.println(TitleD[4]);
			System.out.println(TitleD[6]);
			System.out.println(TitleD[8]);
			System.out.println(TitleD[10]);
			System.out.println(TitleD[12]);
			System.out.println(TitleD[14]);
		//	System.out.println();
		//	System.out.println();
			RentalDataBaseML();	
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void RentalDataBaseML() {
		
		
		System.out.println("Select a title to rent, please?");
		titleRental = input.next();
		
		//obtain a input from a user to rent or not a title
		System.out.println("Would tou like to rent this title?");
		System.out.println("1: YES");
		System.out.println("2: NO");
		int Option = input.nextInt();
		
		//date of rent & return are set as a static
		String rent_date = ("2020-04-20");
		String return_date = ("2020-04-23");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			
			// Get a connection to the database
			Connection con = DriverManager.getConnection(dbServer, user, password) ;
			

			// Get a stment from the connection
			Statement stmt = con.createStatement() ;
			String InsertRental = "INSERT INTO rental" 
					+ "(title, customer, memship, rente_date, return_date) "
					+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";	
			//Strings that hold a query that insert data into database

			if (Option== (1)) {

				//if the user chooses to rent a title
				// Execute the query
				stmt.executeLargeUpdate(InsertRental);
				//print out the confirmation for the title rent

				System.out.println("Title was rent succesfully, return  date " + return_date);
			}

			if(Option== (2)) {
				
				//if the user chooses to not rent the title,
				//shall print a rent cancelled and send back to the principal "page"
				System.out.println("Rent Cancelled");
			}	
		}catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	//if a custoemr has a TV subsption
	//must be made a rent title to RentTVLovers
	public void RentalTVLovers() {
		
		String title;
		
		String TitleD[] = new String[15];
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(dbServer, user, password) ;
			Statement stmt = con.createStatement();
			String search = "Select title from boxset";
			ResultSet data = stmt.executeQuery(search) ;
			//obtain  the data from a DB
			//save into an array

			for(int i =0; i<TitleD.length; i++) {
				if (data.next()) {

					TitleD[i]=data.getString("title");
					i++;
				}

			}

			System.out.println("*********** TV Lovers Rent Titles ********** ");

			//print the titles from the movie DB
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
		
		
		System.out.println("Select a title to rent:");
		titleRental = input.next();

		System.out.println("Would you like to rent this title?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		int Option= input.nextInt();
		
		
		//date of rent & return are set as a static
		String rent_date = ("2020-04-20");
		String return_date = ("2020-04-23");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			
			// obtain a connection to a DB
			Connection con = DriverManager.getConnection(dbServer, user, password) ;
			
			Statement stmt = con.createStatement() ;
			
			// obtain a stment from the connection
			String InsertRental = "INSERT INTO rental" 
					+ "(title, customer, memship, rent_date, return_date) "
					+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";	
			//Strings that hold a query that insert data into DB

			if (Option== (1)) {
				
				//if the user select to rent a title
				// Execute a query
				stmt.executeLargeUpdate(InsertRental);
				//print out the confirmation for a title rent

				System.out.println("Title was rent succesfully, return  date " + return_date);
			}

			if(Option== (2)) {
				//if the user select  not to  rent the title, 
				//Shall  print a rent cancelled and send back to the principal
				System.out.println("Rent Cancelled");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	//if a customer has a PR [premium] subsption
	//rent must be made by RentalPremiun
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
			
	
			
			//obtain the data from the database
			//save into  an array
			for(int i =0; i<TitleD.length; i++) {
				if (data.next()) {

					TitleD[i]=data.getString("title");
					

					i++;
				}

			}


			System.out.println("******** TV Lovers Rent Titles ******** ");

			//print the titles from the movie DB
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
		
		System.out.println("Select a title to rent");
		titleRental = input.next();
		
		System.out.println("Would you like to rent this title?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		int Option= input.nextInt();

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
					+ "(title, customer, memship, rented_date, return_date) "
					+ "VALUES ('"+ "" + titleRental +"" +"','"+ Customer[1] +"','"+ Customer[0] +"','"+ rent_date +"','"+ return_date +"')";	
			//Strings that hold a query that insert data into database

			if (Option== (1)) {

				//if the user select  to rent the title
				// Execute the query
				stmt.executeLargeUpdate(InsertRental);
				//print  out the confirmation for a title rent

				System.out.println("Title was rent succesfully, return  date " + return_date);
			}

			if(Option== (2)) {
				//if the user select not to rent a title
				//shall print a rent cancelled and send back to the principal "page"
				System.out.println("Rent Cancelled");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

	

















