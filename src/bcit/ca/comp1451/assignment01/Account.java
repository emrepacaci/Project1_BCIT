/**
 * 
 */
package bcit.ca.comp1451.assignment01;

import java.util.ArrayList;

/**
 * @author emre
 *
 */
public class Account {
	
	private static final int ZERO = 0;
	
	private Customer customer;
	private String accountNumber;
	private Date dateAccountCreated;
	private double balance;
	private ArrayList<TransactionRecord> transactionRecord;
	
	private static int NEXT_ACCOUNT_NUMBER = 34101000;
	
	/**
	 * @param customer of the account, it cannot be null
	 * @param dateAccountCreated of the account, it cannot be null
	 * @param balance of the account it cannot be negative
	 */
	public Account(Customer customer, Date dateAccountCreated, double balance) {
		transactionRecord = new  ArrayList<TransactionRecord>();
		
		setCustomer(customer);
		setDateAccountCreated(dateAccountCreated);
		setBalance(balance);
		accountNumber = createNewAccountNumber();
	}
	//end constructor
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	//end method
	/**
	 * @param customer, it cannot be null and it set to the customer field
	 */
	public void setCustomer(Customer customer) {
		if(customer != null)
		{
			this.customer = customer;
		}else
		{
			throw new IllegalArgumentException("it cannot be null");
		}
	}
	//end method
	/**
	 * @return the dateAccountCreated
	 */
	public Date getDateAccountCreated() {
		return dateAccountCreated;
	}
	//end method
	/**
	 * @param dateAccountCreated, it cannot be null and it set to the dateAccountCreated field
	 */
	public void setDateAccountCreated(Date dateAccountCreated) {
		if(dateAccountCreated != null)
		{
			this.dateAccountCreated = dateAccountCreated;
		}else
		{
			throw new IllegalArgumentException("it cannot be null");
		}
		
	}
	//end method
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance, it cannot be zero, and it set to the balance field
	 */
	public void setBalance(double balance) {
		if(balance >= ZERO)
		{
			this.balance = balance;
		}else
		{
			throw new IllegalArgumentException("it cannot be negatif");
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
	 * 
	 * @return a String, incrementing 34101000 static variable for each account
	 * 					each account should have an unique account number
	 */
	private String createNewAccountNumber() 
	{
		NEXT_ACCOUNT_NUMBER++;
		return Integer.toString(NEXT_ACCOUNT_NUMBER);
	}
	//end method
	/**
	 * 
	 * @param amount, if it is positive and less than or equal to the balance
	 * 				 it will be subtracted from the balance and true will be return
	 * @return false  If the parameter was negative or the result of the subtraction will be negative, 
	 * 			
	 */				
	public boolean withdraw(double amount) {
		if(balance >= amount && amount > ZERO)
		{
			balance -= amount;
			return true;
			
		}else
		{
			System.out.println("the amount was invalid");
			return false;
		}
	}
	//end method
	/**
	 * 
	 * @param amount, if it is positive it will add it to the balance,and return true
	 * @return false, if the amount is negative
	 */
	
	 public boolean deposit(double amount) {
		 if(amount > ZERO)
		 {
			 balance += amount;
			 return true;
		 }else
		 {
			 System.out.println("the amount was invalid");
			 return false;
		 }
	 }
	//end method
	 /**
	  * iterates through the TransactionRecord collection
	  *  and displays its information in an organized manner
	  * 
	  */
	 public void displayTransactionDetails()
	 {
		 for (TransactionRecord tr : transactionRecord)
		 {
			 System.out.println(tr);
		 }
	 }
	//end method
	 /**
	  *  add a Transaction object to the arrayList
	  *   
	  * @param amount of a TransactionRecord object
	  * @param dateIssued of a TransactionRecord object
	  * @param transactionType of a TransactionRecord object
	  * @return true
	  */
	 public boolean addTransaction(
			 double amount, 
			 Date dateIssued, 
			 int transactionType)
	 {
		 TransactionRecord t1 = new TransactionRecord(amount, dateIssued, accountNumber,transactionType );
		 transactionRecord.add(t1);
		 return true;
	 }
	//end method
	 public void displayDetails()
	 {
		 System.out.println(" The customer full name \n " + customer.getName());
		 System.out.println(" The account number \n " + accountNumber);
		 System.out.println(" The balance\n " + balance);
		 System.out.println(" The date the account was created " + dateAccountCreated.dateFormat());
	 }//end method
}// end class
