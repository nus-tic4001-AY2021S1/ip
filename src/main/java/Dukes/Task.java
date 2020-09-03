package Dukes;

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

    public void setDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
    public static void markDone(int arrayIndex) {
        ArrayList<Task> tasks = new ArrayList<>();
        Task task = tasks.get(arrayIndex);
        task.setDone();
        System.out.println("     Nice! I've marked this task as done:\n"
                + task
                + "\n"
                + "___________________________________________________________________\n");
    }

    public static void markAsDone(String input) {
        try {
            if (input.length() < 6) {
                throw new DukeException("please key in correct format.");
            } else {
                String listActionIndex = (input.split(" "))[1];
                int arrayIndex = Integer.parseInt(listActionIndex) - 1;
                markDone(arrayIndex);
            }
        }catch (DukeException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please key in a number from the list.");
        }
    }
}



