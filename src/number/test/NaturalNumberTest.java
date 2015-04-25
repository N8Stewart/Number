package number.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import number.NaturalNumber;
import number.exception.DigitException;
import number.exception.NaturalNumberException;

import org.junit.Test;

public class NaturalNumberTest {
	
	/**
	 * Ensure a deque is correctly established to hold the digits
	 */
	@Test
	public void test_Constructor(){
		
		NaturalNumber num = null;
		String rep = "100";
		
		// Parse the natural number
		try {
			num = new NaturalNumber(rep);
		} catch (DigitException e) {
			fail("All digits are valid.");
		} catch (NaturalNumberException e) {
			fail("Number is valid.");
		}
		
		// Convert the number back to a string and make sure it is the same
		System.out.println(num.toString());
		assertTrue(num.toString() == rep);
		
	}

}
