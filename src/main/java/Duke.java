import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>(100);

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printWelcome();
        //Declare the object and initialize with
        Scanner in = new Scanner(System.in);
        //String input
        String input = in.nextLine();

        while (!input.isEmpty()) {
            if (input.startsWith("bye")) {
                break;
            } else if (input.startsWith("list")) {
                System.out.println("    ___________________________________________________________________\n"
                        + "     Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println("    " + (i + 1) + "." + tasks.get(i));
                }
            } else if (input.startsWith("done")) {
                String listActionIndex = (input.split(" "))[1];
                int arrayIndex = Integer.parseInt(listActionIndex) - 1;
                markAsDone(arrayIndex);
            } else if (input.startsWith("todo")) {
                Task ignoreWord = new ToDo(input.substring(5));
                tasks.add(ignoreWord);
                System.out.println("Got it, I've added the following task:\n"
                        + "  "
                        + ignoreWord
                        + "\n"
                        + "Now you have "
                        + tasks.size()
                        + " tasks in the list.\n"
                        + "___________________________________________________________________\n");
            } else if (input.startsWith("deadline")) {
                String[] splitDetail = input.split("/by");
                String task = splitDetail[0];
                String date = splitDetail[1];
                Task detail = new Deadline(task, date);
                tasks.add(detail);
                System.out.println("Got it. I've added this task:\n"
                        + "  "
                        + detail
                        + "\n"
                        + "Now you have " + tasks.size() + " tasks in the list.\n"
                        + "___________________________________________________________________\n");
            } else if (input.startsWith("event")) {
                String[] splitEvent = input.split("/at");
                String event = splitEvent[0];
                String time = splitEvent[1];
                Task details = new Event(event, time);
                tasks.add(details);
                System.out.println("Got it. I've added this task:\n"
                        + "  "
                        + details
                        + "\n"
                        + "Now you have " + tasks.size() + " tasks in the list.\n"
                        + "___________________________________________________________________\n");
            }
            input = in.nextLine();
        }
        showExit();
    }

    public static void printWelcome() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }

    public static void showExit() {
        System.out.println("   Bye. Hope to see you again soon!");
    }

    public static void markAsDone(int arrayIndex) {
        Task task = tasks.get(arrayIndex);
        task.setDone();
        System.out.println("     Nice! I've marked this task as done:\n"
                + task
                + "\n"
                + "___________________________________________________________________\n");
    }
}


