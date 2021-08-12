package task;

public class ToDos extends Tasks {
    /**
     * @param description todo task description
     */
    public ToDos(String description) {
        super(description);
        super.type = "[T]";
    }
}
