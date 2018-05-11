/* Coder Name: Malcolm Bouchee
 * 
 * 
 * This version of the application contains thorough error checking and gives the user 
 * freedom to run their own single credit card simulation
 */
package creditCardApp;

import java.util.*;

public class CreditCardApp {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //for menu selection
		InputCheck ic= new InputCheck(sc); //checks for valid input;
		float percentage, limit, payment, price;
		int days = 0;
		//initiate application and card
		
		System.out.println("Welcome to the Credit Card simulator");
		System.out.println("Please enter an APR for the new credit card( .55 is 55%)");
		percentage=ic.positiveFloat();
		System.out.println("Please enter a 30-day credit limit");
		limit=ic.positiveFloat();
		CreditCard newCard = new CreditCard(percentage, limit);
		CreditCardService cardService = new CreditCardService(newCard);
		
		//run simulator
		
		char selection;
		do {
					cardService.currentBalance();
					if(days == 30) //end of billing period has been reached
					{
						System.out.println("Have a nice day. Good bye.");
						return;
					}
					System.out.printf("\nWhat would you like to do with your account?\n");
					System.out.println("Select p or P to pay credit balance");
					System.out.println("Select c or C to charge your card");
					System.out.println("Select d or D to move up in billing period");
					System.out.println("Select q or Q to end simulation");
					selection = ic.singleChar();
					sc.nextLine();
					
					switch(selection){
						case 'p':
						{
							System.out.println("If you would like to return to main menu, select "
									+ "b or B");
							System.out.println("How much would you like to pay?");
							payment = ic.positiveFloat();
							if(payment == -1)
								break;
							else {
								cardService.payBalance(payment);
								break;
								}
							
						}
						
						case 'c':
						{
							System.out.println("If you would like to return to main menu, select "
									+ "b or B");
							System.out.println("How much is your purchase?");
							price = ic.positiveFloat();
							if(price == -1)
								break;
							else 
								{
								cardService.swipeCard(price);
								break;
								}
							
						}
						case 'd':
						{
							System.out.println("If you would like to return to main menu, select "
									+ "b or B");
							System.out.println("Which day in the period would you like to jump"
									+ " ahead to?");
							days = ic.positiveInt();
							if (days == -1)
								break;
							else {
								cardService.advanceDay(days);
								break;
							}
						}
						case 'q':
						{
							System.out.println("Have a nice day. Good bye.");
							break;
						}
						default:
						{
							System.out.println("Please enter a valid value.");
						}
							
					}
		}while(selection !='q' && selection != 'Q');
		sc.close();
		
	}
	
}
