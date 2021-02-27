package duke.command;

/**
 *This Exceptions class is to throw project run time error.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
// using A Exceptions to throw error
public class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }
}