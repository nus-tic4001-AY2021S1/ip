import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final String LINE = "____________________________________________________________";

    private static ArrayList<String> tasks = new ArrayList<String>();

    public static void main(String[] args) {
        printWelcome();

        boolean isExit = false;
        while (!isExit) {
            String fullCommand = readUserCommand();
            System.out.println(LINE);

            switch(fullCommand) {
            case "bye":
                isExit = true;
                break;
            case "list":
                listTasks();
                break;
            default:
                addTask(fullCommand);
                System.out.println("Duke: Your input is \"" + fullCommand + "\".");
                System.out.println(LINE);
            }
        }

        printGoodbye();
    }

    private static void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(LINE);
        System.out.println(logo);
        System.out.println("Duke: Hello! I'm Duke, your personal chatbot.");
        System.out.println("Duke: What can I do for you?");
        System.out.println(LINE);
    }

    private static String readUserCommand() {
        Scanner in = new Scanner(System.in);
        System.out.print("You: ");
        return in.nextLine().trim();
    }

    private static void printGoodbye() {
        System.out.println("Duke: Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    private static void addTask(String taskName) {
        tasks.add(taskName);
    }
    private static void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println(LINE);
    }
}