package ui;

import Duke.Task;

import java.util.List;
import java.util.Scanner;

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
     * Prints "Welcome to Duke :D".
     */
    public static void printWelcome() {
        System.out.print(Constants.GREETING);
    }

    public static void printGoodBye() {

        System.out.println(Constants.FAREWELL);
    }

    public void printTasks(List<Task> tasks) {
        System.out.println(Constants.H_LINE);
        System.out.println(Constants.DISPLAY_TASK_LIST);
        int i = 1;
        for (Task t : tasks) {
            if (t.getClass().toString().contains("main.java.Duke.Todo")) {
                System.out.println(i + "." + "[T] " + t);

            } else if (t.getClass().toString().contains("main.java.Duke.Deadline")) {
                System.out.println(i + "." + "[D] " + t);

            } else {
                System.out.println(i + "." + "[E] " + t);
            }
            i++;
        }
        System.out.println(Constants.H_LINE);
    }

    public static void printNumberOfTasks(int taskListSize) {
        //return "Tasks in the list: " + tasks.size();
        System.out.println(String.format(Constants.NUMBER_OF_TASKS, taskListSize));
    }

    public void printTaskAddAck(Task task, int taskListSize) {
        System.out.println(Constants.H_LINE);
        System.out.println(Constants.ACKNOWLEDGEMENT);
        if (task.getClass().toString().contains("main.java.Duke.Todo")) {
            System.out.println("[T] " + task);

        } else if (task.getClass().toString().contains("main.java.Duke.Deadline")) {
            System.out.println("[D] " + task);

        } else {
            System.out.println("[E] " + task);
        }
        printNumberOfTasks(taskListSize);
        System.out.println(Constants.H_LINE);
    }

    public void printTaskMarkedAsDone(Task task) {
        System.out.println(Constants.H_LINE);
        System.out.println(Constants.ACKNOWLEDGEMENT_AS_DONE);
        if (task.getClass().toString().contains("main.java.Duke.Todo")) {
            System.out.println("[T] " + task);

        } else if (task.getClass().toString().contains("main.java.Duke.Deadline")) {
            System.out.println("[D] " + task);

        } else {
            System.out.println("[E] " + task);
        }
        System.out.println(Constants.H_LINE);
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

    public static void helpMessage() {
        String helpMessage = String.format("\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n",
                Constants.TODO, Constants.TODO_HELP_STATEMENT,
                Constants.DEADLINE, Constants.DEADLINE_HELP_STATEMENT,
                Constants.PRINT, Constants.PRINT_HELP_STATEMENT,
                Constants.DONE, Constants.DONE_HELP_STATEMENT,
                Constants.EXIT, Constants.EXIT_HELP_STATEMENT);

        System.out.println(helpMessage);
    }
}
