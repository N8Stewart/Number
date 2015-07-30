import number.NaturalNumber;
import number.exception.DigitException;
import number.exception.NaturalNumberException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NaturalNumberTest {
	
	/**
	 * Ensure a deque is correctly established to hold the digits
	 */
	@Test(groups = {"natural_number"})
	public void test_Constructor(){
		
		NaturalNumber num = null;
		String rep = "100";
		
		// Parse the natural number
		try {
			num = new NaturalNumber(rep);
		} catch (DigitException e) {
			Assert.fail("All digits are valid.");
		} catch (NaturalNumberException e) {
			Assert.fail("Number is valid.");
		}

		// Convert the number back to a string and make sure it is the same
		Assert.assertEquals("String representation does not match expected.", rep, num.toString());

	}

}
