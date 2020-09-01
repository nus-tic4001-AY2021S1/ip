package duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final String LINE = "____________________________________________________________";
    private static final String INDENT = "      ";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        printWelcome();

        boolean isBye = false;
        while (!isBye) {
            String userInput = readUserInput();
            String command = getCommand(userInput);
            String commandParameter = getCommandParameter(userInput);

            System.out.println(LINE);

            try {
                switch(command) {
                case "bye":
                    isBye = true;
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
                    printError("I'm sorry, I don't know what that means.");
                }
            } catch (DukeException e) {
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
        System.out.println("Duke: Bye! Hope to see you again soon.");
        System.out.println(LINE);
    }

    private static void printError(String errorMessage) {
        System.out.println("Duke: \u2639 OPPS!! " + errorMessage);
        System.out.println(LINE);
    }

    private static void addTodo(String commandParameter) throws DukeException{
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a todo task cannot be empty.");
        }

        tasks.add(new Todo(commandParameter));

        printAddedTask();
    }

    private static void addDeadline(String commandParameter) throws DukeException {
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a deadline task cannot be empty.");
        }

        String description;
        String by;
        try {
            description = commandParameter.split("/by")[0].trim();
            by = commandParameter.split("/by")[1].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new DukeException("The by field of the deadline task is missing.");
        }
        if (description.isEmpty()){
            throw new DukeException("The description of a deadline task cannot be empty.");
        }

        tasks.add(new Deadline(description, by));

        printAddedTask();
    }

    private static void addEvent(String commandParameter) throws DukeException {
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of an event task cannot be empty.");
        }

        String description;
        String at;
        try {
            description = commandParameter.split("/at")[0].trim();
            at = commandParameter.split("/at")[1].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new DukeException("The at field of the event task is missing.");
        }
        if (description.isEmpty()){
            throw new DukeException("The description of an event task cannot be empty.");
        }

        tasks.add(new Event(description, at));

        printAddedTask();
    }

    private static void printAddedTask() {
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

    private static void markTaskAsDone(String commandParameter) throws DukeException {
        int taskIndex = getTaskIndex(commandParameter);
        setTaskAsDone(taskIndex);
        System.out.println("Duke: I have marked this task as done:");
        System.out.println(INDENT + tasks.get(taskIndex - 1).toString());
        System.out.println(LINE);
    }

    private static void setTaskAsDone(int taskIndex) throws DukeException {
        try {
            tasks.get(taskIndex - 1).setDone(true);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }
    }

    private static int getTaskIndex(String commandParameter) throws DukeException {
        if (commandParameter.isEmpty()) {
            throw new DukeException("The task index is missing.");
        }

        int taskIndex;
        try {
            taskIndex = Integer.parseInt(commandParameter);
        } catch(NumberFormatException e) {
            throw new DukeException("The task index is invalid.");
        }

        return taskIndex;
    }
}