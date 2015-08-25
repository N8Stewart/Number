package number.attribute;

/**
 * Interface to control whether a number is positive or not. Some numbers, such as complex numbers are neither positive
 * or negative so it would be wrong to call 'isPositive' on a complex number.
 */
public interface Positivity {

    /**
     * @return true if this number is positive or 0; false otherwise.
     */
    boolean isPositive();

}
