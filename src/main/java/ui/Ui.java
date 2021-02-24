package ui;

import java.util.List;
import java.util.Scanner;

import data.Task;


public class Ui {

    private Scanner in;

    /**
     * Constructor takes in user input
     */
    public Ui() {
        in = new Scanner(System.in);
    }

    /**
     * Prints each task with formatting.
     *
     * @param tasks
     */
    public static String printTasks(List<Task> tasks) {
        String tasksList = "";
        int i = 1;
        for (Task t : tasks) {
            if (t.getClass().toString().contains("Todo")) {
                tasksList = tasksList + " " + i + "." + "[T] " + t + "\n";

            } else if (t.getClass().toString().contains("Deadline")) {
                tasksList = tasksList + " " + i + "." + "[D] " + t + "\n";


            } else {
                tasksList = tasksList + " " + i + "." + "[E] " + t + "\n";

            }
            i++;
        }
        return String.format(Constants.DISPLAY_TASK_LIST + "\n" + Constants.H_LINE + "\n" + tasksList + "\n"
                + Constants.H_LINE);
    }

    /**
     * Print the tasks with formatting for searched tasks.
     *
     * @param tasks
     */
    public void printFoundTasks(List<Task> tasks) {
        System.out.println(Constants.H_LINE);

        int i = 1;
        for (Task t : tasks) {
            if (t.getClass().toString().contains("Todo")) {
                System.out.println(i + "." + "[T] " + t);


            } else if (t.getClass().toString().contains("Deadline")) {
                System.out.println(i + "." + "[D] " + t);


            } else {
                System.out.println(i + "." + "[E] " + t);

            }
            i++;
        }
    }

    /**
     * Prints the number of tasks.
     *
     * @param taskListSize
     */
    public static String printNumberOfTasks(int taskListSize) {
        //return "Tasks in the list: " + tasks.size();
        return String.format(Constants.NUMBER_OF_TASKS, taskListSize);
    }

    /** Prints the tasks.
     * @param task
     * @param type
     */
    public static String printTask(Task task, Constants.TaskDisplayType type) {
        String output = "";
        String dukeResponse = "";

        switch(type) {

        case DONE:
            dukeResponse = Constants.ACKNOWLEDGEMENT_AS_DONE;
            break;

        case UNDONE:
            dukeResponse = Constants.ACKNOWLEDGEMENT_AS_UNDONE;
            break;

        case ADD:
            dukeResponse = Constants.ACKNOWLEDGEMENT;
            break;

        case TAGGED:
            dukeResponse = Constants.ACKNOWLEDGEMENT_AS_TAG_SET;
            break;

        case UNTAGGED:
            dukeResponse = Constants.ACKNOWLEDGEMENT_AS_TAG_UNSET;
            break;

        default:
            break;
        }

        if (task.getClass().toString().contains("Todo")) {
            output = String.format(dukeResponse + "\n" + "[T] " + task);

        } else if (task.getClass().toString().contains("Deadline")) {
            output = String.format(dukeResponse + "\n" + "[D] " + task);

        } else {
            output = String.format(dukeResponse + "\n" + "[E] " + task);
        }
        return output;
    }

    /**
     * Displays to user the error message passed in
     * Not to be confused with showToUser().
     *
     * @param message
     */
    public static String printError(String message) {
        return message;
    }
}
