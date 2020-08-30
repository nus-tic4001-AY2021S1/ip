package Tasks;

import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setDone(){
        this.isDone = true;
    }
    public static void markAsDone(int arrayIndex) {
        ArrayList<Task> tasks = new ArrayList<>();
        Task task = tasks.get(arrayIndex);
        task.setDone();
        System.out.println("     Nice! I've marked this task as done:\n"
                + task
                + "\n"
                + "___________________________________________________________________\n");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

