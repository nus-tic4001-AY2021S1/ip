package duke.task;
/**
 * An abstract class that is inherited by the duke.task.Todo, duke.task.Deadline and duke.task.Event classes.
 */
public abstract class Task {
    String task;
    private boolean isDone;

    Task(String input) {
        task = input;
    }

    public void setDone() {
        this.isDone = true;
    }

    String getTaskStatus(Boolean isDone) {
        return "[" + (isDone ? "\u2713" : "\u2718") + "] "; //return tick or X symbols
    }

    public String getDescription() {
        return getTaskStatus(isDone) + task;
    }
}