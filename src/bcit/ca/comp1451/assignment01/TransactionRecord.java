/**
 * 
 */
package bcit.ca.comp1451.assignment01;

/**
 * @author emre
 *
 */
public class TransactionRecord {
	
	private static final int ZERO = 0;
	private static final int WITHDRAW = 1;
	private static final int DEPOSIT = 2;
	
	private double amount;
	private Date dateIssued;
	private String accountNumber; 
	private int transactionType;  
	/**
	 * @param amount of an account , it cannot be zero
	 * @param dateIssued of a account, it cannot be null
	 * @param accountNumber of a account, it cannot be null or empty
	 */
	public TransactionRecord(double amount, Date dateIssued, String accountNumber, int transactionType ) {
		
		setAmount(amount);
		setDateIssued(dateIssued);
		setAccountNumber(accountNumber);
		setTransactionType(transactionType);
	}
	//end constructor
	/**
	 * @return the amount of an account
	 */
	public double getAmount() {
		return amount;
	}
	//end method
	/**
	 * @param amount, it cannot be negative and it set to the amount field
	 */
	public void setAmount(double amount) {
		if(amount >= ZERO)
		{
			this.amount = amount;
		}else
		{
			throw new IllegalArgumentException("it cannot be negatif");
		}
		
	}
	//end method
	/**
	 * @return the dateIssued 
	 */
	public Date getDateIssued() {
		return dateIssued;
	}
	//end method
	/**
	 * @param dateIssued, it cannot be null and it set to the dateIssued field
	 */
	public void setDateIssued(Date dateIssued) {
		if(dateIssued != null)
		{
			this.dateIssued = dateIssued;
		}else 
		{
			throw new IllegalArgumentException("it cannot be null");
		}
	}
	//end method
	/**
	 * @return the accountNumber 
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	//end method
	/**
	 * @param accountNumber, it cannot be null or empty and it set to the accountNumber field
	 */
	public void setAccountNumber(String accountNumber) {
		if(accountNumber != null && accountNumber.length() > ZERO) 
		{
			this.accountNumber = accountNumber;
		}else
		{
			throw new IllegalArgumentException("it cannot be null and empty");
		}
	}
	//end method
	/**
	 * 
	 * @return transactionType of a account
	 */
	public int getTransactionType()
	{
		return transactionType;
	}
	//end method
	/**
	 * 
	 * @param option, it can be ONLY two values, withdraw or deposit
	 */
	public void setTransactionType(int option)
	{
		if(option == WITHDRAW)
		{
			transactionType = WITHDRAW;
		}else if(option == DEPOSIT)
		{
			transactionType = DEPOSIT;
		}else
		{
			throw new IllegalArgumentException("invalid transaction type ");
		}
	}
	//end method
	public String toString()
	{
		if(transactionType == WITHDRAW)
			return "account number : " +  accountNumber + "\nDate : " + dateIssued + 
				"\nAmount : " + amount + "\nTransaction type: " +  "withdraw"; 
		else
			return "account number : " +  accountNumber + "\nDate : " + dateIssued + 
				"\nAmount : " + amount + "\nTransaction type: " +  "deposit"; 
	}
	//end method
}// end class


