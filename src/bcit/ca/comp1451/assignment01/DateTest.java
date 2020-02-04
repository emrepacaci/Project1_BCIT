package bcit.ca.comp1451.assignment01;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
	private Date date;

	@Before
	public void setUp() throws Exception {
		date = new Date(5, 4, 2018);
	}

	@After
	public void tearDown() throws Exception {
		date = null;
	}
	
	@Test
	public void testNegativeDay()
	{
		date.setDay(0);
		assertEquals(1, date.getDay());
	}
	@Test
	public void testPositiveDay()
	{
		date.setDay(4);
		assertEquals(4, date.getDay());
	}
	
	@Test
	public void testNegativeMonth()
	{
		date.setMonth(0);
		assertEquals(1, date.getMonth());
	}
	@Test
	public void testPositiveMonth()
	{
		date.setMonth(5);
		assertEquals(5, date.getMonth());
	}
	@Test
	public void testNegativeYear()
	{
		date.setYear(1889);
		assertEquals(1900, date.getYear());
	}
	@Test
	public void testPositiveYear()
	{
		date.setYear(1989);
		assertEquals(1989, date.getYear());
	}
	
	

}
