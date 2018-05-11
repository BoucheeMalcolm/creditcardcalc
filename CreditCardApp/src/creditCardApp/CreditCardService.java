package creditCardApp;

public class CreditCardService {
	
	private CreditCard card; 
	private float newBalance, newInterest;
	
	public CreditCardService (CreditCard newCard) {
		card=newCard;
	}
	
	//Pay credit card bill
	void payBalance (float payment) {
		//if payment is an overpay 
		if (payment > card.getBalance())
		{
			card.setBalance(0);
			System.out.println("Payment amount exceeds balance. Excess will soon be refunded");
			
		}
		else {
			newBalance=card.getBalance() - payment;
			card.setBalance(newBalance);
			System.out.printf("You have selected to pay back $%.2f\n", payment);
		}
		
	}
	
	//Make a purchase
	void swipeCard (float charge) {
		//Credit limit has been reached
		if((card.getBalance() + charge) > card.getLimit())
		{
			System.out.println("Card has been declined");
		}
		else {
			newBalance=card.getBalance() + charge;
			card.setBalance(newBalance);
			System.out.printf("You've spent $%.2f\n", charge);
		}
	}
	
	//Add daily interest
	void calcInterest(float apr, float balance, float interest) {
		newInterest = interest + ((apr/365)*balance); //daily interest = (apr/365 days in year) * current balance
		card.setInterest(newInterest);
	}
	
	//Display unpaid balance 
	void currentBalance(){
		//if statements based on number of days since opening
		if(card.getNumdays() == 30)
		{
			
			newBalance=card.getBalance() + card.getInterest();
			card.setBalance(newBalance);
			System.out.println("You have reached the end of the period.");
		}
		System.out.printf("You currently owe $%.2f.\n", card.getBalance());
	}
	
	//Jump ahead if there's no credit activity between days
	void advanceDay(int daysSince) {
		int currday = card.getNumdays(); //current day in period
		if(daysSince < currday)
		{
			System.out.println("That day has already passed.");
			return;
		}
		int difference = daysSince-currday;
		for(int i=0; i< difference; i++) //daysPassed since last activity;
		{
			
			currday++;
			calcInterest(card.getApr(), card.getBalance(), card.getInterest());
		}
		System.out.println("You are on day " + currday + 
				" since you opened your credit card.");
		card.setNumdays(currday);
	}
	
	
	
	
	
}
