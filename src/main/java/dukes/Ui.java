package dukes;

import dukes.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a UI class to manage user interface for users and handles interaction between the user.
 */
public class Ui {
    private Scanner in = new Scanner(System.in);

    /**
     * Reads user input.
     * @return User input.
     */
    public String readCommand() {
        return in.nextLine();
    }

    public Ui() {
    }

    public void showLine() {
        System.out.println("____________________________________________________________\n");
    }

    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Prints the Dukes.Duke logo and greets the user for the first time the program is run.
     */
    public void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Dukes\nWhat can I do for you?\n");

    }

    /**
     * Prints the bye message and the list that will be save in hard disk when the user exits the program.
     */
    public void showExitMessage(ArrayList<Task> task) {

        System.out.println("Your following tasks will be save: ");
        for (Task t : task) {
            System.out.println(t);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the error when the information in storage could not be loaded.
     */
    public void printLoadingError(String s) {
        System.out.println(s);
    }


    public static int indexDetails(String input) {
        int number = Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
        return number;
    }

    /**
     * Prints the message to inform user of a successful addition of a task to the list.
     * @param task Task that has been added.
     * @param numberOfTasks Number of tasks currently in the list.
     */
    public void printAddedMessage(Task task, int numberOfTasks) {
        System.out.println("Got it. I've added this task: \n"
                + task);
        System.out.println("Now you have "
                + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks")
                + " in the list.");
    }

    /**
     * Prints the message to inform user of a successful deletion.
     * @param task Task that has been deleted.
     * @param numberOfTasks Number of tasks left in the list.
     */
    public void printDeleteMessage(Task task, int numberOfTasks) {
        System.out.println("Noted. I've removed this task: \n"
                + task);
        System.out.println("Now you have "
                + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks")
                + " in the list.");
    }

    /**
     * Prints the message to inform user that a task has been successfully marked as done.
     * @param task Task that has been marked as done.
     */
    public void printDoneMessage(Task task) {
        System.out.println("Nice! I've marked this task as done:\n"
                + task);
    }
}

