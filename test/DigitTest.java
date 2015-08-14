import number.Digit;
import number.exception.DigitException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigitTest {

    /**
     * Ensure trash values can't become digits through the constructor.
     */
    @Test(groups = {"digit", "unit"})
    public void test_default_constructor() {
        Digit digit = new Digit(); //This should be 0
        Assert.assertTrue(digit.isZero());
    }

    /**
     * Ensure trash values can't become digits through the constructor.
     */
    @Test(groups = {"digit", "unit"}, expectedExceptions = DigitException.class)
    public void test_constructor_a() throws DigitException {
        new Digit('a');
    }

    /**
     * Ensure trash values can't become digits through the constructor.
     */
    @Test(groups = {"digit", "unit"}, expectedExceptions = DigitException.class)
    public void test_constructor_A() throws DigitException {
        new Digit('A');
    }

    /**
     * Ensure trash values can't become digits through the constructor.
     */
    @Test(groups = {"digit", "unit"}, expectedExceptions = DigitException.class)
    public void test_constructor_dash() throws DigitException {
        new Digit('-');
    }

    /**
     * Ensure trash values can't become digits through the constructor.
     */
    @Test(groups = {"digit", "unit"}, expectedExceptions = DigitException.class)
    public void test_constructor_exclamation() throws DigitException {
        new Digit('!');
    }

    /**
     * Ensure correct digits are parsed correctly
     */
    @Test(groups = {"digit", "unit"})
    public void test_constructor_0() {
        try {
            new Digit('0');

        } catch (DigitException e) {
            Assert.fail("Digit 0 is a valid digit.");
        }
    }

    /**
     * Ensure correct digits are parsed correctly
     */
    @Test(groups = {"digit", "unit"})
    public void test_constructor_1() {
        try {
            new Digit('1');

        } catch (DigitException e) {
            Assert.fail("Digit 1 is a valid digit.");
        }
    }

    /**
     * Ensure correct digits are parsed correctly
     */
    @Test(groups = {"digit", "unit"})
    public void test_constructor_9() {
        try {
            new Digit('9');

        } catch (DigitException e) {
            Assert.fail("Digit 9 is a valid digit.");
        }
    }

    /**
     * Ensure the digit is set correctly before an after the call to set digit.
     */
    @Test(groups = {"digit", "unit"})
    public void test_setDigit_1_from_0() {

        Digit digit = null;

        try {
            // Create digit and make sure it is set correctly
            digit = new Digit('0');
            Assert.assertTrue(digit.getDigit() == '0');
        } catch (DigitException e) {
            Assert.fail("Problem creating digit");
        }

        try {
            digit.setDigit('1');
            Assert.assertTrue(digit.getDigit() == '1');
        } catch (DigitException e) {
            Assert.fail("Problem setting valid digit.");
        }

    }

    /**
     * Ensure the digit is set correctly before an after the call to set digit.
     */
    @Test(groups = {"digit", "unit"})
    public void test_setDigit_9_from_8() {

        Digit digit = null;

        try {
            // Create digit and make sure it is set correctly
            digit = new Digit('8');
            Assert.assertTrue(digit.getDigit() == '8');
        } catch (DigitException e) {
            Assert.fail("Problem creating digit");
        }

        try {
            digit.setDigit('9');
            Assert.assertTrue(digit.getDigit() == '9');
        } catch (DigitException e) {
            Assert.fail("Problem setting valid digit.");
        }

    }

    /**
     * Ensure the digit is set correctly before an after the call to set digit.
     */
    @Test(groups = {"digit", "unit"})
    public void test_setDigit_a_from_0() {

        Digit digit = null;

        try {
            // Create digit and make sure it is set correctly
            digit = new Digit('0');
            Assert.assertTrue(digit.getDigit() == '0');
        } catch (DigitException e) {
            Assert.fail("Problem creating digit");
        }

        try {
            digit.setDigit('a');
            Assert.fail("Exception wasn't thrown for invalid digit.");
        } catch (DigitException e) {
            // We expect an exception to arise here.
        }

    }

    /**
     * Ensure the digit is set correctly before an after the call to set digit.
     */
    @Test(groups = {"digit", "unit"})
    public void test_setDigit_dollar_from_0() {

        Digit digit = null;

        try {
            // Create digit and make sure it is set correctly
            digit = new Digit('0');
            Assert.assertTrue(digit.getDigit() == '0');
        } catch (DigitException e) {
            Assert.fail("Problem creating digit");
        }

        try {
            digit.setDigit('$');
            Assert.fail("Exception wasn't thrown for invalid digit.");
        } catch (DigitException e) {
            // We expect an exception to arise here.
        }

    }

    /**
     * Test if isDigit works correctly in deciding if something is a digit or not
     */
    @Test(groups = {"digit", "unit"})
    public void test_isDigit() {
        Assert.assertTrue(Digit.isDigit('0'));
        Assert.assertTrue(Digit.isDigit('1'));
        Assert.assertTrue(Digit.isDigit('9'));
        Assert.assertFalse(Digit.isDigit('a'));
        Assert.assertTrue(Digit.isDigit(1));
        Assert.assertTrue(Digit.isDigit(0));
        Assert.assertTrue(Digit.isDigit(9));
        Assert.assertFalse(Digit.isDigit(20));
        Assert.assertFalse(Digit.isDigit(-1));
        Assert.assertFalse(Digit.isDigit('&'));
    }


    /**
     * Test if the valid digit 0 is even.
     */
    @Test(groups = {"digit", "unit"})
    public void test_isEven_0() {
        try {
            Assert.assertTrue(new Digit('0').isEven());
        } catch (DigitException e) {
            Assert.fail("The digit 0 is a  digit.");
        }
    }

    /**
     * Test if the valid digit 1 is even.
     */
    @Test(groups = {"digit", "unit"})
    public void test_isEven_1() {
        try {
            Assert.assertFalse(new Digit('1').isEven());
        } catch (DigitException e) {
            Assert.fail("The digit 1 is a digit");
        }
    }

    /**
     * Test if the valid digit 2 is even.
     */
    @Test(groups = {"digit", "unit"})
    public void test_isEven_2() {
        try {
            Assert.assertTrue(new Digit('2').isEven());
        } catch (DigitException e) {
            Assert.fail("The digit 2 is a  digit.");
        }
    }

    /**
     * Compare the digit 0 to 1. Should return a negative value since 0 < 1.
     */
    @Test(groups = {"digit", "unit"})
    public void test_compareTo_0_1() {

        Digit first = null, second = null;

        try {
            // Set up the two digits
            first = new Digit('0');
            second = new Digit('1');
        } catch (DigitException e) {
            Assert.fail("The digits are valid.");
        }

        Assert.assertTrue(first.compareTo(second) < 0);
    }

    /**
     * Compare the digit 1 to 0. Should return a negative value since 1 > 0.
     */
    @Test(groups = {"digit", "unit"})
    public void test_compareTo_1_0() {

        Digit first = null, second = null;

        try {
            // Set up the two digits
            first = new Digit('1');
            second = new Digit('0');
        } catch (DigitException e) {
            Assert.fail("The digits are valid.");
        }

        Assert.assertTrue(first.compareTo(second) > 0);
    }

    /**
     * Compare the digit 0 to 0. Should return a negative value since 0 == 0.
     */
    @Test(groups = {"digit", "unit"})
    public void test_compareTo_0_0() {

        Digit first = null, second = null;

        try {
            // Set up the two digits
            first = new Digit('0');
            second = new Digit('0');
        } catch (DigitException e) {
            Assert.fail("The digits are valid.");
        }

        Assert.assertTrue(first.compareTo(second) == 0, "Digits do not match.");
    }

}
