package Duke.Tasks;

public abstract class Task {
    protected String taskType;
    protected boolean isDone = false;
    protected String taskDescription;
    protected String taskSymbol = "[✗]";

    /**
     * @param taskDescription Description on the task detail.
     */
    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * @return convert the task to a readable string
     */
    @Override
    public String toString() {
        return taskType + taskSymbol + " " + taskDescription;
    }

    /**
     * @param done set the task done status
     */
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

    public String toSavingString(){
        String doneStatus = isDone?"1":"0";
        return taskType.charAt(1) + "|"+ doneStatus + "|" +taskDescription;
    }

    public String getTaskDescription(){
        return this.taskDescription;
    }
}
