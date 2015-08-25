import number.impl.Integer;
import number.exception.DigitException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for Integer functionality
 */
public class IntegerTest {

    /**
     * Requires rep1 and rep2 to be valid Integers
     * Requires assertions to be enabled
     *
     * @param rep1 representation of the first Integer
     * @param rep2 representation of the second Integer
     * @return the result of I1.compareTo(I2)
     */
    private int compareToHelper(String rep1, String rep2) {
        try {
            return new Integer(rep1).compareTo(new Integer(rep2));
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Assertions will fail the test, so this will never matter.
        return 0;

    }

    /**
     * Requires rep1 and rep2 to be valid Integers
     * Requires assertions to be enabled
     *
     * @param rep1 representation of the first Integer
     * @param rep2 representation of the second Integer
     * @return the result of I1.equals(I2)
     */
    private boolean equalsHelper(String rep1, String rep2) {
        try {
            return new Integer(rep1).equals(new Integer(rep2));
        } catch (DigitException e) {
            Assert.fail("All digits are valid.");
        }

        // Assertions will fail the test, so this will never matter.
        return false;

    }

    /**
     * Ensure a negative number is printed correctly
     */
    @Test(groups = {"integer", "unit"})
    public void test_toString_negative() throws DigitException {

        final String rep = "-16748395";
        Assert.assertEquals(new Integer(rep).toString(), rep, "Expected integer representation not found.");

    }

    /**
     * Ensure a positive number is printed correctly
     */
    @Test(groups = {"integer", "unit"})
    public void test_toString_positive() throws DigitException {

        final String rep = "9549405829";
        Assert.assertEquals(new Integer(rep).toString(), rep, "Expected integer representation not found.");

    }

    /**
     * Ensure zero is printed correctly
     */
    @Test(groups = {"integer", "unit"})
    public void test_toString_zero() throws DigitException {

        final String rep = "0";
        Assert.assertEquals(new Integer(rep).toString(), rep, "Expected integer representation not found.");

    }

    /**
     * Ensure a negative number is printed correctly
     */
    @Test(groups = {"integer", "unit"})
    public void test_isPositive() throws DigitException {

        Assert.assertTrue(new Integer("0").isPositive(), "0 is reported as a non-positive number");
        Assert.assertTrue(new Integer("120202").isPositive(), "120202 is reported as a non-positive number");
        Assert.assertFalse(new Integer("-987654").isPositive(), "-987654 is reported as a positive number");

    }

    /**
     * Ensure a integer with value '0' is created using the default constructor
     */
    @Test(groups = {"integer", "unit"})
    public void test_default_constructor() throws DigitException {

        Integer integer = new Integer();
        Assert.assertTrue(integer.isZero(), "Default constructor instantiated non-zero integer");

    }

    /**
     * Ensure a positive number can be copied correctly using the copy constructor
     */
    @Test(groups = {"integer", "unit"})
    public void test_copy_constructor_positive() throws DigitException {

        final String rep = "5678904596877896458756467";

        Integer integerSource = new Integer(rep);
        Integer integerDest = new Integer(integerSource);
        Assert.assertEquals(integerDest.toString(), rep, "Copy constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a negative number can be copied correctly using the copy constructor
     */
    @Test(groups = {"integer", "unit"})
    public void test_copy_constructor_negative() throws DigitException {

        final String rep = "-345678987654456787654345678";

        Integer integerSource = new Integer(rep);
        Integer integerDest = new Integer(integerSource);
        Assert.assertEquals(integerDest.toString(), rep, "Copy constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a zero can be copied correctly using the copy constructor
     */
    @Test(groups = {"integer", "unit"})
    public void test_copy_constructor_zero() throws DigitException {

        final String rep = "0";

        Integer integerSource = new Integer(rep);
        Integer integerDest = new Integer(integerSource);
        Assert.assertEquals(integerDest.toString(), rep, "Copy constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_positive1() throws DigitException {

        final String rep = "00000001234567890";
        final String expectedRep = "1234567890";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), expectedRep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_positive2() throws DigitException {

        final String rep = "1";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), rep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_positive3() throws DigitException {

        final String rep = "0";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), rep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_positive4() throws DigitException {

        final String rep = "12345678998765456789999008765456765434567876545678765434567897654567";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), rep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_negative1() throws DigitException {

        final String rep = "-12345678998765456789999008765456765434567876545678765434567897654567";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), rep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_negative2() throws DigitException {

        final String rep = "-1";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), rep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_negative3() throws DigitException {

        final String rep = "-000000000004";
        final String expectedRep = "-4";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), expectedRep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Ensure a deque can be properly generated for the passed in string
     */
    @Test(groups = {"integer", "unit"})
    public void test_constructor_negative() throws DigitException {

        final String rep = "-1337";

        Integer integer = new Integer(rep);
        Assert.assertEquals(integer.toString(), rep, "Constructor instantiated incorrect integer.");

    }

    /**
     * Compare two integers and ensure the output is consistent
     */
    @Test(groups = {"integer", "unit"})
    public void test_compareTo_Valid() {

        // compare two positive numbers and ensure the expected result is returned
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
        // compare two negative numbers and ensure the expected result is returned
        Assert.assertTrue(compareToHelper("-1", "-1") == 0);
        Assert.assertTrue(compareToHelper("-2", "-1") < 0);
        Assert.assertTrue(compareToHelper("-3", "-1") < 0);
        Assert.assertTrue(compareToHelper("-1", "-2") > 0);
        Assert.assertTrue(compareToHelper("-1", "-3") > 0);
        Assert.assertTrue(compareToHelper("-10", "-3") < 0);
        Assert.assertTrue(compareToHelper("-11", "-10") < 0);
        Assert.assertTrue(compareToHelper("-18", "-19") > 0);
        Assert.assertTrue(compareToHelper("-00012", "-13") > 0);
        Assert.assertTrue(compareToHelper("-12345678901234567890", "-12345678901234567890") == 0);
        Assert.assertTrue(compareToHelper("-12345678901234567890", "-12345678901234567891") > 0);
        Assert.assertTrue(compareToHelper("-123456999909876543211234567890", "-123456789009876543211234567890") < 0);
        // compare one positive and one negative number and ensure the expected result is returned
        Assert.assertTrue(compareToHelper("-1", "1") < 0);
        Assert.assertTrue(compareToHelper("-2", "1") < 0);
        Assert.assertTrue(compareToHelper("-3", "1") < 0);
        Assert.assertTrue(compareToHelper("-1", "2") < 0);
        Assert.assertTrue(compareToHelper("-1", "3") < 0);
        Assert.assertTrue(compareToHelper("-10", "3") < 0);
        Assert.assertTrue(compareToHelper("-11", "10") < 0);
        Assert.assertTrue(compareToHelper("-18", "19") < 0);
        Assert.assertTrue(compareToHelper("-00012", "13") < 0);
        Assert.assertTrue(compareToHelper("-12345678901234567890", "12345678901234567890") < 0);
        Assert.assertTrue(compareToHelper("-12345678901234567890", "12345678901234567891") < 0);
        Assert.assertTrue(compareToHelper("-123456999909876543211234567890", "123456789009876543211234567890") < 0);
        Assert.assertTrue(compareToHelper("1", "-1") > 0);
        Assert.assertTrue(compareToHelper("2", "-1") > 0);
        Assert.assertTrue(compareToHelper("3", "-1") > 0);
        Assert.assertTrue(compareToHelper("1", "-2") > 0);
        Assert.assertTrue(compareToHelper("1", "-3") > 0);
        Assert.assertTrue(compareToHelper("10", "-3") > 0);
        Assert.assertTrue(compareToHelper("11", "-10") > 0);
        Assert.assertTrue(compareToHelper("18", "-19") > 0);
        Assert.assertTrue(compareToHelper("00012", "-13") > 0);
        Assert.assertTrue(compareToHelper("12345678901234567890", "-12345678901234567890") > 0);
        Assert.assertTrue(compareToHelper("12345678901234567890", "-12345678901234567891") > 0);
        Assert.assertTrue(compareToHelper("123456999909876543211234567890", "-123456789009876543211234567890") > 0);
        // Compare zeroes
        Assert.assertTrue(compareToHelper("0", "0") == 0);
        Assert.assertTrue(compareToHelper("2", "0") > 0);
        Assert.assertTrue(compareToHelper("0", "1") < 0);
        Assert.assertTrue(compareToHelper("-1", "0") < 0);
        Assert.assertTrue(compareToHelper("0", "-1") > 0);

    }

    /**
     * Compare integer to null and ensure a NullPointerException is thrown
     */
    @Test(groups = {"integer", "unit"}, expectedExceptions = NullPointerException.class)
    public void test_compareTo_null() throws DigitException {
        new Integer("-1").compareTo(null);
    }

    /**
     * compare integer to itself and ensure they are equal
     */
    @Test(groups = {"integer", "unit"})
    public void test_compareTo_same_integer() throws DigitException {

        Integer num = new Integer("-1456789087654345678765434567");
        Assert.assertTrue(num.compareTo(num) == 0, "Natural Number does not equal itself.");

        num = new Integer("0000000000000");
        Assert.assertTrue(num.compareTo(num) == 0, "Natural Number does not equal itself.");

        num = new Integer("4567894567876543456776545670");
        Assert.assertTrue(num.compareTo(num) == 0, "Natural Number does not equal itself.");

    }

    /**
     * compare integer to a different instance with the same value
     */
    @Test(groups = {"integer", "unit"})
    public void test_compareTo_sameValue() throws DigitException {

        Integer num1 = new Integer("-12345678901");
        Integer num2 = new Integer("-12345678901");
        Assert.assertTrue(num1.compareTo(num2) == 0, "Natural Number does not equal itself.");

    }

    /**
     * Compare two integers and ensure the output is consistent
     */
    @Test(groups = {"integer", "unit"})
    public void test_equals_Valid() {

        // compare two positive numbers and ensure the expected result is returned
        Assert.assertTrue(equalsHelper("1", "1"));
        Assert.assertFalse(equalsHelper("2", "1"));
        Assert.assertFalse(equalsHelper("3", "1"));
        Assert.assertFalse(equalsHelper("1", "2"));
        Assert.assertFalse(equalsHelper("1", "3"));
        Assert.assertFalse(equalsHelper("10", "3"));
        Assert.assertFalse(equalsHelper("11", "10"));
        Assert.assertFalse(equalsHelper("18", "19"));
        Assert.assertFalse(equalsHelper("00012", "13"));
        Assert.assertTrue(equalsHelper("12345678901234567890", "12345678901234567890"));
        Assert.assertFalse(equalsHelper("12345678901234567890", "12345678901234567891"));
        Assert.assertFalse(equalsHelper("123456999909876543211234567890", "123456789009876543211234567890"));
        // compare two negative numbers and ensure the expected result is returned
        Assert.assertTrue(equalsHelper("-1", "-1"));
        Assert.assertFalse(equalsHelper("-2", "-1"));
        Assert.assertFalse(equalsHelper("-3", "-1"));
        Assert.assertFalse(equalsHelper("-1", "-2"));
        Assert.assertFalse(equalsHelper("-1", "-3"));
        Assert.assertFalse(equalsHelper("-10", "-3"));
        Assert.assertFalse(equalsHelper("-11", "-10"));
        Assert.assertFalse(equalsHelper("-18", "-19"));
        Assert.assertFalse(equalsHelper("-00012", "-13"));
        Assert.assertTrue(equalsHelper("-12345678901234567890", "-12345678901234567890"));
        Assert.assertFalse(equalsHelper("-12345678901234567890", "-12345678901234567891"));
        Assert.assertFalse(equalsHelper("-123456999909876543211234567890", "-123456789009876543211234567890"));
        // compare one positive and one negative number and ensure the expected result is returned
        Assert.assertFalse(equalsHelper("-1", "1"));
        Assert.assertFalse(equalsHelper("-2", "1"));
        Assert.assertFalse(equalsHelper("-3", "1"));
        Assert.assertFalse(equalsHelper("-1", "2"));
        Assert.assertFalse(equalsHelper("-1", "3"));
        Assert.assertFalse(equalsHelper("-10", "3"));
        Assert.assertFalse(equalsHelper("-11", "10"));
        Assert.assertFalse(equalsHelper("-18", "19"));
        Assert.assertFalse(equalsHelper("-00012", "13"));
        Assert.assertFalse(equalsHelper("-12345678901234567890", "12345678901234567890"));
        Assert.assertFalse(equalsHelper("-12345678901234567890", "12345678901234567891"));
        Assert.assertFalse(equalsHelper("-123456999909876543211234567890", "123456789009876543211234567890"));
        Assert.assertFalse(equalsHelper("1", "-1"));
        Assert.assertFalse(equalsHelper("2", "-1"));
        Assert.assertFalse(equalsHelper("3", "-1"));
        Assert.assertFalse(equalsHelper("1", "-2"));
        Assert.assertFalse(equalsHelper("1", "-3"));
        Assert.assertFalse(equalsHelper("10", "-3"));
        Assert.assertFalse(equalsHelper("11", "-10"));
        Assert.assertFalse(equalsHelper("18", "-19"));
        Assert.assertFalse(equalsHelper("00012", "-13"));
        Assert.assertFalse(equalsHelper("12345678901234567890", "-12345678901234567890"));
        Assert.assertFalse(equalsHelper("12345678901234567890", "-12345678901234567891"));
        Assert.assertFalse(equalsHelper("123456999909876543211234567890", "-123456789009876543211234567890"));
        // Compare zeroes
        Assert.assertTrue(equalsHelper("0", "0"));
        Assert.assertFalse(equalsHelper("2", "0"));
        Assert.assertFalse(equalsHelper("0", "1"));
        Assert.assertFalse(equalsHelper("-1", "0"));
        Assert.assertFalse(equalsHelper("0", "-1"));

    }

    /**
     * Compare integer to null and ensure the equals method returns false
     */
    @Test(groups = {"integer", "unit"})
    public void test_equals_null() throws DigitException {
        Assert.assertFalse(new Integer("-1").equals(null));
    }

    /**
     * compare integer to itself and ensure they are equal
     */
    @Test(groups = {"integer", "unit"})
    public void test_equals_same_integer() throws DigitException {

        Integer num = new Integer("-09876543234567854345654323456781");
        Assert.assertTrue(num.equals(num), "Natural Number does not equal itself.");

    }

    /**
     * compare integer to a different instance with the same value
     */
    @Test(groups = {"integer", "unit"})
    public void test_equals_sameValue() throws DigitException {

        Integer num1 = new Integer("-678987656781");
        Integer num2 = new Integer("-678987656781");
        Assert.assertTrue(num1.equals(num2), "Natural Number does not equal itself.");

    }

    /**
     * compare integer to a string and ensure the equals method returns false
     */
    @Test(groups = {"integer", "unit"})
    public void test_equals_toString() throws DigitException {

        Integer num1 = new Integer("-12342341");
        Assert.assertFalse(num1.equals("this is false."), "Natural Number equals a String somehow.");

    }

}
