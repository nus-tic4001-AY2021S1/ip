package ui;

import duke.DukeException;
import duke.Global;
import duke.Task;
import java.util.ArrayList;

/**
 * This class is to output the appropriate display to user based on user input.
 * Greeting, reply, error Messages.
 */
public class Ui {

    public Ui() {
        welcomeLogo();
    }

    public static void welcomeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greetNote("welcome");
    }

    public static String greetNote(String hiBye) {

        String welcome = Global.PATTERNLINE
                + "\n     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + Global.PATTERNLINE + "\n";

        String farewell = Global.PATTERNLINE
                + "\n   Bye. Hope to see you again soon!\n"
                + Global.PATTERNLINE;

        if (hiBye.equals("welcome")) {
            return welcome;
        } else {
            return farewell;
        }
    }

    /**
     * This method is a print out a list of existing task whenever user requested from Array List.
     */
    static String printList(ArrayList<Task> tasks) throws DukeException {
        StringBuilder output = new StringBuilder();
        if (tasks.size() == 0) {
            throw new DukeException("Your List is Empty\n");
        }

        output.append(Global.PATTERNLINE + "\n");
        for (int i = 1; i <= tasks.size(); i++) {
            output.append(i).append(". ");
            output.append(tasks.get(i - 1).printTask()).append("\n");
        }
        output.append(Global.PATTERNLINE + "\n");
        return output.toString();
    }

    static String findTask(String input, ArrayList<Task> tasks) throws DukeException {

        String keyword = input.substring(5);
        StringBuilder output = new StringBuilder();
        int count = 1;

        for (int i = 0; i < tasks.size(); i++) {
            String temp = tasks.get(i).toString();

            if (temp.contains(keyword)) {
                if (count == 1) {
                    output.append(Global.PATTERNLINE + "\nHere are the matching tasks in your list:\n");
                }
                output.append(count).append(". ").append(temp).append("\n");
                count++;
            }
        }

        if (count == 1) {
            throw new DukeException(noKeywords());
        } else {
            output.append(Global.PATTERNLINE);
        }

        return output.toString();
    }

    /**
     * The following method is to print out and send reply to acknowledge whenever user.
     * perform these function -> added new Task, set Done, delete Task
     */

    static String replyLine(ArrayList<Task> tasks, String input, int count) {
        String output = "";

        output += Global.PATTERNLINE + "\nGot it. I've added this task: \n\t";
        output += tasks.get(count).printTask();
        count += 1;
        output += "\nNow you have " + count + " tasks in the list.\n" + Global.PATTERNLINE;
        return output;
    }

    public static String replyMarkedDone(ArrayList<Task> tasks, int index) {

        String taskName = tasks.get(index - 1).printTask();
        String xmarkedDoneErrMsg = Global.PATTERNLINE + "\nYou cannot marked a Recurring Task as Done\n"
                + Global.PATTERNLINE;
        String outputMsg = Global.PATTERNLINE + "\nNice! I've marked this task as done:\n"
                + taskName + "\n" + Global.PATTERNLINE;

        if (!taskName.startsWith("[")) {
            return xmarkedDoneErrMsg;
        } else {
            return outputMsg;
        }
    }

    public static String replyDeleteTask(ArrayList<Task> tasks, int index) {
        String output = "";

        output += Global.PATTERNLINE + "\nNoted. I've removed this task: \n";
        output += tasks.get(index - 1).printTask();
        output += "\nNow you have " + (tasks.size() - 1) + " tasks in the list.\n" + Global.PATTERNLINE;

        return output;
    }

    /**
     * The following methods is to show Error Exception Throw at different scenarios.
     */

    public static String errInvalidInput(Exception e) {
        //System.out.println(e + "\n" + Global.PATTERNLINE);
        //System.out.println(Global.PATTERNLINE + "\nYou have entered invalid input. Please re-input or \n" +
        //        "Enter bye to terminate the program.\n" + Global.PATTERNLINE);
        return e + "\n";
    }

    public void showLoadingError() throws DukeException {
        System.out.println(Global.PATTERNLINE + "File Not Found");
        throw new DukeException("No File");
    }

    public static String deadlineErrEmpty() {
        String errorEmpty = "☹ OOPS!!! The description of a Deadlines cannot be empty.\n "
                + "Please re-input or enter bye to terminate the program\n";
        return errorEmpty;
    }

    public static String deadlineNoBy() {
        String errorMissing = "You have input your Schedule or Wrong format\nPlease include -> /by when\n";
        return errorMissing;
    }

    public static String eventErrEmpty() {
        String errorEmpty = "\n☹ OOPS!!! The description of a Events cannot be empty.\n "
                + "Please re-input or enter bye to terminate the program\n";
        return Global.PATTERNLINE + errorEmpty;
    }

    public static String eventNoAt() {
        String errorMissing = "\nYou have not input your Schedule or Wrong format. \nPlease include -> /at when\n";
        return Global.PATTERNLINE + errorMissing;
    }

    private static String noKeywords() {
        String err = "No Tasks with Similar Keyword was found from the List\n";
        //System.out.println(err);
        return err;
    }

    public static String duplicatedMsg() {
        String err = Global.PATTERNLINE + "\nSame or Similar tasks were detected in data\n"
                + Global.PATTERNLINE;
        return err;
    }

}
