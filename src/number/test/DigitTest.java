package number.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import number.Digit;
import number.exception.DigitException;

import org.junit.Test;

public class DigitTest {
	
	/**
	 * Ensure trash values can't become digits through the constructor.
	 */
	@Test
	public void test_default_constructor(){
		Digit digit = new Digit(); //This should be 0
		assertTrue(digit.isZero());
	}
	
	/**
	 * Ensure trash values can't become digits through the constructor.
	 */
	@Test
	public void test_constructor_a(){
		try {
			Digit digit = new Digit('a');
			fail("Digit a is not a valid digit.");
		} catch (DigitException e) {
			// It should throw an exception.
		}
	}
	
	/**
	 * Ensure trash values can't become digits through the constructor.
	 */
	@Test
	public void test_constructor_A(){
		try {
			Digit digit = new Digit('A');
			fail("Digit A is not a valid digit.");
		} catch (DigitException e) {
			// It should throw an exception.
		}
	}
	
	/**
	 * Ensure trash values can't become digits through the constructor.
	 */
	@Test
	public void test_constructor_dash(){
		try {
			Digit digit = new Digit('-');
			fail("Digit - is not a valid digit.");
		} catch (DigitException e) {
			// It should throw an exception.
		}
	}
	
	/**
	 * Ensure trash values can't become digits through the constructor.
	 */
	@Test
	public void test_constructor_exclamation(){
		try {
			Digit digit = new Digit('!');
			fail("Digit ! is not a valid digit.");
		} catch (DigitException e) {
			// It should throw an exception.
		}
	}
	
	/**
	 * Ensure correct digits are parsed correctly
	 */
	@Test
	public void test_constructor_0(){
		try {
			Digit digit = new Digit('0');
			// Should not throw an exception
			
		} catch (DigitException e) {
			fail("Digit 0 is a valid digit.");
		}
	}
	
	/**
	 * Ensure correct digits are parsed correctly
	 */
	@Test
	public void test_constructor_1(){
		try {
			Digit digit = new Digit('1');
			// Should not throw an exception
			
		} catch (DigitException e) {
			fail("Digit 1 is a valid digit.");
		}
	}
	
	/**
	 * Ensure correct digits are parsed correctly
	 */
	@Test
	public void test_constructor_9(){
		try {
			Digit digit = new Digit('9');
			// Should not throw an exception
			
		} catch (DigitException e) {
			fail("Digit 9 is a valid digit.");
		}
	}
	
	/**
	 * Ensure the digit is set correctly before an after the call to set digit.
	 */
	@Test
	public void test_setDigit_1_from_0(){
		
		Digit digit = null;
		
		try {
			// Create digit and make sure it is set correctly
			digit = new Digit('0');
			assertTrue(digit.getDigit() == '0');
		} catch (DigitException e) {
			fail("Problem creating digit");
		}
		
		try{
			digit.setDigit('1');
			assertTrue(digit.getDigit() == '1');
		} catch (DigitException e) {
			fail("Problem setting valid digit.");
		}
		
	}
	
	/**
	 * Ensure the digit is set correctly before an after the call to set digit.
	 */
	@Test
	public void test_setDigit_9_from_8(){
		
		Digit digit = null;
		
		try {
			// Create digit and make sure it is set correctly
			digit = new Digit('8');
			assertTrue(digit.getDigit() == '8');
		} catch (DigitException e) {
			fail("Problem creating digit");
		}
		
		try{
			digit.setDigit('9');
			assertTrue(digit.getDigit() == '9');
		} catch (DigitException e) {
			fail("Problem setting valid digit.");
		}
		
	}
	
	/**
	 * Ensure the digit is set correctly before an after the call to set digit.
	 */
	@Test
	public void test_setDigit_a_from_0(){
		
		Digit digit = null;
		
		try {
			// Create digit and make sure it is set correctly
			digit = new Digit('0');
			assertTrue(digit.getDigit() == '0');
		} catch (DigitException e) {
			fail("Problem creating digit");
		}
		
		try{
			digit.setDigit('a');
			fail("Exception wasn't thrown for invalid digit.");
		} catch (DigitException e) {
			// We expect an exception to arise here.
		}
		
	}
	
	/**
	 * Ensure the digit is set correctly before an after the call to set digit.
	 */
	@Test
	public void test_setDigit_dollar_from_0(){
		
		Digit digit = null;
		
		try {
			// Create digit and make sure it is set correctly
			digit = new Digit('0');
			assertTrue(digit.getDigit() == '0');
		} catch (DigitException e) {
			fail("Problem creating digit");
		}
		
		try{
			digit.setDigit('$');
			fail("Exception wasn't thrown for invalid digit.");
		} catch (DigitException e) {
			// We expect an exception to arise here.
		}
		
	}
	
	/**
	 * Test if isDigit works correctly in deciding if something is a digit or not
	 */
	@Test
	public void test_isDigit(){
		assertTrue(Digit.isDigit('0'));
		assertTrue(Digit.isDigit('1'));
		assertTrue(Digit.isDigit('9'));
		assertFalse(Digit.isDigit('a'));
		assertTrue(Digit.isDigit(1));
		assertTrue(Digit.isDigit(0));
		assertTrue(Digit.isDigit(9));
		assertFalse(Digit.isDigit(20));
		assertFalse(Digit.isDigit(-1));
		assertFalse(Digit.isDigit('&'));
		
	}
	
	
	
	/**
	 * Test if the valid digit 0 is even.
	 */
	@Test
	public void test_isEven_0(){
		try {
			assertTrue(new Digit('0').isEven());
		} catch (DigitException e) {
			fail("The digit 0 is a  digit.");
		}
	}
	
	/**
	 * Test if the valid digit 1 is even.
	 */
	@Test
	public void test_isEven_1(){
		try {
			assertFalse(new Digit('1').isEven());
		} catch (DigitException e) {
			fail("The digit 1 is a digit");
		}
	}
	
	/**
	 * Test if the valid digit 2 is even.
	 */
	@Test
	public void test_isEven_2(){
		try {
			assertTrue(new Digit('2').isEven());
		} catch (DigitException e) {
			fail("The digit 2 is a  digit.");
		}
	}
	
	/**
	 * Compare the digit 0 to 1. Should return a negative value since 0 < 1.
	 */
	@Test
	public void test_compareTo_0_1(){
		
		Digit first = null, second = null;
		
		try {
			// Set up the two digits
			first = new Digit('0');
			second = new Digit('1');
		} catch (DigitException e) {
			fail("The digits are valid.");
		}
		
		assertTrue(first.compareTo(second) < 0);
	}
	
	/**
	 * Compare the digit 1 to 0. Should return a negative value since 1 > 0.
	 */
	@Test
	public void test_compareTo_1_0(){
		
		Digit first = null, second = null;
		
		try {
			// Set up the two digits
			first = new Digit('1');
			second = new Digit('0');
		} catch (DigitException e) {
			fail("The digits are valid.");
		}
		
		assertTrue(first.compareTo(second) > 0);
	}
	
	/**
	 * Compare the digit 0 to 0. Should return a negative value since 0 == 0.
	 */
	@Test
	public void test_compareTo_0_0(){
		
		Digit first = null, second = null;
		
		try {
			// Set up the two digits
			first = new Digit('0');
			second = new Digit('0');
		} catch (DigitException e) {
			fail("The digits are valid.");
		}
		
		assertTrue(first.compareTo(second) == 0);
	}

}
