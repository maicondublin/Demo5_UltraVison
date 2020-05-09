/**
 * 
 */
package home;

import java.util.Scanner;

import media.MediaTitle;
import media.RentalTitle;
import media.ReturnTitle;
import media.SearchTitle;
import plan.MainCustomer;
import plan.SearchCustomer;
import plan.UpdateCustomer;

/**
 * @author maiconalmeida
 *
 */
public class Main {
	
	
	public Main() {
		Main();
	}
	
	public void Main() {
		
		int menu = 0;
		//menu for a scanner
	int menu1 = 0;
	
	Scanner input = new Scanner (System.in);
	
	
	//display menu option for a user
	do {
		
		System.out.println("********** Ultra Vision ***********");
		System.out.println("***********************************");
		System.out.println("***********************************");
		System.out.println("(1) - Search Title ");
		System.out.println("(2) - Search Customer ");
		System.out.println("(3) - Add New Title");
		System.out.println("(4) - Add New Customer");
		System.out.println("(5) - Update Customer");
		System.out.println("(6) - Rental Title");
		System.out.println("(7) - Return Tile");
	//	System.out.println("(1) - Search Title ");
		System.out.println("***********************************");
		System.out.println("Please, select one option from the menu");
		System.out.println("***********************************");
		
		menu1 = input.nextInt();
		
		//if a user has selected one option.
		//if stmt its actived.
		if(menu1 == (1)) {
			
			//look for search title class
			SearchTitle sear = new SearchTitle();
			sear.SearchTitle();
			
		}
		//look to the search customer class
		if(menu1 == (2)) {
			
			SearchCustomer sear = new SearchCustomer();
			sear.SearchCustomer();
		}
		//look to man title class
		if(menu1 == (3)) {
		MediaTitle addTitle = new MediaTitle();
		addTitle.MediaTitle();
		
	}
		//look to mainCustomer
		if(menu1 == (4)) {
	   //call the class
			MainCustomer addCustomer = new MainCustomer();
			addCustomer.MainCustomer(); //call method
		}
		if(menu1 == (5)) {
			
			//look to update customer
			UpdateCustomer upcust = new UpdateCustomer();
			upcust.UpdateCustomer();
		}
		if(menu1 == (6)) {

		//look to Rental titles 
		RentalTitle rent = new RentalTitle();
		rent.RentalTitle();
}
	if(menu1 == (7)) {
		//look to return title
		ReturnTitle rtitle = new ReturnTitle();
		rtitle.ReturnTitle();
		
	} else {
		
		//message shall pop up to a user and return them to the main
		System.out.println("*****************************");
		System.out.println("Please, select one option from the menu.");
		//System.out.println("");
		
		//going back to Main
			Main();
		}
			
		} while(menu == 0);}
	
			
		
	public static void main(String[] args) {
		new Main();
	}

}
