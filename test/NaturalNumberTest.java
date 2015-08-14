import number.NaturalNumber;
import number.exception.DigitException;
import number.exception.NaturalNumberException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NaturalNumberTest {

    /**
     * Ensure a deque is correctly established to hold the digits
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_Constructor_100() {

        NaturalNumber num = null;
        final String rep = "100";

        // Parse the natural number
        try {
            num = new NaturalNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        } catch (NaturalNumberException e) {
            Assert.fail("Number is valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure a deque is correctly established to hold the digits
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NaturalNumberException.class)
    public void test_Constructor_000() throws DigitException, NaturalNumberException {

        final String rep = "000";
        new NaturalNumber(rep);

    }
}