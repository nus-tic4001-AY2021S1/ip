package Tasks;

public class Todo extends Task {
    /**
     * Creating an object of Todo class
     *
     * @param description A String that holds the description of a task
     */
    public Todo(String description) {
        super(description);
    }


    /**
     * A method to get the Task data as formatted string to display task type [T], task status and task description
     *
     * @return a formatted String of task type [T], task status and task description
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }


}
