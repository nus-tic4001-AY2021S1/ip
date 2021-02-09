package duke.command; // Organize the classes into suitable duke.command packages.

import java.util.List;

/**
 *This Ui class is to read user command and print duke logo & error.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Ui {

    /**
     * print the duke chat bot logo.
     */
    public static String showWelcome() {
        String logo = "   __            __ \n"
                + "   | |  ____    | |  ____\n"
                + "   | | / __ \\   | | / __ \\\n"
                + "__/ |  |__| |__/ |  |__| |\n"
                + "\\__/ \\__/ \\__/  \\___/\n";
        String greet = "Hi! I'm Jojo\n" + "What can I do for you?";
        return "Hello from\n" + logo + greet;
    }

    /**
     * print out error message.
     */
    public void printError() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * help chat bot print message to user.
     *
     * @param s string
     */
    public void showToUser(String s) {
        System.out.println(s);
    }

    public void showToUser(List<String> s) {
        System.out.println(s);
    }

    /**
     * print help message with command help.
     */
    public String showHelp() {
        return "List of commands:\n"
                + "-> list: lists out all tasks.\n"
                + "-> todo {detail}: add a todo item.\n"
                + "-> event {detail} /at {address}: add an event item.\n"
                + "-> deadline {detail} /at {datetime yyyy-MM-dd HHmm format}: add a deadline item.\n"
                + "-> delete {index}: removes the item(s) at the specified position(s).\n"
                + "-> done {index}: marks the item as done.\n"
                + "-> find {detail}: searches for a task contain that detail.\n"
                + "-> help: show user the app commands use manual.\n"
                + "-> save: save all change to filepath data.txt.\n";
    }
}
