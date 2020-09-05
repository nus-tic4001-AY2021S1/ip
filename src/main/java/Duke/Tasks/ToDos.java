package Duke.Tasks;

public class ToDos extends Task {

    /**
     * @param taskDescription create a ToDos task with description of the task
     */
    public ToDos(String taskDescription) {
        super(taskDescription);
        super.taskType = "[T]";
    }

}
