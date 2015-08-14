package number.exception;

/**
 * Class to display an error when an attempt to make a Digit is made using non-numeric character.
 */
public class DigitException extends NumberException {

    /**
     * @version 0.0.2
     * @date 01/27/15
     * @author Nate Stewart
     */
    private static final long serialVersionUID = 1784192102822240346L;

    /**
     * Message to replace the generic Exception message with
     */
    private static final String DEFAULT_MESSAGE = "Character is not a digit.";

    /**
     * Raise an exception without providing a message. Use default message.
     */
    public DigitException() {
        super(DigitException.DEFAULT_MESSAGE);
    }

    /**
     * Raise an exception and provide a message to be used in the output.
     *
     * @param message stored for later use when getMessage() is called.
     */
    public DigitException(String message) {
        super(message);
    }

}