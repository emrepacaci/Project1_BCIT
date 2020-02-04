/**
 * 
 */
package bcit.ca.comp1451.assignment01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author emre
 *
 */
public class Bank {

	private static final int THREE = 3;
	private static final int ONE = 1;
	private static final int ZERO =0;
	
	private String bankName; 
	private HashMap<String, Account> myMap;
	/**
	 * @param bankName of the bank, it cannot be null or empty
	 */
	public Bank(String bankName) {
		super();
		myMap = new  HashMap<String, Account>();
		setBankName(bankName);
	}
	//end constructor
	/**
	 * @return the bankName of the bank
	 */
	public String getBankName() {
		return bankName;
	}
	//end method
	/**
	 * @param bankName, it cannot be null or empty, and it set to the bankName field
	 */
	public void setBankName(String bankName) {
		if(bankName != null && bankName.length() > ZERO)
		{
			this.bankName = bankName;
		}else 
		{
			throw new IllegalArgumentException("it cannot be null or empty");
		}
		
	}
	//end method
	/**
	 * 
	 * @param toadd of an account object,and adds it to the hashMap only if it was not null 
	 */
	
	public void addAccount(Account toadd) 
	{
		if(toadd != null)
		{
			String id = toadd.getAccountNumber();
			if(!myMap.containsKey(id))
			{
				myMap.put(id,toadd);
			}else
			{
				System.out.println("id already exists it the hash map");
			}
		}else
		{
			System.out.println("it cannot be null");
		}
	}
	//end method
	/**
	 *@param accountNumber, If the number was not null and it was found in the hashMap,
	 *		 the method will display the details of the account
	 *@return the account object associated with the number from the collection. 
	 * If the account number was not found in the collection, display the message
	 */
	 public Account getAccount(String accountNumber) 
	 {
		 if(accountNumber != null)
		 {
			if(myMap.containsKey(accountNumber))
			{
				Account account1 = myMap.get(accountNumber);
				account1.displayDetails();
				return account1;
			}else
			{
				System.out.println("account number was not found ");
				return null;
			}
			
		 }else
		 {
			 throw new IllegalArgumentException("accountNumber cannot be null");
		 }
	 }
	 //end method
	 /**
	  * 
	  * @param name of the customer, displays the account details including all transaction record details of that customer, 
	  * 			 display an error message if the customer was not found in the collection.
	  */
	 public void showTransactions(String name)
	 {
		 int x = 1;
		 Set<Map.Entry<String, Account>> mySet = myMap.entrySet();
			for(Map.Entry<String, Account> entry1: mySet)
			{
				if(entry1.getValue().getCustomer().getName().equalsIgnoreCase(name))
				{
					entry1.getValue().displayDetails();
					entry1.getValue().displayTransactionDetails();
					x = 0;
				}
			}
			if(x == 1) {
			System.out.println("there is no customer with this name");
			}
	 }
	 //end method
	 /**
	  * display all the bank account numbers in the collection. 
	  * 
	  */
	 public void displayAccountNumbers() 
	 {
		 Set<String>mySet = myMap.keySet();
		 for(String acNumber : mySet)
		 {
			 System.out.println(acNumber);
		 }
	 }
	 //end method
	 /**
	  * 
	  * making transactions,
	  * 
	  * creating a loop to ask the user for the account number and gets the account from hash map
	  * If the account was not found a message will be displayed. And the loop will end
	  * will ask for the transaction type and get the choice number from the user.
	  * If the user chooses number 3 then the method will ask for the user name 
	  * 	and invoke method showTransactions () using the given name
	  * After the transaction is done the user will be asked 
	  * if he/she wants to make another transaction
	  *  if the answer was yes the same process will be repeated, 
	  *  if no then the loop will end.
	  * 
	  */
	 public void makeTransaction()
	 {
		 Scanner input = new Scanner(System.in);
		 Account accFound = null;
		 String answer = "";
		 while(!answer.equalsIgnoreCase("no"))
		 {
			 System.out.println("enter account number : ");
			 String accNumber = input.nextLine();
			 accFound = getAccount(accNumber);
		 if(accFound == null)
			 return;
		 System.out.println("1.	Withdraw \n" + 
			 		"2.	Deposit \n" + 
			 		"3.	Show Transactions ");
		 System.out.println("Choose one of above options: ");
			 int option = input.nextInt();
			 input.nextLine();
			
			 if(option == THREE)
			 {
				 System.out.println("Enter Name: ");
					 String username = input.nextLine();
					 showTransactions(username);
			 }
			 else 
			 {
				 System.out.println("Enter Amount");
				 int amount = ZERO;
					amount = input.nextInt();
				 boolean result =false;
				 if(option == ONE )
				 {
					 result = accFound.withdraw(amount); 
				 }else
				 {
					result = accFound.deposit(amount);
				 } 
				 if(result)
				 {
					 System.out.println("Enter valid a date with following format: 31/12/1990");
					
						 String dateString = input.next();
						 input.nextLine();
						 String[] dateArray = dateString.split("/");
						 Date date = new Date(
								 Integer.valueOf(dateArray[0]),
								 Integer.valueOf(dateArray[1]),
								 Integer.valueOf(dateArray[2]));
						 if(!accFound.addTransaction(amount, date, option))
							 return;	 
				 } 
			 System.out.println("do you want to make another transaction? yes/no ");
				 answer = input.nextLine();
			 }
		 } 
	 }//end method
}//end class
