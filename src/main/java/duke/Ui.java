package duke;

import java.util.Scanner;

public class Ui {
    public static final String LINE = "____________________________________________________________";
    public static final String INDENT = "      ";

    public String readUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("You:  ");
        return in.nextLine().trim();
    }

    public void printLine() {
        System.out.println(LINE);
    }

    public void printIndentation() {
        System.out.print(INDENT);
    }

    public void printWelcome() {
        String logo = " ____        _        " + System.lineSeparator()
                + "|  _ \\ _   _| | _____ " + System.lineSeparator()
                + "| | | | | | | |/ / _ \\" + System.lineSeparator()
                + "| |_| | |_| |   <  __/" + System.lineSeparator()
                + "|____/ \\__,_|_|\\_\\___|" + System.lineSeparator();

        printLine();
        System.out.println(logo);
        System.out.println("Duke: Hello! I'm Duke, your personal chatbot.");
        System.out.println("Duke: What can I do for you?");
        printLine();
    }

    public void printError(String errorMessage) {
        System.out.println("Duke: OPPS!! " + errorMessage);
        printLine();
    }

    public void printGoodbye() {
        System.out.println("Duke: Bye! Hope to see you again soon.");
        printLine();
    }

    public void printAddedTask(TaskList tasks) {
        System.out.println("Duke: Got it! I have added this task:");
        printIndentation();
        System.out.println(tasks.getTask(tasks.getSize() - 1).toString());
        printIndentation();
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
        printLine();
    }

    public void printRemovedTask(int size, String taskDescription) {
        System.out.println("Duke: Noted! I've removed this task: ");
        printIndentation();
        System.out.println(taskDescription);
        printIndentation();
        System.out.println("Now you have " + size + " tasks in the list.");
        printLine();
    }

    public void printDoneTask(Task task) {
        System.out.println("Duke: I have marked this task as done:");
        printIndentation();
        System.out.println(task.toString());
        printLine();
    }

    public void printTasks(TaskList tasks) {
        if (tasks.getSize() == 0) {
            System.out.println("Duke: Sorry, there is no task in your list.");
        } else {
            System.out.println("Duke: Here are the tasks in your list:");
            for (int i = 0; i < tasks.getSize(); i++) {
                printIndentation();
                System.out.println((i + 1) + ". " + tasks.getTask(i).toString());
            }
            printLine();
        }
    }

    public void printFilteredTasks(TaskList filteredTasks) {
        if (filteredTasks.getSize() == 0) {
            System.out.println("Duke: Sorry, there is no matching task.");
        } else {
            System.out.println("Duke: Here are the matching tasks in your list:");
            for (int i = 0; i < filteredTasks.getSize(); i++) {
                printIndentation();
                System.out.println((i + 1) + ". " + filteredTasks.getTask(i).toString());
            }
            printLine();
        }
    }
}