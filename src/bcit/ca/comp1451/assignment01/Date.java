/**
 * 
 */
package bcit.ca.comp1451.assignment01;

import java.util.HashMap;

/**
 * @author emre
 *version 1.0
 */
public class Date {
	
	private static final int FIRST_DAY = 1;
	private static final int LAST_DAY = 31;
	private static final int FIRST_MONTH = 1;
	private static final int LAST_MONTH = 12;
	private static final int FIRST_YEAR = 1900;
	private static final int CURRENT_YEAR = 2019;
	
	private int day;
	private int month;
	private int year;
	private HashMap<Integer, String> monthNames;
	
	/**
	 * @param day must be btw 1 and 31
	 * @param month must be btw 1 and 12
	 * @param year must be btw 1900 and 2019
	 */
	public Date(int day, int month, int year) {
		monthNames = new HashMap<Integer, String> ();
		populateHashMap();
		setDay(day);
		setMonth(month);
		setYear(year);
		
	}
	//end constructor
	/**
	 * @return the day of the date
	 */
	public int getDay() {
		return day;
	}
	// end method
	/**
	 * @param day must be btw 1 and 31, 
	 * 			if it is not, the day will set to 1
	 */
	public void setDay(int day) {
		if(day >= FIRST_DAY && day <= LAST_DAY)
		{
			this.day = day;
		}else
		{
			this.day = FIRST_DAY;
		}
	}
	//end method
	/**
	 * @return the month of the date
	 */
	public int getMonth() {
		return month;
	}
	//end method
	/**
	 * @param month must be btw 1 and 12
	 * 			if it is not, the month  will be set to 1
	 */
	public void setMonth(int month) {
		if(month >= FIRST_MONTH && month <= LAST_MONTH)
		{
			this.month = month;
		}else
		{
			this.month = FIRST_MONTH;
		}
	}
	// end method
	/**
	 * @return the year of the date
	 */
	public int getYear() {
		return year;
	}
	// end method
	/**
	 * @param year must be btw 1900 and 2019
	 * 			if it is not, the year will be set to 1900
	 */
	public void setYear(int year) {
		if(year >= FIRST_YEAR && year <= CURRENT_YEAR )
		{
			this.year = year;
		}else
		{
			this.year = FIRST_YEAR;
		}
	}
	// end method
	/**
	 * @return monthNames hash map 
	 * 		populate the hash map with the month names and numbers.
	 * 
	 */
	private HashMap<Integer, String> populateHashMap()
	{
		monthNames.put(1, "January");
		monthNames.put(2, "February");
		monthNames.put(3, "March");
		monthNames.put(4, "April");
		monthNames.put(5, "May");
		monthNames.put(6, "June");
		monthNames.put(7, "July");
		monthNames.put(8, "August");
		monthNames.put(9, "September");
		monthNames.put(10, "October");
		monthNames.put(11, "November");
		monthNames.put(12, "December");
		
		return monthNames;
	}
	// end method
	public String toString()
	{
		return dateFormat();
	}
	// end method
	/**
	 * 
	 * @return date as a String in the following format dd/month name /yyyy
	 * 		If the day value consisted of one digit,
	 *  	it will be proceeded by 0, for example 
	 *  	day 3 of month 3 of year 2013 will be displayed as: 03/March/2013, 
	 *  	otherwise it will be displayed as follows:
	 *     	day 11 of month 3 of year 2013 will be displayed 11/March/2013
	 *  
	 */
	public String dateFormat()
	{
		String date = String.format("%02d", day);
		date = date + "/" + monthNames.getOrDefault(month, "january") + "/" + year;
		return date;
	}
	// end method
}//end class
