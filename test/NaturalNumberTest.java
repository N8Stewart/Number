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
     * Ensure whole number '0' cannot be created as a natural number
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NaturalNumberException.class)
    public void test_Constructor_000() throws DigitException, NaturalNumberException {

        final String rep = "000";
        new NaturalNumber(rep);

    }

    /**
     * Ensure Integer '-1' cannot be created as a natural number
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = DigitException.class)
    public void test_Constructor_negative_1() throws DigitException, NaturalNumberException {

        final String rep = "-1";
        new NaturalNumber(rep);

    }

    /**
     * Ensure whole number '0' cannot be created as a natural number
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NaturalNumberException.class)
    public void test_Constructor_0() throws DigitException, NaturalNumberException {

        final String rep = "0";
        new NaturalNumber(rep);

    }

    /**
     * Ensure a natural number can be created from the string representation
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_Constructor_1() {

        NaturalNumber num = null;
        final String rep = "1";

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
     * Ensure a natural number can be created from the string representation
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_Constructor_2019() {

        NaturalNumber num = null;
        final String rep = "2019";

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
     * Ensure a very large natural number can be generated
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_Constructor_1234567890x20() {

        NaturalNumber num = null;
        final String rep = "1234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890";

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
     * Ensure a very large natural number can be generated
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_copy_constructor_1234567890() {

        NaturalNumber num = null;
        final String rep = "1234567890";

        // Parse the natural number
        try {
            num = new NaturalNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        } catch (NaturalNumberException e) {
            Assert.fail("Number is valid.");
        }

        NaturalNumber result = new NaturalNumber(num);
        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(result.toString(), rep, "String representation does not match expected.");

    }

}