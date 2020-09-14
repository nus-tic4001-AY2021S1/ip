package Dukes;

/**
 * Represents a todo task.
 * An <code>Todo</code>object corresponds to a type of <code>Task<code> object with a task to be completed.
 */
public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toWriteFile() {
        return "T | " + getFileStatusIcon() + " | " + description;
    }



}
