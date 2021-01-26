package duke.ui;

import duke.MainWindow;
import duke.task.TaskList;

/**
 * Responsible for displaying all messages and its format to the user except for error-related messages.
 */

public class Ui {

    private final MainWindow mw = new MainWindow();
    /**
     * Colors an input string in red.
     */

    public String colorRed(String input) {
        return input; //"\033[31m" + input + "\033[0m";
    }

    /**
     * Colors an input string in green.
     */

    public String colorGreen(String input) {
        return input; //"\033[33m" + input + "\033[0m";
    }

    /**
     * Prints the input string in red.
     */

    public String printRed(String input) {
        return colorRed(input);
    }

    public String printDukeLogo() {
        return Style.LOGO.getString();
    }

    public String printGreeting() {
        return "Hello! I'm Duke.\n"
            + "I can help you manage a list of tasks!\n"
            + "What you can tell me to do is listed below:\n"
            + "  ⬡  Create a Todo task     | " + colorGreen("todo <your task>\n")
            + "  ⬢  Create a Deadline task | " + colorGreen("deadline <your task> /by <dd/MM/yyyy HHmm>\n")
            + "  ⬡  Create an Event task   | " + colorGreen("event <your task> /at <dd/MM/yyyy HHmm> /to <HHmm>\n")
            + "  ⬢  Complete a task        | " + colorGreen("done <task index number>\n")
            + "  ⬡  Delete a task          | " + colorGreen("delete <task index number>\n")
            + "  ⬢  List down all tasks    | " + colorGreen("list\n")
            + "  ⬡  Find tasks with word   | " + colorGreen("find <word>\n")
            + "  ⬢  Exit my program        | " + colorGreen("bye or hit Enter");
    }

    public String printFarewell() {
        return "Bye. Hope to see you again soon!";
    }

    public String printTaskAdded(TaskList tasks) {
        return "Great! You have entered a proper task as shown below:\n"
            + colorGreen(tasks.get(tasks.size() - 1).getDescription()
            + "\nWe now have " + tasks.size() + " task(s) in your list!");
    }

    public String printTaskRemoved(TaskList tasks, int index) {
        return "Okay! We have removed the task as shown below:\n"
            + colorRed(tasks.get(index - 1).getDescription()
            + colorGreen("\nWe now have " + (tasks.size() - 1) + " task(s) in your list!"));
    }

    public String printTaskCompleted(int index, TaskList tasks) {
        return "Good work there! Now we have:\n"
            + colorGreen(index + ". ")
            + tasks.get(index - 1).getDescription() + colorGreen(" set as completed!");
    }

    public String printInvalidCommand() {
        return printRed("It seems that you have typed something out of my unfortunately\n"
            + "limited vocabulary. Can you try again?");
    }

    public String printInvalidTask() {
        return printRed("Task found is not a Todo, Deadline or Event task. Please verify the task.");
    }

    public String printNoFileFound() {
        return "\nIt looks like it's your first time as I could not find any existing task file.\n"
            + "Get started by creating a task!";
    }

    public String printFileExists() {
        return "\nAn existing task file is found!\n";
    }
}
