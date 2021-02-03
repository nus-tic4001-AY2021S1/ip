package duke.tasks;

public class ToDos extends Task {

    /**
     * @param taskDescription create a ToDos task with description of the task
     */
    public ToDos(String taskDescription) {
        super(taskDescription);
        super.taskType = "[T]";
    }

    @Override
    public String toString() {
        if (existTags()) {
            return super.toString() + System.lineSeparator() + printTags();
        }
        return super.toString();
    }
}
