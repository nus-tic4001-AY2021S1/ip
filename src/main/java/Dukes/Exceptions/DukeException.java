package Dukes.Exceptions;
/**
 * Represents a checked exception.
 * A <code>DukeException</code> object corresponds to an exception that is thrown when user inputs are invalid or contain
 * the wrong format.
 */
public class DukeException extends Exception {
        public DukeException(String message) {
            super(message);
        }
    }