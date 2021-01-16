package duke.exceptions;

public class DukeException extends Exception {
    /**
     * @param message create a customized exception with certain message
     */
    public DukeException(String message) {
        super(message);
    }
}
