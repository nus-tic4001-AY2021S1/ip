package duke.command; // Organize the classes into suitable duke.command packages.

import java.util.Scanner;

/**
 *This Ui class is to read user command and print duke logo & error.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Ui {

    private final Scanner in = new Scanner(System.in);

    /**
     * print a line ro separate the chat text.
     */
    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * print the duke chat bot logo.
     */
    public void printLogo() {
        String logo = "  __          __ \n"
                + "  | | ____    | | ____\n"
                + "  | |/ __ \\   | |/ __ \\\n"
                + "__/ | |__| |__/ | |__| |\n"
                + "\\__/ \\____/ \\__/ \\____/\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * print duke duke chat bot welcome.
     */
    public void greetUser() {
        printLine();
        showToUser("Hi! I'm Jojo");
        showToUser("What can I do for you?");
        printLine();
    }

    /**
     * print duke chat bot farewell to user.
     */
    public void farewellUser() {
        printLine();
        showToUser("Bye. Have a nice day!");
        printLine();
    }


    /**
     * print out error message.
     */
    public void printError() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * help chat bot print program error message.
     *
     * @param message string
     */
    public void printError(String message) {
        System.out.println(message);
    }

    /**
     * help chatbot print message to user.
     *
     * @param s string
     */
    public void showToUser(String s) {
        System.out.println(s);
    }


    /**
     * read the user command.
     *
     * @return user command with lowercase
     */
    public String readCommand() {
        String command = in.nextLine().trim();
        return command.toLowerCase();
    }
}
