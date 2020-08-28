package Duke.ui;

import Duke.task.Task;
import Duke.tasklist.TaskList;

import java.util.List;
import java.util.Scanner;

import static Duke.constants.Constants.*;

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
//        System.out.print("Your task? ");
        return in.nextLine().trim();
    }

    /**
     * Prints "Welcome to Task Manager :D".
     */
    public static void printWelcome() {
        System.out.print(greeting);
    }

    public static void printGoodBye() {
//        System.out.println("\nGoodbye, see you soon!");
        System.out.println(farewell);
    }

    public void printTasks(List<Task> tasks) {
        System.out.println(hLine);
        System.out.println(displayTaskList);
        int i = 1;
        for (Task t : tasks) {
            if (t.getClass().toString().contains("Duke.task.Todo")) {
                System.out.println(i + "." + "[T] " + t);

            } else if (t.getClass().toString().contains("Duke.task.Deadline")) {
                System.out.println(i + "." + "[D] " + t);

            } else {
                System.out.println(i + "." + "[E] " + t);
            }
            i++;
        }
        System.out.println(hLine);
    }

    public static void printNumberOfTasks(int taskListSize) {
//        return "Tasks in the list: " + tasks.size();
        System.out.println(String.format(numberOfTasks, taskListSize));
    }

    public void printTaskAddAck(Task task, int taskListSize) {
        System.out.println(hLine);
        System.out.println(acknowledgement);
        if (task.getClass().toString().contains("Duke.task.Todo")) {
            System.out.println("[T] " + task);

        } else if (task.getClass().toString().contains("Duke.task.Deadline")) {
            System.out.println("[D] " + task);

        } else {
            System.out.println("[E] " + task);
        }
        System.out.println(String.format(numberOfTasks, taskListSize));
        System.out.println(hLine);
    }

    public void printTaskMarkedAsDone(Task task) {
        System.out.println(hLine);
        System.out.println(acknowledgementAsDone);
        if (task.getClass().toString().contains("Duke.task.Todo")) {
            System.out.println("[T] " + task);

        } else if (task.getClass().toString().contains("Duke.task.Deadline")) {
            System.out.println("[D] " + task);

        } else {
            System.out.println("[E] " + task);
        }
        System.out.println(hLine);
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
                TODO, TODO_HELP_STATEMENT,
                DEADLINE, DEADLINE_HELP_STATEMENT,
                PRINT, PRINT_HELP_STATEMENT,
                DONE, DONE_HELP_STATEMENT,
                EXIT, EXIT_HELP_STATEMENT);

        System.out.println(helpMessage);
    }
}
