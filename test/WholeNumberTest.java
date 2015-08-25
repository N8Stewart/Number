import number.impl.NaturalNumber;
import number.impl.WholeNumber;
import number.exception.DigitException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for WholeNumber functionality
 */
public class WholeNumberTest {

    /**
     * Ensure a deque is correctly established to hold the digits
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_Constructor_100() {

        WholeNumber num = null;
        final String rep = "100";

        // Parse the natural number
        try {
            num = new WholeNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure WN can handle 0 properly
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_Constructor_0() {

        WholeNumber num = null;
        final String rep = "0";

        // Parse the natural number
        try {
            num = new WholeNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure WN can handle 0 properly
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_Constructor_0000000() {

        WholeNumber num = null;
        final String rep = "0000000";
        final String expectedResult = "0";

        // Parse the natural number
        try {
            num = new WholeNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), expectedResult, "String representation does not match expected.");

    }

    /**
     * Ensure Integer '-1' cannot be created as a whole number
     */
    @Test(groups = {"whole_number", "unit"}, expectedExceptions = DigitException.class)
    public void test_Constructor_negative_1() throws DigitException {

        final String rep = "-1";
        new WholeNumber(rep);

    }

    /**
     * Ensure a whole number can be created from the string representation
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_Constructor_1() {

        WholeNumber num = null;
        final String rep = "1";

        // Parse the natural number
        try {
            num = new WholeNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure a whole number can be created from the string representation
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_Constructor_2019() {

        WholeNumber num = null;
        final String rep = "2019";

        // Parse the natural number
        try {
            num = new WholeNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure a very large whole number can be generated
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_Constructor_1234567890x20() {

        NaturalNumber num = null;
        final String rep = "1234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890";

        // Parse the whole number
        try {
            num = new WholeNumber(rep);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure a very large whole number can be generated
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_copy_constructor_1234567890() {

        WholeNumber num = null, result = null;
        final String rep = "1234567890";

        // Parse the whole number
        try {
            num = new WholeNumber(rep);
            result = new WholeNumber(num);
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(result.toString(), rep, "String representation does not match expected.");

    }

    /**
     * Ensure a NPE is thrown when a whole number is created using a null String
     */
    @Test(groups = {"whole_number", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_constructor_null_string() throws DigitException {
        new WholeNumber((String) null);
    }

    /**
     * Ensure a NPE is thrown when a whole number is created using a null object
     */
    @Test(groups = {"whole_number", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_constructor_null_NN() throws DigitException {
        new WholeNumber((WholeNumber) null);
    }

    /**
     * Ensure a whole number '0' is created using the default constructor
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_default_constructor() {

        final String expectedResult = "0";
        WholeNumber num = new WholeNumber();

        // Convert the number back to a string and make sure it is the same
        Assert.assertEquals(num.toString(), expectedResult, "String representation does not match expected.");

    }

    /**
     * Compare two whole numbers and ensure the output is consistent
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_compareTo_Valid() throws DigitException {

        // compare the two numbers and ensure the expected result is returned
        Assert.assertTrue(new WholeNumber("0").compareTo(new WholeNumber("0")) == 0);
        Assert.assertTrue(new WholeNumber("0").compareTo(new WholeNumber("1")) < 0);
        Assert.assertTrue(new WholeNumber("1").compareTo(new WholeNumber("0")) > 0);

    }

    /**
     * Compare WN to null and ensure a NullPointerException is thrown
     */
    @Test(groups = {"whole_number", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_compareTo_null() throws DigitException {
        new WholeNumber("0").compareTo(null);
    }

    /**
     * compare a WN to itself and ensure they are equal
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_compareTo_sameNN() throws DigitException {

        WholeNumber num = new WholeNumber("0");
        Assert.assertTrue(num.compareTo(num) == 0, "Whole Number does not equal itself.");

    }

    /**
     * compare a WN to a different instance with the same value
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_compareTo_sameValue() throws DigitException {

        WholeNumber num1 = new WholeNumber("0");
        WholeNumber num2 = new WholeNumber("0");
        Assert.assertTrue(num1.compareTo(num2) == 0, "Whole Number does not equal itself.");

    }

    /**
     * Compare two whole numbers and ensure the output is consistent
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_equals_Valid() throws DigitException {

        // compare the two numbers and ensure the expected result is returned
        Assert.assertTrue(new WholeNumber("0").equals(new WholeNumber("0")));
        Assert.assertFalse(new WholeNumber("0").equals(new WholeNumber("1")));
        Assert.assertFalse(new WholeNumber("1").equals(new WholeNumber("0")));

    }

    /**
     * Compare WN to null and ensure the equals method returns false
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_equals_null() throws DigitException {
        Assert.assertFalse(new WholeNumber("0").equals(null));
    }

    /**
     * compare a WN to itself and ensure they are equal
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_equals_sameWN() throws DigitException {

        WholeNumber num = new WholeNumber("0");
        Assert.assertTrue(num.equals(num), "Whole Number does not equal itself.");

    }

    /**
     * compare a WN to a different instance with the same value
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_equals_sameValue() throws DigitException {

        WholeNumber num1 = new WholeNumber("0");
        WholeNumber num2 = new WholeNumber("0");
        Assert.assertTrue(num1.equals(num2), "Whole Number does not equal itself.");

    }

    /**
     * compare a WN to a string and ensure the equals method returns false
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_equals_toString() throws DigitException {

        WholeNumber num1 = new WholeNumber("1");
        Assert.assertFalse(num1.equals("this is false."), "Whole Number equals a String somehow.");

    }

    /**
     * Print a WN as a string and ensure it comes back as expected
     */
    @Test(groups = {"whole_number", "unit"})
    public void test_toString() throws DigitException {

        final String rep = "0";

        WholeNumber num = new WholeNumber(rep);
        Assert.assertEquals(num.toString(), rep, "Whole Number string representation does not match expected.");

        // Use the copy constructor to create another WN
        WholeNumber numCopied = new WholeNumber(num);
        Assert.assertEquals(numCopied.toString(), rep, "Whole Number string representation does not match expected.");

    }

}
