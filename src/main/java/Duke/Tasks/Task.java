package Duke.Tasks;

public abstract class Task {
    protected String taskType;
    protected boolean isDone = false;
    protected String taskDescription;
    protected String taskSymbol = "[✗]";

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return taskType + taskSymbol + " " + taskDescription;
    }

    public void setDone(boolean done) {
        this.isDone = done;
        setSymbol();
    }

    private void setSymbol() {
        if (isDone) {
            this.taskSymbol = "[✓]";
        } else {
            this.taskSymbol = "[✗]";
        }
    }
}
