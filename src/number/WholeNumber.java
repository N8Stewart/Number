package number;

import number.exception.DigitException;

public class WholeNumber extends NaturalNumber {

    /**
     * Parse a string and generate a WholeNumber from the digits.
     *
     * @param number String representation of the number to be stored in this.
     * @throws DigitException If one of the digits in number is non-numeric.
     */
    public WholeNumber(String number) throws DigitException {

        super();

        if (number == null) {
            throw new NullPointerException("Cannot construct a WholeNumber from a null representation.");
        }

        int i = 0;

		/* Filter all leading 0's off of number */
        while (i < number.length() && number.charAt(i) == '0') {
            i++;
        }

		/* If index is out of bounds, put it back in bounds. Last digit must be a 0 to reach inside this clause. */
        if (i >= number.length()) {
            i--;
        }

		/* Attempt to construct the WholeNumber based on the string representation number */
        for (; i < number.length(); i++) {
            this.digits.add(new Digit(number.charAt(i)));
        }

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

}
