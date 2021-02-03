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
        showLine();
        System.out.println("Hello! I'm Dukes\nWhat can I do for you?\n");
        showLine();

    }

    public String greetMessage() {
        return "Hello! I'm Duke.\nWhat can I do for you?";
    }

    /**
     * Prints the bye message and the list that will be save in hard disk when the user exits the program.
     */
    public String showExitMessage(ArrayList<Task> task) {
        System.out.println("Your following tasks will be save: ");
        for (Task t : task) {
            System.out.println(t);
        }
        return ("Bye. Hope to see you again soon!");
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
    public String printAddedMessage(Task task, int numberOfTasks) {
        StringBuilder msg = new StringBuilder();
        msg.append("Got it. I've added this task: \n"
                + task);
        msg.append("\n Now you have "
                + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks")
                + " in the list.");
        return msg.toString();
    }

    /**
     * Prints the message to inform user of a successful deletion.
     * @param task Task that has been deleted.
     * @param numberOfTasks Number of tasks left in the list.
     */
    public String printDeleteMessage(Task task, int numberOfTasks) {
        StringBuilder msg = new StringBuilder();
        msg.append("Noted. I've removed this task: \n"
                + task);
        msg.append("\nNow you have "
                + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks")
                + " in the list.");
        return msg.toString();
    }

    /**
     * Prints the message to inform user that a task has been successfully marked as done.
     * @param task Task that has been marked as done.
     */
    public String printDoneMessage(Task task) {
        StringBuilder msg = new StringBuilder();
        msg.append("Nice! I've marked this task as done:\n"
                + task);
        return msg.toString();
    }

    public String indentPrint(String toPrint) {
        return " " + toPrint + "" + "\n";
    }

}

