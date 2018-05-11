package creditCardApp;

import java.util.*;

public class InputCheck{
	
	Scanner sc;
	
	public InputCheck(Scanner sc) {
		this.sc = sc;
	}
	
	//Ensures a positive floating number from a user
	public float positiveFloat() {
		float number = 0;
		char back = '0';
		boolean valid = false;
		while(!valid){
	        try {
	             number = sc.nextFloat();

	        } catch (InputMismatchException e){
	            back=singleChar(); //absorb incorrect value from command line
	            if (back == 'b' || back == 'B')
	            {
	            	System.out.println("You have returned to main menu");
	            	return -1;
	            }
	            else System.out.println("Please enter a valid value.");
	            continue;
	        }
	        if(number <= 0 )
	        {
	        	System.out.println("Please enter a valid value.");
	        }
	        else valid = true;
	    }
		return number;
	}
	
	//Ensures a positive integer from a user
	public int positiveInt() {
		int number = 0;
		char back = '0';
		boolean valid = false;
		while(!valid){
	        try {
	             number = sc.nextInt();

	        } catch (InputMismatchException e){
	        	
	            back = singleChar(); //check if user wants to return to menu
	            if (back == 'b' || back == 'B')
	            {
	            	System.out.println("You have returned to main menu");
	            	return -1;
	            }
	            else System.out.println("Please enter a valid value.");
	            continue;
	        }
	        if(number < 1 || number >30) //Only calculating a 30 day period
	        {
	        	System.out.println("Please enter a valid value up to 30.");
	        }
	        else valid = true;
	    }
		return number;
	}
	
	//Ensures a single character has been passed
	public char singleChar() {
		String temp;
		while(true)
		{
			temp=sc.next();
			if(temp.length() != 1)
			{
				System.out.println("Please enter a valid value.");
			}
			else return temp.toLowerCase().charAt(0);
			
		}
	}
}
