import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final String LINE = "____________________________________________________________";
    private static final String INDENT = "      ";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        printWelcome();

        boolean isExit = false;
        while (!isExit) {
            String userInput = readUserInput();
            String command = getCommand(userInput);
            String commandParameter = getCommandParameter(userInput);
            System.out.println(LINE);

            try {
                switch(command) {
                case "bye":
                    isExit = true;
                    break;
                case "todo":
                    addTodo(commandParameter);
                    break;
                case "deadline":
                    addDeadline(commandParameter);
                    break;
                case "event":
                    addEvent(commandParameter);
                    break;
                case "done":
                    markTaskAsDone(commandParameter);
                    break;
                case "list":
                    listTasks();
                    break;
                default:
                    printError("Duke: Unknown command! Please try again.");
                }
            } catch (Exception e) {
                System.out.print("Duke: ");
                printError(e.getMessage());
            }
        }

        printGoodbye();
    }

    private static void printWelcome() {
        String logo = " ____        _        " + System.lineSeparator()
                + "|  _ \\ _   _| | _____ " + System.lineSeparator()
                + "| | | | | | | |/ / _ \\" + System.lineSeparator()
                + "| |_| | |_| |   <  __/" + System.lineSeparator()
                + "|____/ \\__,_|_|\\_\\___|" + System.lineSeparator();
        System.out.println(LINE);
        System.out.println(logo);
        System.out.println("Duke: Hello! I'm Duke, your personal chatbot.");
        System.out.println("Duke: What can I do for you?");
        System.out.println(LINE);
    }

    private static String readUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("You:  ");
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

    private static void addTodo(String commandParameter) throws Exception{
        if (commandParameter.isEmpty()){
            throw new Exception("Task description is empty!");
        }
        tasks.add(new Task(commandParameter));
        System.out.println("Duke: Got it! I have added this task:");
        System.out.println(INDENT + tasks.get(tasks.size() - 1).toString());
        System.out.println(INDENT + "Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    private static void addDeadline(String commandParameter) throws Exception{
        String description;
        String by;
        try {
            description = commandParameter.split("/by")[0].trim();
            by = commandParameter.split("/by")[1].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing by for deadline task!");
        }
        tasks.add(new Deadline(description, by));
        System.out.println("Duke: Got it! I have added this task:");
        System.out.println(INDENT + tasks.get(tasks.size() - 1).toString());
        System.out.println(INDENT + "Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    private static void addEvent(String commandParameter) throws Exception{
        String description;
        String at;
        try {
            description = commandParameter.split("/at")[0].trim();
            at = commandParameter.split("/at")[1].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing at for event task!");
        }
        tasks.add(new Event(description, at));
        System.out.println("Duke: Got it! I have added this task:");
        System.out.println(INDENT + tasks.get(tasks.size() - 1).toString());
        System.out.println(INDENT + "Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    private static void listTasks() {
        System.out.println("Duke: Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(INDENT + (i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.println(LINE);
    }

    private static String getCommand(String userInput) {
        return userInput.split(" ")[0];
    }

    private static String getCommandParameter(String userInput) {
        String commandParameter = userInput.replace("todo", "")
                .replace("deadline", "")
                .replace("event", "")
                .replace("done", "")
                .replace("list", "")
                .trim();
        return commandParameter;
    }

    private static void markTaskAsDone(String commandParameter) throws Exception {
        int taskIndex = getTaskIndex(commandParameter);
        setTaskAsDone(taskIndex);
        System.out.println("Duke: I have marked this task as done:");
        System.out.println(INDENT + tasks.get(taskIndex - 1).toString());
        System.out.println(LINE);
    }

    private static void setTaskAsDone(int taskIndex) throws Exception {
        try {
            tasks.get(taskIndex - 1).setDone(true);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Invalid task index!");
        }
    }

    private static int getTaskIndex(String commandParameter) throws Exception {
        int taskIndex;
        if (commandParameter.isEmpty()) {
            throw new Exception("Missing task index!");
        }
        try {
            taskIndex = Integer.parseInt(commandParameter);
        } catch(NumberFormatException e) {
            throw new Exception("Invalid task index!");
        }
        return taskIndex;
    }
}