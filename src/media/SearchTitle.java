/**
 * 
 */
package Media;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import uvHome.Principal;

/**
 * @author washington
 *
 */
public class SearchTitle {

static String movie;
static String boxset;
static String music;
protected String title;
protected String year;
protected String band;

//array to store the data collect from the db
String TitleD[]=new String [5];


public void SearchTitle() {
	
	int menu = 0
	int menu1 = 0
	
	// menu for scanner
	
	try(Scanner input = new Scanner (System.in)) {
		do {
			// menu option to the select type of title
			
			System.out.println("******** Search for the Title********");
			System.out.println("1 - Movie");
			System.out.println("2 - Music");
			System.out.println("3 - TV Boxset");
			System.out.println("4 - Principal");
			
			//statement to post forward to the user as an option selected on the menu above
			menu1 = input.nextInt();
			
			
			if(menu1 == (1)) {
			SearchMovie();
			}
			
			if(menu == (2)){
			SearchMusic();
			}
			
			if(menu == (3)){
			SearchBoxset();
			}
			
			if(menu == (4)){
			Principal principal = new Principal ();
			principal.Principal();
			
		}
		else {
			System.out.println("Select one as option from the Menu");
			
		}while(menu==0);}}
	
	public void SearchMovie() {
		//scanner to record a input from a user
		
		try(Scanner input = new Scanner(System.in)){
			System.out.println("***** search Movie title *********");
			System.out.println("Title");
				title = input.next();
				System.out.println("Year of release:");
				year = input.next();
				
		
			// inside of the Try/Catch block of code will be
				// the set of statments where an exception can occur
				// set of permissions where it will get into the Sql
				
			
				try {
					
					
			Class.forName("com.mysql.cj.jdbc.Driver") .newInstance() ;
			String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection (dbServer, user,  password);
			Statement stmt = con.createStatement();
			String search = "Select * from movie where title = '" + title +"' and year_of_release = '" + year +"'";
			ResultSet data = stmt = stmt.executeQuery(search);
			
			while(data.next()) {
				
			// obtain data from the DB
				//recording on the TitleD array
				Title[0]=data.getString("title");
				Title[1]=data.getString("year_of_release");
				Title[2]=data.getString("genre");
				Title[3]=data.getString("director");
				Title[4]=data.getString("set");
				
				System.out.println("Title information as follow");
				System.out.println("Movie name * Year of Release * Genre * Director * Set");
				
				//print out the data from the title selected by a user
				for (int i = 0; i<5; i++) {
					
					System.out.println(TitleD[i]);
				}
			}
				}catch (Exception e) {System.out.print(e);}
				System.out.println(TitleD[i]);
				
		}
	}catch (Exception e )
	
}

public void SearchMusic() {
	//Scanner to record the input the user
	
	try(Scanner input = new Scanner (System.in)){
		System.out.println("******** Search Music Title");
		System.out.println("Music Title:");
		title = input.next();
		
		System.out.println("Band's name: ");
		band= input.next();
		
		
	}
	
	try {
		Class.forname("com.mysql.cj.jdbc.Driver").newInstance();
		String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(dbServer, user, password);
		Statement stmt = con.createStatement();
		String search = "Select * from music where title = '" + title +"' and band = '" + band +"'";
		ResultSet data = stmt.executeQuery(search);
		
		while (data.next());
		
		// recording on TitleD array [Tile date]
		TitleD[0]=data.getString("set");
		TitleD[1]=data.getString("title");
		TitleD[2]=data.getString("band");
		TitleD[3]=data.getString("year_of_release");
		
		System.out.println("Title information as Follow");
		System.out.println("Set* Music Name * Band/Singer * Year of release");
		
		// print out the data from the title selected by a user
		
		
		System.out.println(TitleD[0]);
		System.out.println(TitleD[1]);
		System.out.println(TitleD[2]);
		System.out.println(TitleD[3]);
		
	}
	catch(Exception e) {
		System.out.print(e);}
	
	}
	public void SearchBoxset() {
		//scanner to record the input from the user
		
		try (Scanner input = new Scanner (System.in)){
			System.out.println("*****Search Boxset Title *******");
			System.out.println("Boxset Title: ");
			title = input.next();
			
			System.out.println("Year of release: ");
			year = input.next();
			
		}
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
				String dbServer = "\"jdbc:mysql://localhost:3306/ultrauv";
				String user = "root";
				String password = "root";
				Connection con = DriverManager.getConnection(dbServer, user, password);
				Statement stmt = con.createStatement();
				String search = "Select * from boxset where title = '" + title +"' and year_of_release = '" + year +"'";
				ResultSet data = stmt.executeQuery(search);
				
				while(data.next());
				
				//obtain data from the DB
				// record on TitleD array [Title Date]
				
				
				System.out.println("Title information as follow");
				System.out.println("Boxset Name * Year of release");
				TitleD[0]=data.getString("title");
				TitleD[1]=data.getString("year_of_release");
				
				
				//print out the data from the title selected by a user
				System.out.println(TitleD[0]);
				System.out.println(TitleD[1]);
				System.out.println(TitleD[1]);
				
			}
			catch(Exception e) {
				System.out.print(e);
			}
				
						
				
			}
				)
		
	
	
			
			

	
}
	
}
