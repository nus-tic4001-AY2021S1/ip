package ui;

import duke.Duke;
import duke.DukeException;
import duke.Global;
import duke.Task;
import java.util.ArrayList;


/**
 * This class is to output the appropriate display to user based on user input.
 * Greeting, reply, error Messages.
 */
public class Ui {

    public Ui () {
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

    public static void greetNote(String hi_bye) {

        String welcome = Global.PATTERNLINE
                + "\n     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + Global.PATTERNLINE + "\n";

        String farewell = Global.PATTERNLINE
                + "\n   Bye. Hope to see you again soon!\n"
                + Global.PATTERNLINE;

        if(hi_bye.equals("welcome")) {
            System.out.println(welcome);
        } else {
            System.out.println(farewell);
        }
    }

    /**
     * This method is a print out a list of existing task whenever user requested from Array List.
     */
    static void printList(ArrayList<Task> tasks) throws DukeException {
        if(tasks.size() == 0) {
            throw new DukeException("Your List is Empty\n");
        }
        System.out.println(Global.PATTERNLINE);
        for(int i = 1; i <= tasks.size(); i++) {
            System.out.print(i + ". ");
            tasks.get(i-1).printTask();
        }
        System.out.println(Global.PATTERNLINE);
    }

    static void findTask(String input, ArrayList<Task> tasks) throws DukeException {

        String keyword = input.substring(5);
        int count = 1;

        for(int i = 0; i < tasks.size(); i++) {
            String temp = tasks.get(i).toString();

            if(temp.contains(keyword)) {
                if(count == 1) {
                    System.out.println(Global.PATTERNLINE + "\nHere are the matching tasks in your list:");
                }
                System.out.println(count + ". " + temp );
                count ++;
            }
        }

        if(count == 1) {
            throw new DukeException(noKeywords());
        } else {
            System.out.println(Global.PATTERNLINE );
        }
    }

    /**
     * The following method is to print out and send reply to acknowledge whenever user
     * perform these function -> added new Task, set Done, delete Task
     */

    static void replyLine(ArrayList<Task> tasks, String input, int count) {
        System.out.print(Global.PATTERNLINE + "\nGot it. I've added this task: \n\t" );
        tasks.get(count).printTask();
        count += 1;
        System.out.println("Now you have " + count + " tasks in the list.\n" + Global.PATTERNLINE );
    }
    public static void replyMarkedDone (ArrayList<Task> tasks, int index) {
        System.out.println(Global.PATTERNLINE + "\nNice! I've marked this task as done:");
        tasks.get(index-1).printTask();
        System.out.println(Global.PATTERNLINE);
    }
    public static void replyDeleteTask (ArrayList<Task> tasks, int index) {
        System.out.println(Global.PATTERNLINE + "\nNoted. I've removed this task: ");
        tasks.get(index-1).printTask();
        System.out.println("Now you have " + (tasks.size()-1) + " tasks in the list.\n" + Global.PATTERNLINE);
    }

    /**
     * The following methods is to show Error Exception Throw at different scenarios
     */

    public static void errIndexOutOfBoundsException(){
        System.out.println(Global.PATTERNLINE + "\nFriend, You do not have so much task in the list\n"
                + Global.PATTERNLINE);
    }
    public static void errInvalidInput(Exception e){
        System.out.println(e + "\n" + Global.PATTERNLINE);
        //System.out.println(Global.PATTERNLINE + "\nYou have entered invalid input. Please re-input or \n" +
        //        "Enter bye to terminate the program.\n" + Global.PATTERNLINE);
    }

    public void showLoadingError() throws DukeException {
        System.out.println(Global.PATTERNLINE + "File Not Found");
        throw new DukeException("No File");
    }

    public static String deadlineErrEmpty() {
        String errorEmpty = "☹ OOPS!!! The description of a Deadlines cannot be empty.\n " +
                "Please re-input or enter bye to terminate the program\n";
        return errorEmpty;
    }

    public static String deadlineNoBy () {
        String errorMissing = "You have input your Schedule or Wrong format\nPlease include -> /by when\n";
        return errorMissing;
    }

    private static String noKeywords() {
        String err = "No Tasks with Similar Keyword was found from the List\n";
        //System.out.println(err);
        return err;
    }

}
