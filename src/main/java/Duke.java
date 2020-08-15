import java.util.ArrayList;
import java.util.Scanner;

class Global {
    static String patternLine = "____________________________________________________________";
}

public class Duke {
    public static void main(String[] args) {

        ArrayList<String> task = new ArrayList<>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        GreetNote("welcome");

        Scanner in = new Scanner(System.in);
        String input= in.nextLine();

        while (!input.equals("bye")) {

            if(input.equals("list")) {
                PrintList(task);
            } else {
                ReplyLine(input);
                task.add(input);
            }
            in = new Scanner(System.in);
            input = in.nextLine();
        }

        GreetNote("bye");
    }

    private static void GreetNote(String hi_bye) {

        String welcome = Global.patternLine
                        + "\n     Hello! I'm Duke\n"
                        + "     What can I do for you?\n"
                        + Global.patternLine + "\n";

        String farewell = Global.patternLine
                        + "\n   Bye. Hope to see you again soon!\n"
                        + Global.patternLine;

        if(hi_bye.equals("welcome")) {
            System.out.println(welcome);
        } else {
            System.out.println(farewell);
        }
    }
    private static void ReplyLine(String input) {
        String display = Global.patternLine + "\nYou have added : " + input + "\n"+ Global.patternLine;
        System.out.println(display);
    }
    private static void PrintList(ArrayList<String> task) {
        if(task.size() == 0) {
            String noItem = Global.patternLine + "\nYour List is Empty\n" + Global.patternLine;
            System.out.println(noItem);
            return;
        }
        System.out.println(Global.patternLine);
        for(int i=1; i<=task.size(); i++) {
            System.out.println(i + ". " + task.get(i-1));
        }
        System.out.println(Global.patternLine);
    }
}
