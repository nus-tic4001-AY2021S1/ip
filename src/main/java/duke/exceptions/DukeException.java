package duke.exceptions;

public class DukeException extends Exception {

    /** .
     * A Exception to show the error message
     *
     * @param message A String that holds the user input.
     */
    public DukeException(String message) {
        super(message);
    }
}
