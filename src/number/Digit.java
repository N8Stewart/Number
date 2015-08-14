package number;

import number.exception.DigitException;

import java.io.Serializable;

/**
 * Class to hold the most basic structure of the Number classes.
 * Every number constructed is built of 1 or more Digits.
 */
public class Digit implements Serializable, Comparable<Digit> {

    /**
     * @version 0.0.2
     * @date 01/26/15
     * @date_modified 04/11/15
     * @author Nate Stewart
     */
    private static final long serialVersionUID = -2558809815394788936L;

    /*
     * Store the numeric value of digit as a character.
     */
    private char digit;

    /**
     * Construct a Digit object and set the value to '0'.
     */
    public Digit() {

        this.digit = '0';

    }

    /**
     * Copy the value of digit into this.
     *
     * @param digit Digit to be copied into this. If empty/null, set this to '0'.
     */
    public Digit(final Digit digit) {

        if (digit == null) {
            this.digit = '0';
        } else {
            this.digit = digit.digit;
        }

    }

    /**
     * Attempts to instantiate Digit with a numeric value between 0-9.
     *
     * @param digit character value to instantiate Digit.
     * @throws DigitException if digit is not a numerical character, 0-9.
     */
    public Digit(final char digit) throws DigitException {

        if (isDigit(digit))
            this.digit = digit;
        else
            throw new DigitException();

    }

    /**
     * Attempts to instantiate Digit with a numeric value between 0-9.
     *
     * @param digit integer value to instantiate Digit.
     * @throws DigitException if digit is not a numerical character, 0-9.
     */
    public Digit(final int digit) throws DigitException {

        if (isDigit(digit))
            this.digit = Character.forDigit(digit, 10);
        else
            throw new DigitException();

    }

    /**
     * Get the character representation of this Digit.
     *
     * @return a character between 0-9
     */
    public char getDigit() {

        return this.digit;

    }

    /**
     * Set the value of the Digit to digit.
     *
     * @param digit Numerical character between 0 and 9 inclusive.
     * @throws DigitException if digit is not a numerical character, 0-9.
     */
    public void setDigit(final char digit) throws DigitException {

        if (isDigit(digit))
            this.digit = digit;
        else
            throw new DigitException();

    }

    /**
     * Copy the value of digit into this.
     *
     * @param digit Digit to be copied into this. If empty/null, set this to '0'.
     */
    public void setDigit(final Digit digit) {

        if (digit == null) {
            this.digit = '0';
        } else {
            this.digit = digit.digit;
        }


    }

    /**
     * Checks if this Digit is zero.
     *
     * @return true if this Digit is zero, false otherwise.
     */
    public boolean isZero() {

        return this.digit == '0';

    }

    /**
     * Check if the character is a numeric value between 0-9.
     *
     * @param digit value to be checked to ensure it is between 0-9
     * @return true if value is a numerical digit, false otherwise.
     */
    public static boolean isDigit(final char digit) {

		/* ASCII code 48 is '0', code 57 is '9' */
        return digit >= 48 && digit <= 57;

    }

    /**
     * Check if the character is a number between 0 and 9
     *
     * @param digit value to be checked to ensure it is between 0-9
     * @return true if value is a numerical digit, false otherwise.
     */
    public static boolean isDigit(final int digit) {

		/* If int is >= 0 and <= 9, it is a digit */
        return digit >= 0 && digit <= 9;

    }

    /**
     * Check if this digit is even or not.
     *
     * @return true if this digit is even, false if it is odd
     */
    public boolean isEven() {

		/* Even digits character values end in an even value. e.g. 0 == '48, 2 == '50 */
        return ((int) this.digit) % 2 == 0;

    }

    /**
     * Compare digit to this.
     *
     * @param digit the digit for this to be compared to
     * @return 0 if digit = this || < 0 if digit > this || > 0 if digit < this
     */
    @Override
    public int compareTo(final Digit digit) {

        if (digit == null) {
            throw new NullPointerException("Cannot compare this to null.");
        }

        // compare two digits by subtracting the parameter digit from this.digit
        return (this.digit - digit.digit);
    }

    /**
     * Return a string representation of this digit
     *
     * @return string representation of this
     */
    @Override
    public String toString() {
        return String.format("%c", this.digit);
    }

}
