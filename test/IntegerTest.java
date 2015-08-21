import number.Integer;
import number.exception.DigitException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for WholeNumber functionality
 */
public class IntegerTest {

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

}
