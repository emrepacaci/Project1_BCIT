package bcit.ca.comp1451.assignment01;

public class Driver {

	public static void main(String[] args)
	{
		Date d1 = new Date(13, 3, 1992);
		Customer c1 = new Customer("emre pacaci", "vancouver", d1);
		Date dateissued1 = new Date(10, 5, 2018);
		Account a1 = new Account(c1, dateissued1, 200.90);
		
		Date d2 = new Date(7, 8, 1994);
		Customer c2 = new Customer("Amy stefan", "vancouver", d2);
		Date dateissued2 = new Date(8, 7, 2016);
		Account a2 = new Account(c2, dateissued2, 123.34);
		
		Date d3 = new Date(4, 5, 1990);
		Customer c3 = new Customer("Emily Car", "Montreal", d3);
		Date dateissued3 = new Date(3,4, 2013);
		Account a3 = new Account(c3, dateissued3, 304.54);
		
		
		Date d4 = new Date(23, 6, 1985);
		Customer c4 = new Customer("Justin Kara", "Toronto", d4);
		Date dateissued4 = new Date(9, 7, 2018);
		Account a4 = new Account(c4, dateissued4, 405.67);
		
		
		Bank b1 = new Bank("RBC");
		b1.addAccount(a1);
		b1.addAccount(a2);
		b1.addAccount(a3);
		b1.addAccount(a4);
		b1.displayAccountNumbers();
		b1.makeTransaction();
	}
}
