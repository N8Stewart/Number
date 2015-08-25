package number.impl;

import number.Digit;
import number.attribute.Zeroable;
import number.exception.DigitException;
import number.exception.NaturalNumberException;

public class WholeNumber extends NaturalNumber implements Zeroable {

    /**
     * Parse a string and generate a WholeNumber from the digits.
     *
     * @param number String representation of the number to be stored in this.
     * @throws DigitException If one of the digits in number is non-numeric.
     */
    public WholeNumber(final String number) throws DigitException {

        super();

        if (number == null) {
            throw new NullPointerException("Cannot construct a WholeNumber from a null representation.");
        }

        this.parseStringRep(number);

    }

    /**
     * Copy a WholeNumber from number into this.
     *
     * @param number the number to be copied from.
     * @throws NullPointerException if number is not a valid representation of a WholeNumber.
     */
    public WholeNumber(final WholeNumber number) {
        super(number);
    }

    /**
     * Create a whole number with value of 0.
     */
    public WholeNumber() {
        super();

        try {
            this.digits.add(new Digit('0'));
        } catch (DigitException e) {
            throw new RuntimeException("Digit unable to be created.");
        }
    }

    @Override
    protected void parseStringRep(final String number) throws DigitException {

        try {
            super.parseStringRep(number);
        } catch (NaturalNumberException e) { // Out of bounds, so only digit is 0
            this.digits.add(new Digit('0'));
        }

    }

    @Override
    public boolean isZero() {
        return this.digits.size() == 1 && this.digits.peek().isZero() ? true : false;
    }

}
