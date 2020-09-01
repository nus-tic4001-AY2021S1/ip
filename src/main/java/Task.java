class Task {
    String description;
    boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    void markAsDone(){
        isDone = true;
    }

    String getDescription(){
        return this.description;
    }

    String taskToString(){
        return "["+getStatusIcon()+"]" + " " + getDescription();
    }
}