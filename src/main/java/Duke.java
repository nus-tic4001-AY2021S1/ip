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
            String commandWord = getCommandWord(fullCommand);
            System.out.println(LINE);

            try {
                switch(commandWord) {
                case "done":
                    markTaskAsDone(fullCommand);
                    break;
                case "bye":
                    isExit = true;
                    break;
                case "list":
                    listTasks();
                    break;
                default:
                    addTask(fullCommand);
                }
            } catch (Exception e) {
                System.out.print("Duke: ");
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
        System.out.println("Duke: Task \"" + taskDescription + "\" has been added.");
        System.out.println(LINE);
    }

    private static Task createTask(String taskDescription) throws Exception {
        if (taskDescription.isEmpty()){
            throw new Exception("Task description is empty!");
        }
        return new Task(taskDescription);
    }

    private static void listTasks() {
        System.out.println("Duke: Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". [" + tasks.get(i).getStatusIcon()
                    + "] " + tasks.get(i).getDescription());
        }
        System.out.println(LINE);
    }

    private static String getCommandWord(String fullCommand) {
        return fullCommand.split(" ")[0];
    }

    private static void markTaskAsDone(String fullCommand) throws Exception {
        int taskIndex = getTaskIndex(fullCommand);
        setTaskAsDone(taskIndex);
        System.out.println("Duke: I have marked this task as done:");
        System.out.println((taskIndex) + ". [" + tasks.get(taskIndex - 1).getStatusIcon()
                + "] " + tasks.get(taskIndex - 1).getDescription());
    }

    private static void setTaskAsDone(int taskIndex) throws Exception {
        try {
            tasks.get(taskIndex - 1).setDone(true);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Invalid task index!");
        }
    }

    private static int getTaskIndex(String fullCommand) throws Exception {
        int taskIndex;
        String indexString = fullCommand.replace("done", "").trim();
        if (indexString.equals("")) {
            throw new Exception("Missing task index!");
        }
        try {
            taskIndex = Integer.parseInt(indexString);
        } catch(NumberFormatException e) {
            throw new Exception("Invalid task index!");
        }
        return taskIndex;
    }
}