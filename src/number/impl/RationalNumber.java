package number.impl;

import number.Number;
import number.attribute.Positivity;
import number.attribute.Zeroable;
import number.exception.DigitException;
import number.exception.NaturalNumberException;

public class RationalNumber implements Positivity, Zeroable, number.Number {

    private Integer numerator;
    private NaturalNumber denominator;

    public RationalNumber() {

        try {
            this.numerator = new Integer("0");
            this.denominator = new NaturalNumber("1");
        } catch (DigitException | NaturalNumberException e) {
            // This will never occur unless the Integer or NaturalNumber constructors have been modified
        }

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
