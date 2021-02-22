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
     * Prints "Your task?"
     *
     * @return the line read in after trimming trailing and leading spaces
     */
    public String readUserCommand() {

        return in.nextLine().trim();
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

    /**
     * @param task
     * @param type
     */
    public static String printTask(Task task, Constants.TaskDisplayType type) {
        String output = "";
        String dukeResponse = "";

        if (type.equals(Constants.TaskDisplayType.DONE)) {
            dukeResponse = Constants.ACKNOWLEDGEMENT_AS_DONE;

        } else if (type.equals(Constants.TaskDisplayType.ADD)) {
            dukeResponse = Constants.ACKNOWLEDGEMENT;

        } else {
            dukeResponse = Constants.ACKNOWLEDGEMENT_AS_UNDONE;
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
     * Displays to user the message passed in.(Line by line)
     *
     * @param message
     */
    public static void showToUser(String message) {
        System.out.println(message);
    }

    /**
     * Display to user the message passed in.(No new line)
     *
     * @param message
     */
    public static void showToUserNoNewLine(String message) {
        System.out.print(message);
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
