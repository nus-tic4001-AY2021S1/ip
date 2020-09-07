package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The <code>Duke</code> class implements an application that allows users to manage tasks.
 * It contains methods that allow the creation, modification and storage of tasks.
 */
public class Duke {
    private static final String LINE = "____________________________________________________________";
    private static final String INDENT = "      ";
    private static final String FILEPATH = "data/tasks.txt";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        printWelcome();

        try {
            tasks = loadTasks(FILEPATH);
        } catch (DukeException e) {
            printError(e.getMessage());
        }

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
                case "delete":
                    deleteTask(commandParameter);
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

    private static void addTodo(String commandParameter) throws DukeException {
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a todo task cannot be empty.");
        }

        tasks.add(new Todo(commandParameter));

        try {
            saveTask(FILEPATH);
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

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

        try {
            saveTask(FILEPATH);
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

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

        try {
            saveTask(FILEPATH);
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

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
                .replace("delete", "")
                .replace("list", "")
                .trim();

        return commandParameter;
    }

    private static void markTaskAsDone(String commandParameter) throws DukeException {
        int taskIndex = getTaskIndex(commandParameter);
        setTaskAsDone(taskIndex);

        try {
            saveTask(FILEPATH);
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

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

    private static void deleteTask(String commandParameter) throws DukeException {
        int taskIndex = getTaskIndex(commandParameter);
        String taskDescription;
        try {
            taskDescription =  tasks.get(taskIndex - 1).toString();
            tasks.remove(taskIndex - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }

        try {
            saveTask(FILEPATH);
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }

        System.out.println("Duke: Noted! I've removed this task: ");
        System.out.println(INDENT + taskDescription);
        System.out.println(INDENT + "Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
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

    private static void saveTask(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        String isDone;
        String description;
        String dateTime;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getIsDone()) {
                isDone = "1";
            }
            else {
                isDone = "0";
            }
            description = tasks.get(i).getDescription();
            if (tasks.get(i) instanceof Todo) {
                fw.write("T" + " | " + isDone + " | " + description + System.lineSeparator());
            } else if (tasks.get(i) instanceof Deadline) {
                dateTime = ((Deadline) tasks.get(i)).getBy();
                fw.write("D" + " | " + isDone + " | " + description + " | " + dateTime + System.lineSeparator());
            } else {
                dateTime = ((Event) tasks.get(i)).getAt();
                fw.write("E" + " | " + isDone + " | " + description + " | " + dateTime + System.lineSeparator());
            }
        }

        fw.close();
    }

    private static ArrayList<Task> loadTasks(String filePath) throws DukeException {
        try {
            Path path = Paths.get("data/");
            if (!(Files.exists(path))) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            throw new DukeException("Failed to create directory!" + e.getMessage());
        }

        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<String> lines;

        lines = getLines(filePath);
        for (String line : lines) {
            if (!(line.trim().isEmpty())) {
                tasks.add(createTask(line));
            }
        }
        return tasks;
    }

    private static ArrayList<String> getLines(String filePath) throws DukeException {
        File f = new File(filePath);
        ArrayList<String> result = new ArrayList<>();
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (IOException e) {
            throw new DukeException("I've problem reading the save file. Let's start with an empty task list instead.");
        }
        return result;
    }

    private static Task createTask(String line) {
        String taskType = line.split("\\|")[0].trim();
        String isDoneString = line.split("\\|")[1].trim();
        String description = line.split("\\|")[2].trim();

        boolean isDone;
        if (isDoneString.equals("1")) {
            isDone = true;
        } else {
            isDone = false;
        }

        if (taskType.equals("D")) {
            String by = line.split("\\|")[3].trim();
            return new Deadline(description, by, isDone);
        } else if (taskType.equals("E")) {
            String at = line.split("\\|")[3].trim();
            return new Event(description, at, isDone);
        } else {
            return new Todo(description, isDone);
        }
    }
}