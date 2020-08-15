import java.util.ArrayList;
import java.util.Scanner;

class Global {
    static String patternLine = "____________________________________________________________";
}

enum Action {
    DONE,
    LIST,
    ADD,
}

public class Duke {

    public static void main(String[] args) {

        ArrayList<Task> task = new ArrayList<>();

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
           ProcessInput(input, task);
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
    private static void ProcessInput(String input, ArrayList<Task> task) {

        String command = input.toLowerCase();
        Action action;

        if(command.startsWith("list")) {
            action = Action.LIST;
        } else if (command.length()> 4 && command.substring(0, 4).equals("done")) {
            action = Action.DONE;
        } else {
            action = Action.ADD;
        }

        switch(action) {

            case LIST :
                PrintList(task);
                break;

            case DONE :
                int index;

                //If user input done1 instead of done 1
                if(command.contains(" ")) {
                    index = Integer.parseInt(command.substring(5));
                } else {
                    index = Integer.parseInt(command.substring(4));
                }

                //If user input Done item out of bound
                if (index > task.size() || index ==0) {
                    System.out.println(Global.patternLine + "\nFriend, You do not have so much task in the list\n" + Global.patternLine);
                    return;
                }

                task.get(index-1).markAsDone();
                System.out.println(Global.patternLine + "\nNice! I've marked this task as done:");
                task.get(index-1).printTask();
                System.out.println(Global.patternLine);
                break;

            default:
                ReplyLine(input);
                task.add(new Task(input));

        }
    }
    private static void ReplyLine(String input) {
        String display = Global.patternLine + "\nYou have added : " + input + "\n"+ Global.patternLine;
        System.out.println(display);
    }
    private static void PrintList(ArrayList<Task> task) {
        if(task.size() == 0) {
            String noItem = Global.patternLine + "\nYour List is Empty\n" + Global.patternLine;
            System.out.println(noItem);
            return;
        }
        System.out.println(Global.patternLine);
        for(int i=1; i<=task.size(); i++) {
            System.out.print(i + ". ");
            task.get(i-1).printTask();
        }
        System.out.println(Global.patternLine);
    }
}
