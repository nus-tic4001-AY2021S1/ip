package ui;

import duke.DukeException;
import duke.Global;
import duke.Task;

import java.util.ArrayList;

public class ui {

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

    //Reply Message Section
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

    //Error Message From Here On
    public static void errIndexOutOfBoundsException(){
        System.out.println(Global.PATTERNLINE + "\nFriend, You do not have so much task in the list\n"
                + Global.PATTERNLINE);
    }
    public static void errInvalidInput(){
        System.out.println(Global.PATTERNLINE + "\nYou have entered invalid input. Please re-input or \n" +
                "Enter bye to terminate the program.\n" + Global.PATTERNLINE);
    }
}
