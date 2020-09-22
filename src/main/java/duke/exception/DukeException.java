package duke.exception;

/**
 * Overrides the Exception class's constructor to implement
 * custom error messages for user-defined exceptions.
 */
public class DukeException extends Exception {
    public DukeException(String errorMessage) {
        super(errorMessage);
    }
}