package duke.exception;
/**
 * Inherits the Exception class.
 * Overrides the constructor that takes a String parameter with custom error information
 * when you create a TaskManagerException object.
 * Throw a new TaskManagerException object when you detect some necessary information
 * is missing in the command.
 * Catch that exception somewhere else and print the message inside the exception object.
 */

public class DukeException extends Exception {
    public DukeException(String input) {
        super(input);
    }
}