package duke.task;

/**
 * This class to create task object.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * entity task.
     *
     * @param description user tasks description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * This function is get done or noe statues icon symbols
     *
     * @return tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * This constructs s setDone with is done
     *
     * @param isDone set status done
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * This constructs return description
     *
     * @return user command description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Abstarct the toString method
     *
     * @return void
     */
    public abstract String toString();

    /**
     * print the user command with status icon
     *
     * @return user command with status icon
     */
    public String printDescription() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }

    /**
     * set user command to isDone
     *
     * @return user command status
     */
    public boolean isDone() {
        return isDone;
    }

}