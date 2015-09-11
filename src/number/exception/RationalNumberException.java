package number.exception;

/**
 * Class to display an error when an attempt to instantiate a RationalNumber is made.
 */
public class RationalNumberException extends NumberException {

    /**
     * @version 0.0.2
     * @date 09/10/15
     * @author Nate Stewart
     */
    private static final long serialVersionUID = 1628475392609841364L;

    /* Message to replace the generic Exception message with */
    private static final String DEFAULT_MESSAGE = "Number is not a Rational Number";

    /**
     * Raise an exception without providing a message. Use default message.
     */
    public RationalNumberException() {
        super(RationalNumberException.DEFAULT_MESSAGE);
    }

    /**
     * Raise an exception and provide a message to be used in the output.
     *
     * @param message stored for later use when getMessage() is called.
     */
    public RationalNumberException(String message) {
        super(message);
    }

}