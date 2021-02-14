package duke.tasks;

public abstract class Task extends Tag {
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

    /**
     * @return a saving method used to save string
     */
    public String toSavingString() {
        String doneStatus = isDone ? "1" : "0";
        //check whether got tag info
        //using different return
        return taskType.charAt(1) + "|" + doneStatus + "|" + taskDescription;
    }

    /**
     * @return a saving method used to save string
     */
    public String toSavingStringWithTag() {
        String doneStatus = isDone ? "1" : "0";
        //check whether got tag info
        //using different return
        return taskType.charAt(1) + "|" + doneStatus + "|" + taskDescription + "|" + this.toTagsString();
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }
}
