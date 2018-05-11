package creditCardApp;

public class CreditCard {
	
	//Open up credit card
	public CreditCard(float apr, float limit)
	{
		this.apr = apr;
		this.limit = limit;
		interest = 0;
		balance = 0;
		numdays = 0;
		
		System.out.printf("Congrats! You've opened a credit card with %.2f APR and a "
				+ "$%.2f limit\n", apr*100, limit);
		
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public float getApr() {
		return apr;
	}
	public void setApr(float apr) {
		this.apr = apr;
	}
	public float getLimit() {
		return limit;
	}
	public void setLimit(float limit) {
		this.limit = limit;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getNumdays() {
		return numdays;
	}
	public void setNumdays(int numdays) {
		this.numdays = numdays;
	}
	
	private float apr;
	private float limit;
	private float balance;
	private int numdays;
	private float interest;
	
	
}
