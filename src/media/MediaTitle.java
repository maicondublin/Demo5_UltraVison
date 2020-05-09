
package media;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import home.Principal;




/**
 * @author washington
 *
 */
public class MediaTitle {
	
	static String title;
	static String year;
	static String genre;
	static String director;
	static String set;
	
	public MediaTitle() {
		MediaTitle();
	}
	
	public void MediaTitle() {
		
		int menu = 0;
		// menu for scanner
		int menu1 = 0;
		
		Scanner input = new Scanner(System.in);
		
		do {
			//print menu o option
			
			System.out.println("======= MENU ======");
			System.out.println("1. MOVIE");
			System.out.println("2. MUSIC");
			System.out.println("1. BOXSET");
			System.out.println("1. PRINCIPAL");
		
			menu = input.nextInt();
			
			//get input from the user & send it forward to accord to the options
			if (menu1 == (1)) {
				addMovie();
			}
			if (menu1 == (2)) {
				addLconcert();
			}
			if (menu1 == (3)) {
				addBoxset();
			}
			if (menu1 == (4)) {
				
				Principal principal = new Principal();
				principal.Principal();
			
			}else {
				System.out.println("*********************************");
				System.out.println("Select one option from the menu");
				System.out.println("*********************************");
				MediaTitle();
				
			}
		}While(menu==0);
	}
	//addMovie class is taking the info for the new title.
			//upload it to the customer DB.
	
	public void addMovie() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Movie Title");
		title = input.next();
		
		System.out.println("Movie year of release YYYY");
		year = input.next();
		
		System.out.println("Director");
		director= input.next();
		
		System.out.println("Movie genre");
		genre= input.next();
	
		System.out.println("Set (DVD _ CD _ BluR)");
		set= input.next();	
		
		System.out.println("Add new Movie title ?");
		System.out.println("Digit 1 for YES");
		System.out.println("Digit 2 for NO");
		
		int Option = input.nextInt();
		
		try {
			//Inside of the Try/Catch block of code will be 
			//the set of statments where an exception can occur
			// set of permissions where it will get into the SQL
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String dbServer = "jdbc:mysql:3306/ultrauv";
			String user = "root";
			String password = "root";
			
		//// Get a connection to DB
			Connection con = DriverManager.getConnection(dbServer, user, password);
			
			// Get a statement from the connection
			Statement stmt = con.createStatement();
			
			String InsertCustomer = "INSERT INTO movie"
					+ "(title, year_of_release, genre, director, set)"// from DB
					+ "VALUES ('"+ "" +title+"" +"',''+year +"','"+genre +"','"+ director +"', '"+ set +"')"; // from a class
					//Strings that hold a query that insert data into DB
			
		
			if (Option ==(1)) {
				//Execute the query
				stmt.executeUpdate(InsertCustomer);
				Movie video = new Movie (title, year, genre, director, set); // call the variable from the movie class
				
				System.out.println(video);
				
			}else {System.out.println("Invalid connect to the database, please");}
			
		}catch (Exception e) { 
			System.out.print(e);
			}
		
		//addBoxSet class is taking a inf. for the new title 
				// upload into a  customer DB
		public void addLconcert() {
			
			Scanner input = new Scanner (System.ie);
			
			System.out.println("Live Concert / Music Title");
			title = input.next();
			
			System.out.println("Year of release YYYY");
			year = input.next();
			
			System.out.println("Band");
			band = input.next();
		
			System.out.println("Set (DVD - CD - BluR)");
			set = input.next();
			
			System.out.println(" Add new Live Concert / Music title?");
			System.out.println(" Digit 1 for YES");
			System.out.println(" Digit 2 for NO");
			
			int Option = input.nextInt();
			
			try {
				
				//Inside of the Try/Catch block of code will be 
				//the set of statments where an exception can occur
				// set of permissions where it will get into the SQL
				
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String dbServer = "Jdbc:mysql://localhost:3306/ultrauv";
				String user = "root";
				String password = "root";
				
				// Get a connection to DB
				Connection con = DriverManager.getConnection(dbServer, user, password) ;
				
				// Get a statement from the connection
				Statement stmt = con.createStatement();
				
				String InsertClient = "INSERT INTO music"
						+ "(title, year_of_release, band, set)" //from DB
						+ "VALUES ('"+ "" + title +"" +"','"+ year +"','"+ band +"','"+ set +"')"; //from a class
				//Strings that hold a query that insert data into DB
				
				if(Option ==(1)) {
					stmt.executeUpdate(insertCustomer);
					Lconcert video = new Lconcert (title, year, band, set); // call the variable from a movie class
					
					System.out.println(video);
					
				}else {System.out.println("Invalid connect to the database, please");}
				
			}catch (Exception e) {
				System.out.print(e);
				}
			}
	
				
	//addBoxSet class is taking a inf. for the new title 
	   // upload into a  customer DB	
	
	public void addBoxSet() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Boxset Title");
		title = input.next();
		
		System.out.println("Boxset year of release YYYY");
		year = input.next();
		
		System.out.println("ADD new Boxset title?");
		System.out.println("Digit 1 for YES?");
		System.out.println("Digit 2 for NO?");	
		
		int Option = input.nextInt();
		
		//Inside of the Try/Catch block of code will be 
		//the set of statments where an exception can occur
		// set of permissions where it will get into the SQL
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			
			//Get a connection to DB
			Connection con = DriveManager.getConnection(dvServer, user, password);
			
			
			//Get a statement from the connection
			Statement stmt = con.createStatement();
			
			String InsertClient = "INSERT INTO boxset"
					+ "(title, year_of_release) " // from DB
					+ "VALUES ('"+ "" + title +"" +"','"+ year +"')"; //from a class
			// String that hold a query that insert data into database
			
			
			if (Option ==(1)) {
				
				//Execute the query
				
				stmt.executeUpdate(InsertClient);
				Boxset video = new Boxset (title,year ); // call a variables from a movies class
				
				System.out.println(video);
				
			
				
			} else {System.out.println("Invalid, connect to the database, please");}
			
		} catch(Exception e) {System.out.print(e);}
	}

}
