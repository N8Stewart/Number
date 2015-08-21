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


}
