package number.impl;

import number.Digit;
import number.Number;
import number.attribute.Positivity;
import number.attribute.Zeroable;
import number.exception.DigitException;
import number.exception.NaturalNumberException;
import number.exception.RationalNumberException;

public class RationalNumber implements Positivity, Zeroable, number.Number {

    /**
     * Numerator of the Rational Number, Controls positivity and zeroable attributes.
     */
    private Integer numerator;

    /**
     * Denominator of the Rational Number
     */
    private NaturalNumber denominator;

    /**
     * Used to calculate the hashcode.
     */
    private static final int NUM_BINS = 1337;

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

    @Override
    public String toString() {


        return String.format("%s/%s", this.numerator.toString(), this.denominator.toString());

    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) // obj is this
            return true;
        if (obj == null) // obj is Null
            return false;
        if (!(obj instanceof Number)) // obj does not implement Number
            return false;

        // Compare this object to obj since we know it is a number object that is not this.
        // compareTo will return 0 if the objects are equal to each other.
        return (this.compareTo((Number) obj) == 0);
    }

    @Override
    public int hashCode() {

        return (this.numerator.hashCode() + this.denominator.hashCode()) % NUM_BINS;

    }

}
