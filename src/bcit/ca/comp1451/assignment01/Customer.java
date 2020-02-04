/**
 * 
 */
package bcit.ca.comp1451.assignment01;

/**
 * @author emre
 *
 */
public class Customer {
	private String name;
	private String address;
	private Date dateOfBirth;
	/**
	 * @param name of the customer,it cannot be null or empty 
	 * @param address of the customer, it cannot be null or empty
	 * @param dateOfBirth of the customer, it cannot be null
	 */
	public Customer(String name, String address, Date dateOfBirth) {
		setName(name);
		setAddress(address);
		setDateOfBirth(dateOfBirth);
	}
	//end constructor
	/**
	 * @return the name of the customer
	 */
	public String getName() {
		return name;
	}
	//end method
	/**
	 * @param name, it cannot be null or empty, and it set to the name of customer
	 */
	public void setName(String name) {
		
		if(name != null && !name.equals(""))
		{
			this.name = name;
		}else
		{
			throw new IllegalArgumentException("name cannot be null and empty");
		}
		
	}
	//end method
	/**
	 * @return the address of the customer
	 */
	public String getAddress() {
		return address;
	}
	//end method
	/**
	 * @param address, it cannot be null or empty and it set to the address of customer
	 */
	public void setAddress(String address) {
		if(address != null && !address.equals(" "))
		{
			this.address = address;
		}else
		{
			throw new IllegalArgumentException("address cannot be null and empty");
		}
		
	}
	//end method
	/**
	 * @return the dateOfBirth of the customer
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	//end method
	/**
	 * @param dateOfBirth, it cannot be null or empty and it set to the dateOfBirth of the customer
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		if(dateOfBirth  != null)
		{
			this.dateOfBirth = dateOfBirth;
		}else
		{
			throw new IllegalArgumentException("dateOfBirth cannot be null and empty");
		}
	
	}
	//end method
	/**
	 * @return format the name properly as a String 
	 * 				the first letter should be upper case
	 * 				and the rest of the name should be lower case
	 * 				regardless of how it was provided
	 */
	public String formatName(String word) 
	{
		String firstLetter = word.substring(0, 1).toUpperCase();
		String restOfTheName = word.substring(1).toLowerCase();
		
		return firstLetter + restOfTheName;
	}
	//end method
	public void displayDetails()
	{
		System.out.print("Customer name: " + formatName(name) + " Adress: " + address + " Birth date :" + dateOfBirth);
	}
	//end method
}// end class
