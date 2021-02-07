package duke.task;

/**
 * An abstract class that is inherited by the duke.task.Todo, duke.task.Deadline and duke.task.Event classes.
 */

public abstract class Task {
    String task;
    private boolean isDone;
    private String note;

    Task(String input) {
        task = input;
    }

    public void setDone() {
        this.isDone = true;
    }

    String getDone(Boolean isDone) {
        return "[" + (isDone ? "D" : "X") + "] ";
    }

    String getNote() {
        if (note == null) {
            return "";
        }
        return "\r       [Note]     " + note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return getDone(isDone) + task + getNote();
    }
}