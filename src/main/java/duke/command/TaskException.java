package duke.command;

// using A Exceptions to throw error
public class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }
}