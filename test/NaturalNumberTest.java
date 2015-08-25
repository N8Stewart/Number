import number.impl.NaturalNumber;
import number.exception.DigitException;
import number.exception.NaturalNumberException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for NaturalNumber functionality
 */
public class NaturalNumberTest {

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
        } catch (NaturalNumberException e) {
            Assert.fail("Number is valid.");
        }

        // Assertions will fail the test, so this will never matter.
        return 0;

    }

    /**
     * Requires rep1 and rep2 to be valid NaturalNumbers
     * Requires assertions to be enabled
     *
     * @param rep1 representation of the first NaturalNumber
     * @param rep2 representation of the second NaturalNumber
     * @return the result of NN1.equals(NN2)
     */
    private boolean equalsHelper(String rep1, String rep2) {
        try {
            return new NaturalNumber(rep1).equals(new NaturalNumber(rep2));
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        } catch (NaturalNumberException e) {
            Assert.fail("Number is valid.");
        }

        // Assertions will fail the test, so this will never matter.
        return false;

    }

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
     * Ensure a NPE is thrown when a whole number is created using a null String
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_constructor_null_string() throws DigitException, NaturalNumberException {
        new NaturalNumber((String) null);
    }

    /**
     * Ensure a NPE is thrown when a whole number is created using a null object
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_constructor_null_NN() throws DigitException, NaturalNumberException {
        new NaturalNumber((NaturalNumber) null);
    }

    /**
     * Compare two natural numbers and ensure the output is consistent
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_compareTo_Valid() {

        // compare the two numbers and ensure the expected result is returned
        Assert.assertTrue(compareToHelper("1", "1") == 0);
        Assert.assertTrue(compareToHelper("2", "1") > 0);
        Assert.assertTrue(compareToHelper("3", "1") > 0);
        Assert.assertTrue(compareToHelper("1", "2") < 0);
        Assert.assertTrue(compareToHelper("1", "3") < 0);
        Assert.assertTrue(compareToHelper("10", "3") > 0);
        Assert.assertTrue(compareToHelper("11", "10") > 0);
        Assert.assertTrue(compareToHelper("18", "19") < 0);
        Assert.assertTrue(compareToHelper("00012", "13") < 0);
        Assert.assertTrue(compareToHelper("12345678901234567890", "12345678901234567890") == 0);
        Assert.assertTrue(compareToHelper("12345678901234567890", "12345678901234567891") < 0);
        Assert.assertTrue(compareToHelper("123456999909876543211234567890", "123456789009876543211234567890") > 0);

    }

    /**
     * Compare NN to null and ensure a NullPointerException is thrown
     */
    @Test(groups = {"natural_number", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_compareTo_null() throws NaturalNumberException, DigitException {
        new NaturalNumber("1").compareTo(null);
    }

    /**
     * compare a NN to itself and ensure they are equal
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_compareTo_sameNN() throws NaturalNumberException, DigitException {

        NaturalNumber num = new NaturalNumber("1");
        Assert.assertTrue(num.compareTo(num) == 0, "Natural Number does not equal itself.");

    }

    /**
     * compare a NN to a different instance with the same value
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_compareTo_sameValue() throws NaturalNumberException, DigitException {

        NaturalNumber num1 = new NaturalNumber("1");
        NaturalNumber num2 = new NaturalNumber("1");
        Assert.assertTrue(num1.compareTo(num2) == 0, "Natural Number does not equal itself.");

    }

    /**
     * Compare two natural numbers and ensure the output is consistent
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_equals_Valid() {

        // compare the two numbers and ensure the expected result is returned
        Assert.assertTrue(equalsHelper("1", "1"));
        Assert.assertFalse(equalsHelper("1", "2"));
        Assert.assertFalse(equalsHelper("3", "1"));
        Assert.assertFalse(equalsHelper("1", "2"));
        Assert.assertFalse(equalsHelper("1", "3"));
        Assert.assertFalse(equalsHelper("10", "3"));
        Assert.assertFalse(equalsHelper("11", "10"));
        Assert.assertFalse(equalsHelper("18", "19"));
        Assert.assertFalse(equalsHelper("00012", "13"));
        Assert.assertTrue(equalsHelper("00013", "13"));
        Assert.assertTrue(equalsHelper("12345678901234567890", "12345678901234567890"));
        Assert.assertFalse(equalsHelper("12345678901234567890", "12345678901234567891"));
        Assert.assertFalse(equalsHelper("123456999909876543211234567890", "123456789009876543211234567890"));

    }

    /**
     * Compare NN to null and ensure the equals method returns false
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_equals_null() throws NaturalNumberException, DigitException {
        Assert.assertFalse(new NaturalNumber("1").equals(null));
    }

    /**
     * compare a NN to itself and ensure they are equal
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_equals_sameNN() throws NaturalNumberException, DigitException {

        NaturalNumber num = new NaturalNumber("1");
        Assert.assertTrue(num.equals(num), "Natural Number does not equal itself.");

    }

    /**
     * compare a NN to a different instance with the same value
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_equals_sameValue() throws NaturalNumberException, DigitException {

        NaturalNumber num1 = new NaturalNumber("1");
        NaturalNumber num2 = new NaturalNumber("1");
        Assert.assertTrue(num1.equals(num2), "Natural Number does not equal itself.");

    }

    /**
     * compare a NN to a string and ensure the equals method returns false
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_equals_toString() throws NaturalNumberException, DigitException {

        NaturalNumber num1 = new NaturalNumber("1");
        Assert.assertFalse(num1.equals("this is false."), "Natural Number equals a String somehow.");

    }

    /**
     * Print a NN as a string and ensure it comes back as expected
     */
    @Test(groups = {"natural_number", "unit"})
    public void test_toString() throws NaturalNumberException, DigitException {

        final String rep = "123456765432";

        NaturalNumber num = new NaturalNumber(rep);
        Assert.assertEquals(num.toString(), rep, "Natural Number string representation does not match expected.");

        // Use the copy constructor to create another NN
        NaturalNumber numCopied = new NaturalNumber(num);
        Assert.assertEquals(numCopied.toString(), rep, "Natural Number string representation does not match expected.");

    }

}