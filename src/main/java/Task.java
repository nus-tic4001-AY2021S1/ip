/**
 * A class for tasks.
 */
class Task {
    String task;
    private boolean isDone;

    Task(String input) {
        task = input;
    }

    void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    boolean getDone() {
        return isDone;
    }

    String getTaskStatus(Boolean isDone) {
        return "[" + (isDone ? "\u2713" : "\u2718") + "] "; //return tick or X symbols
    }
    String getDescription() {
        return getTaskStatus(isDone) + task;
    }
}