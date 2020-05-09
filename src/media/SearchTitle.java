package media;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import home.Main;
import java.util.Scanner;


//@author washington

public class SearchTitle {
	
	//to store the input from user

	
	static String movie;
	static String boxset;
	static String music;
	protected String title;
	protected String year;
	protected String band;
	
	//array to store the data collect from the DB
	String TitleD[]=new String[5];
	
	public void SearchTitle() {
		
		int menu = 0;
		int menu1 = 0;
		//menu for scanner
		
		try(Scanner input = new Scanner(System.in)){
			
			do {
				//menu option to be select by type of title
				
				System.out.println("********* Search for a Title ***********");
				System.out.println("1 - Movie");
				System.out.println("2 - Music");
				System.out.println("3 - TV Boxset");
				System.out.println("4 - Principal");
				
				// statement to post forward to the user as an option selected on the menu above
				menu1 = input.nextInt();
				
				if (menu1 == (1)) {
					SearchMovie();
					}
					
					if (menu1 == (2)) {
						SearchMusic();
					}
					
						if (menu1 == (3)) {
							SearchBoxset();
						}
			
							if (menu1 == (4)) {
								Main main = new Main();
								main.Main();
											
								}
							
							else {
								System.out.println("Select one option from the Menu");
							}
						} while(menu==0);}
		}
				
				
				public void SearchMovie() {
					
					//Scanner to record a input from a user
					
					try(Scanner input = new Scanner(System.in)){
						System.out.println("****** Search Movie title *********");
						System.out.println("Title:");
							title = input.next();
						System.out.println("Year of Release: ");
							year = input.next();
							
					}
					
					//Inside of the try/Catch block of code will be
					// the set of statments where an exception can occur
					// set of permissions where it will get into the SQL
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
						String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
						String user = "root";
						String password = "root";
						Connection con = DriverManager.getConnection(dbServer, user, password) ;
						Statement stmt = con.createStatement() ;
						String search = "Select * from movie where title = '" + title +"' and year_of_release = '" + year +"'";
						ResultSet data = stmt.executeQuery(search) ;
						
						while(data.next()) {
							
							// obtain data from the DB
							// recording on the TitleD array
							
							TitleD[0]=data.getString("title");
							TitleD[1]=data.getString("year_of_release");
							TitleD[2]=data.getString("genre");
							TitleD[3]=data.getString("director");
							TitleD[4]=data.getString("set");
							
							System.out.println("Title information as Follow");
							System.out.println("Movie Name * Year of release * Genre * Director * Set");
							
							//print out the data from the title selected by a user
							for(int i = 0; i<5; i++) {
								
								System.out.println(TitleD[1]);
							}
						}
					}catch(Exception e) {System.out.println(e);}
					}
					
				
				public void SearchMusic() {
					//scanner to record the input from the user
					
					try(Scanner input = new Scanner(System.in)){
						System.out.println("********** Search Music Title ***********");
						System.out.println("Music Title:");
						title = input.next();
						
						System.out.println("Band's Name: ");
						band = input.next();
						
					}
					
					try {
					
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
						String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
						String user = "root";
						String password = "root";
						Connection con = DriverManager.getConnection(dbServer, user, password) ;
						Statement stmt = con.createStatement() ;
						String search = "Select * from music where title = '" + title +"' and band = '" + band +"'";
						ResultSet data = stmt.executeQuery(search) ;
					
					while(data.next()) {
						
						// recording on TitleD array [Title date]
						TitleD[0]=data.getString("set");
						TitleD[1]=data.getString("title");
						TitleD[2]=data.getString("band");
						TitleD[3]=data.getString("year_of_release");
						
						System.out.println("Title information as Follow");
						System.out.println("Set * Music Name * Band/Singer * Year of Release");
						
						//print out the data from the title selected by a user
						
						System.out.println(TitleD[0]);
						System.out.println(TitleD[1]);
						System.out.println(TitleD[2]);
						System.out.println(TitleD[3]);
					
					}
					
						
				} catch(Exception e) {
					System.out.print(e);}
					
				}
				
				public void SearchBoxSet() {
					
					//Scanner to record the input from the user
					
					try(Scanner input = new Scanner(System.in)){
						System.out.println("******* Search Boxset Title **********");
						System.out.println("Boxset Title: ");
						title = input.next();
						
						System.out.println("Year of release: ");
						year = input.next();
					}
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
						String dbServer = "jdbc:mysql://localhost:3306/ultrauv";
						String user = "root";
						String password = "root";
						Connection con = DriverManager.getConnection(dbServer, user, password) ;
						Statement stmt = con.createStatement() ;
						String search = "Select * from boxset where title = '" + title +"' and year_of_release = '" + year +"'";
						ResultSet data = stmt.executeQuery(search) ;
					
						while(data.next()) {
						
						// obtain data from the DB
						// record on TitleD Array [Title Date]
						
						System.out.println("Title informarion as Follow");
						System.out.println("Boxset Name * Year Of Release");
						TitleD[0]=data.getString("title");
						TitleD[1]=data.getString("year_of_release");
						
						//print out the data from the title selected by a user
						System.out.println(TitleD[0]);
						System.out.println(TitleD[1]);
						}
			
					}catch(Exception e) {System.out.print(e);}
					}
				}


