package duke.tasks;


import java.util.Comparator;

// An abstract class
public abstract class Task  implements Comparable<Task> {
    // A String that holds the description of a task
    protected String description;
    // A boolean value, if true: the task is completed, otherwise false.
    protected boolean isDone;



    /** .
     * Creating an object of Task class
     *
     * @param description A String that holds the description of a task
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /** .
     * A method to get the Task Status Icon
     *
     * @return a String containing the icon: tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        //(isDone ? "\u2713" : "\u2718", return tick or X symbols . (isDone ? "Tick" : "X");
    }

    /** .
     * A method to get the Task description
     *
     * @return a String containing the description of task
     */
    public String getDescription() {
        return description;
    }

    /** .
     * A method to set the Task as done/completed
     */
    public void setDone() {
        isDone = true;
    }



    /** .
     *
     * @return declare is done status.
     */
    public boolean isDone() {
        return isDone;
    }

    /** .
     * A method to get the Task data as formatted string to display both task status and task description
     *
     * @return a formatted String of task status and task description
     */

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }



    @Override
    public int compareTo(Task task) {
        return Comparator
                .comparing(Task::getStatusIcon)
                .thenComparing(Task::getDescription)
                .compare(this, task);
    }



}
