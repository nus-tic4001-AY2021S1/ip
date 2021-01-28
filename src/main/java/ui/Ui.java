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

    public void endInputFeed() {
        in.close();
    }

    /**
     * Prints "Welcome to Duke".
     */
    public static void printWelcome() {
        System.out.print(Constants.GREETING);
    }

    /**
     * Prints Farewell message
     */
    public static void printGoodBye() {
        System.out.println(Constants.FAREWELL);
    }

    /**
     * Prints each task with formatting.
     * @param tasks
     */
    public void printTasks(List<Task> tasks) {
        System.out.println(Constants.H_LINE);
        System.out.println(Constants.DISPLAY_TASK_LIST);
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
     * Print the tasks with formatting for searched tasks.
     * @param tasks
     */
    public void printFoundTasks(List<Task> tasks) {
        System.out.println(Constants.H_LINE);
        System.out.println(Constants.FOUND_MATCHING_TASKS);
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
     * @param taskListSize
     */
    public static void printNumberOfTasks(int taskListSize) {
        //return "Tasks in the list: " + tasks.size();
        System.out.println(String.format(Constants.NUMBER_OF_TASKS, taskListSize));
    }

    /**
     *
     * @param task
     * @param type
     */
    public void printTask(Task task, Constants.TaskDisplayType type) {
        System.out.println(Constants.H_LINE);

        if (type.equals(Constants.TaskDisplayType.DONE)) {
            System.out.println(Constants.ACKNOWLEDGEMENT_AS_DONE);

        } else if (type.equals(Constants.TaskDisplayType.ADD)) {
            System.out.println(Constants.ACKNOWLEDGEMENT);

        } else {
            System.out.println(Constants.ACKNOWLEDGEMENT_AS_UNDONE);
        }

        if (task.getClass().toString().contains("Todo")) {
            System.out.println("[T] " + task);

        } else if (task.getClass().toString().contains("Deadline")) {
            System.out.println("[D] " + task);

        } else {
            System.out.println("[E] " + task);
        }
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
    public static void printError(String message) {
        System.out.println(message);
    }

    /**
     * Prints the help message.
     */
    public static void helpMessage() {
        String helpMessage = String.format("\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n",
                Constants.TODO, Constants.TODO_HELP_STATEMENT,
                Constants.DEADLINE, Constants.DEADLINE_HELP_STATEMENT,
                Constants.PRINT, Constants.PRINT_HELP_STATEMENT,
                Constants.DONE, Constants.DONE_HELP_STATEMENT,
                Constants.REMOVE, Constants.REMOVE_HELP_STATEMENT,
                Constants.EXIT, Constants.EXIT_HELP_STATEMENT);

        System.out.println(helpMessage);
    }
}
