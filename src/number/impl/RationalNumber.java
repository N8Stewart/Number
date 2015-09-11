package number.impl;

import number.Number;
import number.attribute.Positivity;
import number.attribute.Zeroable;
import number.exception.DigitException;
import number.exception.NaturalNumberException;
import number.exception.RationalNumberException;

public class RationalNumber implements Positivity, Zeroable, number.Number {

    private Integer numerator;
    private NaturalNumber denominator;

    /**
     * Create a RationalNumber with value of 0.
     */
    public RationalNumber() {

        try {
            this.numerator = new Integer("0");
            this.denominator = new NaturalNumber("1");
        } catch (DigitException | NaturalNumberException e) {
            // This will never occur unless the Integer or NaturalNumber constructors have been modified
        }

    }

    /**
     * Construct a RationalNumber from a string representation
     *
     * @param number a string representation of a rational number
     * @throws RationalNumberException when a rational number
     */
    public RationalNumber(final String number) throws RationalNumberException {



    }

    /**
     * Construct a RationalNumber from a numerator and denominator.
     *
     * @param numerator   an Integer value represents the numerator for a rational number
     * @param denominator a NaturalNumber represents the denominator for a rational number
     */
    public RationalNumber(final Integer numerator, final NaturalNumber denominator) {

        this.numerator = numerator;
        this.denominator = denominator;

    }

    @Override
    public boolean isPositive() {
        return this.numerator.isPositive();
    }

    @Override
    public boolean isZero() {
        return this.numerator.isZero();
    }

    @Override
    public int compareTo(Number o) {
        return 0;
    }

}
