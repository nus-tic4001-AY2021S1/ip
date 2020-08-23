import java.util.ArrayList;
import java.util.Scanner;

class Global {
    static String patternLine = "____________________________________________________________";
}

enum Action {
    DONE,
    LIST,
    ADD,
    ADD_TODO,
    ADD_DEADLINES,
    ADD_EVENTS,
    INVALID,
}

public class Duke {

    public static void main(String[] args) {

        ArrayList<Task> task = new ArrayList<>();
        //Task[] tasks = new Task[100];

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        GreetNote("welcome");

        Scanner in = new Scanner(System.in);
        String input= in.nextLine();

        while (!(input.toLowerCase()).equals("bye")) {
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
        int count = task.size();
        int index;

        if(command.startsWith("list")) {
            action = Action.LIST;
        } else if (command.length()> 4 && command.substring(0, 4).equals("done")) {
            action = Action.DONE;
        } else if (command.length()> 5 && command.substring(0, 4).equals("todo")) {
            action = Action.ADD_TODO;
        } else if (command.length()> 9 && command.substring(0, 8).equals("deadline")) {
            action = Action.ADD_DEADLINES;
        }else if (command.length()> 6 && command.substring(0, 5).equals("event")) {
            action = Action.ADD_EVENTS;
        }else {
            action = Action.INVALID;
        }

        switch(action) {

            case LIST :
                PrintList(task);
                break;

            case DONE :
                //If user input done1 instead of done 1
                if(command.contains(" ")) {
                    index = Integer.parseInt(command.substring(5));
                } else {
                    index = Integer.parseInt(command.substring(4));
                }

                //If user input Done item out of bound
                if (index > task.size() || index == 0) {
                    System.out.println(Global.patternLine + "\nFriend, You do not have so much task in the list\n" + Global.patternLine);
                    return;
                }

                task.get(index-1).markAsDone();
                System.out.println(Global.patternLine + "\nNice! I've marked this task as done:");
                task.get(index-1).printTask();
                System.out.println(Global.patternLine);
                break;

            case ADD_TODO:
                AddTodo(task, input, count);
                break;

            case ADD_DEADLINES:
                AddDeadlines(task, input, count);
                break;

            case ADD_EVENTS:
                AddEvents(task, input, count);
                break;

            default:
                System.out.println(Global.patternLine + "\nYou have entered invalid input. Please re-input or \n" +
                        "Enter bye to terminate the program.\n" + Global.patternLine);

        }
    }
    private static void ReplyLine(ArrayList<Task> task, String input, int count) {
        System.out.print(Global.patternLine + "\nGot it. I've added this task: \n\t" );
        task.get(count).printTask();
        count += 1;
        System.out.println("Now you have " + count + " tasks in the list.\n" + Global.patternLine );
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

    private static void AddTodo(ArrayList<Task> task, String input, int count) {
        task.add(new ToDos(input.substring(5)));
        ReplyLine(task, input, count);
    }
    private static void AddDeadlines(ArrayList<Task> task, String input, int count) {
        int index = input.indexOf("/by");
        if(index == -1) {
            System.out.println("You have not input your Schedule or Wrong format. \nPlease include -> /by when");
            return;
        }
        String schedule = input.substring(index + 4);
        String taskName = input.substring(input.indexOf(" ")+1, index);
        task.add(new Deadlines(taskName, schedule));
        ReplyLine(task, input, count);
    }
    private static void AddEvents(ArrayList<Task> task, String input, int count){
        int index = input.indexOf("/at");
        String schedule, taskName;
        if(index == -1) {
            System.out.println("You have not input your Schedule or Wrong format. \nPlease include -> /at when");
            return;
        }
        schedule = input.substring(index + 4);
        taskName = input.substring(input.indexOf(" ")+1, index);
        task.add(new Events(taskName, schedule));
        ReplyLine(task, input, count);
    }
}
