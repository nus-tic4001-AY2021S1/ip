package Tasks;
//A-Packages: Organize into Packages named Tasks
//A-AbstractClasses:abstract class Task declares some methods that it implements here, and some that are implemented by the subclasses.
public class Task {
    // A String that holds the description of a task
    protected String description;
    // A boolean value, if true: the task is completed, otherwise false.
    protected boolean isDone;

    /**
     * Creating an object of Task class
     *
     * @param description A String that holds the description of a task
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * A method to get the Task Status Icon
     *
     * @return a String containing the icon: tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * A method to get the Task description
     *
     * @return a String containing the description of task
     */
    public String getDescription() {
        return description;
    }

    /**
     * A method to set the Task as done/completed
     */
    public void setDone() {
        isDone = true;
    }


    /**
     *
     * @return declare is done status
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * A method to get the Task data as formatted string to display both task status and task description
     *
     * @return a formatted String of task status and task description
     */

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }


}
