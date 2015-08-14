package number.exception;

/**
 * Class to display an error when an attempt to instantiate a NaturalNumber is made.
 */
public class NaturalNumberException extends NumberException {

    /**
     * @version 0.0.2
     * @date 01/27/15
     * @author Nate Stewart
     */
    private static final long serialVersionUID = 1628475392609841364L;

    /* Message to replace the generic Exception message with */
    private static final String DEFAULT_MESSAGE = "Number is not a Natural Number";

    /**
     * Raise an exception without providing a message. Use default message.
     */
    public NaturalNumberException() {
        super(NaturalNumberException.DEFAULT_MESSAGE);
    }

    /**
     * Raise an exception and provide a message to be used in the output.
     *
     * @param message stored for later use when getMessage() is called.
     */
    public NaturalNumberException(String message) {
        super(message);
    }

}
