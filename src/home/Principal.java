/**
 * 
 */
package home;

import java.util.Scanner;

/**
 * @author maiconalmeida
 *
 */
public class Principal {
	
	
	
	public Principal() {
		
		Principal();
	}
	
	public void Principal() {
		
		int menu = 0;
		
		//menu for the scanner
		int menu1 = 0;
		
		Scanner input = new Scanner(System.in);
		
		//display a menu of options to a user(s)
		do {
			
			System.out.println("************ Ultra Vision Rental ************");
			System.out.println("*********************************************");
			System.out.println("(1) - Search Title ");
			System.out.println("(2) - Search Customer ");
			System.out.println("(3) - Add New Title ");
			System.out.println("(4) - Add New Customer ");
			System.out.println("(5) - Update Customoer  ");
			System.out.println("(6) - Rental a Title ");
			System.out.println("(7) - Return Title ");
		//	System.out.println("(8) - Logout  "); i think i dont need this line ?!?!?
			System.out.println("*********************************************");
			System.out.println(" Select one optin from the menu, please.");
			System.out.println("*********************************************");
			menu1 = input.nextInt();
			
			//if a user has selected one option.
			//a if stment forward to that class responsible to the command.
			if(menu1 == (1)) {
				//look for a search title class
				SearchTtile sear = new SearchTitle();
				sear.SearchTitle();
			}
			//look for a search customer class
			if(menu1 == (2)) {
				SearchCustomer sear = new SearchCustomer();
				sear.SearchCustomer();
			}
			//look to media title class
			if(menu1 == (3)) {
				MediaTitle addTitle = new MediaTitle();
				addTitle.MediaTitle();
			}
			//look to main customer
			if(menu1 == (4)) {
				//call a class
				MainCustomer addCustomer = new MainCustomer();
				addCustomer.MainCustomer();//method is called 
			}
			if(menu1 == (5)) {
				//look to update a customer
				UpDatCustomer upcust = new UpDateCustomer();
				upcust.UpDateCustomer();
			}
			//look to a rental title
			if(menu1 == (6)) {
				
				RentalTitle rent = new RentalTitle();
				rent.RentalTitle();
				
			}
			if(menu1 ==(7)) {
				//look to return a title
				ReturnTitle rtitle = new ReturnTitle();
				
			} else {
				//shall pop a message to the user 
			//return to the principal menu
				System.out.println("*******************************");
				System.out.println("Select one option from the menu, please?");
				System.out.println("*****************************************");
				System.out.println("**************************************");
				
				//go back to a principal main
				Principal();
			}
			
			
		} while(menu == 0);}
	

	public static void main(String[] args) {
		
		new Principal();
	
		
	}

}
