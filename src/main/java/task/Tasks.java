package task;

/**
 * This is a abstract task class
 */
public abstract class Tasks {
    protected String type;
    protected String description;
    protected String statusIcon;
    protected boolean isDone;

    /**
     * @param description task description
     */
    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
        this.statusIcon = "[✗]";
    }

    public String getTaskDescription() {
        return description;
    }

    public String getTaskStatus() {
        if (isDone == true) {
            return "[✓]";
        } else {
            return "[✗]";
        }
    }

    public void setTaskStatus(boolean status) {
        this.isDone = status;
        setTaskStatusIcon();

    }

    public void setTaskStatusIcon() {
        if (isDone) {
            this.statusIcon = "[✓]";
        } else {
            this.statusIcon = "[✗]";
        }
    }

    /**
     * @return a string of task with index, description and status
     */
    public String saveToString() {
        String doneStatus = isDone ? "1" : "0";
        return type.charAt(1) + "|" + doneStatus + "|" + description;
    }

    @Override
    public String toString() {
        return type + statusIcon + " " + description;
    }
}
