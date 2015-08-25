package number.impl;

import number.exception.DigitException;

public class Integer extends WholeNumber {

    /**
     * Control if the Integer is positive or negative by keeping sign at 1 or -1
     */
    private int sign = 1;

    /**
     * Create an Integer with value of 0.
     */
    public Integer() {
        super();
    }

    /**
     * Copy an Integer from number into this.
     *
     * @param number the number to be copied from.
     * @throws NullPointerException if number is not a valid representation of an Integer.
     */
    public Integer(final Integer number) {

        // Initiate the number and set the sign the same as the param number
        initNaturalNumber();
        this.sign = number.sign;

        if (number == null) {
            throw new NullPointerException("Cannot construct a NaturalNumber from a null representation.");
        }

		/* Loop through all digits in number and create a new Digit for this */
        copyFromNumber(number);

    }

    /**
     * Parse a string and generate an Integer from the digits.
     *
     * @param number String representation of the number to be stored in this.
     * @throws DigitException If one of the digits in number is non-numeric.
     */
    public Integer(final String number) throws DigitException {

        initNaturalNumber();

        if (number == null) {
            throw new NullPointerException("Cannot construct a WholeNumber from a null representation.");
        }

        // Parameter number is final; must create a local copy to modify in the case of the number to parse being negative
        String numberToParse = number;

        // Pull off the negative sign if it exists before parsing the number
        if (number.charAt(0) == '-') {
            this.sign = -1;
            numberToParse = number.substring(1, number.length());
        }

        super.parseStringRep(numberToParse);

        // Zero is a positive number, so '-0' and '0' will both evaluate to '0'
        if (isZero()) {
            this.sign = 1;
        }

    }

    @Override
    public int compareTo(final number.Number number) {

        // Call the super comparison.
        final int naturalNumberComparison = super.compareTo(number);
        int returnVal = 0;

        if (number instanceof NaturalNumber) { // sign has not yet been checked
            if (this.isPositive()) {
                if (((NaturalNumber) number).isPositive()) {
                    returnVal = naturalNumberComparison;
                } else { // this is positive but number is negative
                    returnVal = 1;
                }
            } else {
                if (number instanceof Integer && !((Integer) number).isPositive()) {
                    returnVal = naturalNumberComparison * -1; // larger digits when negative means smaller number
                } else { // this is negative and number is positive
                    returnVal = -1;
                }
            }
        }

        return returnVal;

    }

    @Override
    public boolean isPositive() {
        return this.sign > 0;
    }

    @Override
    public String toString() {
        return String.format("%s%s", isPositive() ? "" : "-", super.toString());
    }

}
