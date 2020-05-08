/**
 * 
 */
package uvMedia;

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
		int menu 1 = 0;
		
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
			
			String InsertClient = "INSERT INTO movie"
					+ "(title, year_of_release, genre, director, set)"// from DB
					+ "VALUES ('"+ "" +title+"" +"',''+year +"','"+genre +"','"+ director +"', '"+ set +"')"; // from a class
					//Strings that hold a query that insert data into DB
			
		
			if (Option ==(1)) {
				//Execute the query
				stmt.executeUpdate(InsertClient);
				Movie video = new Movie (title, year, genre, director, set); // call the variable from the movie class
				
				System.out.println(video);
				
			}else {System.out.println("Invalid connect to the database, please");}
			
		}catch (Exception e) { System.out.print(e);}
		
		
				
			}
		}
	}

}
