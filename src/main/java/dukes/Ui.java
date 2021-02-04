package dukes;

import dukes.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a UI class to manage user interface for users and handles interaction between the user.
 */
public class Ui {
    private final Scanner in = new Scanner(System.in);

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

    /**
     * Prints the bye message and the list that will be save in hard disk when the user exits the program.
     * @param task the list of task that will be saved.
     * @return the list of task and the goodbye message will be show.
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
     * @param s the string of the message.
     */
    public void printLoadingError(String s) {
        System.out.println(s);
    }


    public static int indexDetails(String input) {
        return Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
    }

    /**
     * Prints the message to inform user of a successful addition of a task to the list.
     * @param task Task that has been added.
     * @param numberOfTasks Number of tasks currently in the list.
     * @return a message to add in the task.
     */
    public String printAddedMessage(Task task, int numberOfTasks) {
        return "Got it. I've added this task: \n"
                + task
                + "\n Now you have "
                + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks")
                + " in the list.";
    }

    /**
     * Prints the message to inform user of a successful deletion.
     * @param task Task that has been deleted.
     * @param numberOfTasks Number of tasks left in the list.
     * @return a message for remove the a task.
     */
    public String printDeleteMessage(Task task, int numberOfTasks) {
        return "Noted. I've removed this task: \n"
                + task
                + "\nNow you have "
                + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks")
                + " in the list.";
    }

    /**
     * Prints the message to inform user that a task has been successfully marked as done.
     * @param task Task that has been marked as done.
     * @return a message to show the done task.
     */
    public String printDoneMessage(Task task) {
        return "Nice! I've marked this task as done:\n"
                + task;
    }

    public String indentPrint(String toPrint) {
        return " " + toPrint + "" + "\n";
    }

    public String showHelp() {
        return "Use following commands to control me:\n"
                + "\t- todo [desc]\n"
                + "\t- event [desc] /at [date time]\n"
                + "\t- deadline [desc] /by [date time]\n"
                + "\t- list\n"
                + "\t- done [task number]\n"
                + "\t- bye|exit (exits duke)\n"
                + "\t- find [keyword]\n"
                + "\t* date format - DD/MM/YYYY \n"
                + "\t* time format - HHmm";
    }

}

