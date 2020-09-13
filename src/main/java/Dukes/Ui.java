package Dukes;

import java.util.ArrayList;
import java.util.Scanner;


public class Ui {
    private Scanner in = new Scanner(System.in);

    String readCommand() {
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

    public void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");

    }

    public void showExitMessage(ArrayList<Task> tasks) {

        System.out.println("Your following tasks will be save: ");
        for (Task t : tasks) {
            System.out.println(t);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void printLoadingError(String s) {
        System.out.println(s);
    }


    public static int indexDetails(String input) {
        int number = Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
        return number;
    }

    public void printAddedMessage(Task task, int numberOfTasks) {
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.println("Now you have " + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks") + " in the list.");
    }
    public void printDeleteMessage(Task task, int numberOfTasks) {
        System.out.println("Noted. I've removed this task: \n" + task);
        System.out.println("Now you have " + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks") + " in the list.");
    }

    public void printDoneMessage(Task task) {
        System.out.println("Nice! I've marked this task as done:\n"
                + task);
    }
}



   /* public void printList(TaskList tasks) {
        System.out.println("    ___________________________________________________________________\n"
                + "     Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println("    " + (i + 1) + "." + tasks.getTask(i));
        }
    }*/