package ui;

import duke.DukeException;
import duke.Global;
import duke.Task;

import java.util.ArrayList;

public class ui {

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

    static void replyLine(ArrayList<Task> tasks, String input, int count) {
        System.out.print(Global.PATTERNLINE + "\nGot it. I've added this task: \n\t" );
        tasks.get(count).printTask();
        count += 1;
        System.out.println("Now you have " + count + " tasks in the list.\n" + Global.PATTERNLINE );
    }


}
