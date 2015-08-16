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

        NaturalNumber num = null, result = null;
        final String rep = "1234567890";

        // Parse the natural number
        try {
            num = new NaturalNumber(rep);
            result = new NaturalNumber(num);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        } catch (NaturalNumberException e) {
            Assert.fail("Number is valid.");
        }


        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(result.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure a very large natural number can be generated
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NaturalNumberException.class)
    public void test_constructor_null_string() throws DigitException, NaturalNumberException {
        new NaturalNumber((String) null);
    }

    /**
     * Ensure a very large natural number can be generated
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NaturalNumberException.class)
    public void test_constructor_null_NN() throws DigitException, NaturalNumberException {
        new NaturalNumber((NaturalNumber) null);
    }

    /**
     * Requires rep1 and rep2 to be valid NaturalNumbers
     * Requires assertions to be enabled
     *
     * @param rep1 representation of the first NaturalNumber
     * @param rep2 representation of the second NaturalNumber
     * @return the result of NN1.compareTo(NN2)
     */
    private int compareToHelper(String rep1, String rep2) {
        try {
            return new NaturalNumber(rep1).compareTo(new NaturalNumber(rep2));
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
            return -2;
        } catch (NaturalNumberException e) {
            Assert.fail("Number is valid.");
            return -3;
        }

    }

    /**
     * Compare two natural numbers and ensure the output is consistent
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_compareTo_Valid() {

        // compare the two numbers and ensure the expected result is returned
        Assert.assertEquals(compareToHelper("1", "1"), 0);
        Assert.assertEquals(compareToHelper("2", "1"), 1);
        Assert.assertEquals(compareToHelper("3", "1"), 1);
        Assert.assertEquals(compareToHelper("1", "2"), -1);
        Assert.assertEquals(compareToHelper("1", "3"), -1);

    }

}