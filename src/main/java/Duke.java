import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final String LINE = "____________________________________________________________";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        printWelcome();

        boolean isExit = false;
        while (!isExit) {
            String fullCommand = readUserCommand();
            System.out.println(LINE);

            try {
                switch(fullCommand) {
                case "bye":
                    isExit = true;
                    break;
                case "list":
                    listTasks();
                    break;
                default:
                    addTask(fullCommand);
                    System.out.println("Duke: Task \"" + fullCommand + "\" has been added.");
                    System.out.println(LINE);
                }
            } catch (Exception e) {
                printError(e.getMessage());
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

    private static void printError(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println(LINE);
    }

    private static void addTask(String taskDescription) throws Exception{
        tasks.add(createTask(taskDescription));
    }
    private static void listTasks() {
        System.out.println("Duke: Here are the tasks in your list!");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
        }
        System.out.println(LINE);
    }

    private static Task createTask(String taskDescription) throws Exception {
        if (taskDescription.isEmpty()){
            throw new Exception("Task description is empty!");
        }
        return new Task(taskDescription);
    }
}