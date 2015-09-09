import number.exception.DigitException;
import number.impl.RationalNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for Rational Number functionality
 */
public class RationalNumberTest {

    /**
     * Ensure a rational number with value '0' is created using the default constructor
     */
    @Test(groups = {"integer", "unit"})
    public void test_default_constructor() throws DigitException {

        number.impl.RationalNumber rationalNumber = new RationalNumber();
        Assert.assertTrue(rationalNumber.isZero(), "Default constructor instantiated non-zero rational number.");

    }

}
