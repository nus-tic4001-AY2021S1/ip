package duke.ui;

import duke.task.TaskList;
/**
 * Responsible for displaying all messages and its format to the user except for error-related messages.
 */
public class Ui {
    /**
     * @return Returns the input string in red color.
     */
    public String colorRed(String input) {
        return "\033[31m" + input + "\033[0m";
    }
    /**
     * @return Returns the input string in green color.
     */
    public String colorGreen(String input) {
        return "\033[33m" + input + "\033[0m";
    }
    /**
     * Prints the input string with borderlines.
     */
    public void printBorderlines(String input) {
        System.out.println(Style.BORDERLINE.getString()
                + input
                + Style.BORDERLINE.getString());
    }
    /**
     * Prints the input string with red colored borderlines.
     */
    public void printRedBorderlines(String input) {
        System.out.println(colorRed(Style.BORDERLINE.getString())
                + input
                + colorRed(Style.BORDERLINE.getString()));
    }

    public void printDukeLogo() {
        System.out.println(Style.LOGO.getString());
    }

    public void printGreeting() {
        String greeting = "Hello! I'm Duke.\n"
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
        printBorderlines(greeting);
    }

    public void printFarewell() {
        String farewell = "Bye. Hope to see you again soon!";
        printBorderlines(farewell);
    }

    public void printTaskAdded(TaskList tasks) {
        String added = "Great! You have entered a proper task as shown below:\n"
                + colorGreen(tasks.get(tasks.size() - 1).getDescription()
                + "\nWe now have " + tasks.size() + " task(s) in your list!");
        printBorderlines(added);
    }

    public void printTaskRemoved(TaskList tasks, int index) {
        String added = "Okay! We have removed the task as shown below:\n"
                + colorRed(tasks.get(index - 1).getDescription()
                + colorGreen("\nWe now have " + (tasks.size() - 1) + " task(s) in your list!"));
        printBorderlines(added);
    }

    public void printTaskCompleted(int index, TaskList tasks) {
        String done = "Good work there! Now we have:\n"
                + "\033[33mTask [" + index + "] "
                + tasks.get(index - 1).getDescription() + " set as completed!\033[0m";
        printBorderlines(done);
    }

    public void printInvalidCommand() {
        printRedBorderlines("It seems that you have typed something out of my unfortunately\n"
                + "limited vocabulary. Can you try again?");
    }

    public void printNoFileFound() {
        String message = "It looks like it's your first time as I could not find any existing task file.\n" +
                "Get started by creating a task!";
        System.out.println(message);
    }
    public void printFileExists() {
        String message = "An existing task file is found!";
        System.out.println(message);
    }
}
