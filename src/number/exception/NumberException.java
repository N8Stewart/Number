package number.exception;

/**
 * Generic exception to overwrite generic Exception class.
 */
public class NumberException extends Exception {

    /**
     * @version 0.0.1
     * @date 01/27/15
     * @author Nate Stewart
     */
    private static final long serialVersionUID = -5414363344388311103L;
    /**
     * Default message of the class to be used when exception is raised without a message.
     */
    private static final String DEFAULT_MESSAGE = "Number Exception.";

    /**
     * Raise an exception without providing a message. Use default message.
     */
    public NumberException() {
        super(NumberException.DEFAULT_MESSAGE);
    }

    /**
     * Raise an exception and provide a message to be used in the output.
     *
     * @param message stored for later use when getMessage() is called.
     */
    public NumberException(String message) {
        super(message);
    }

}
