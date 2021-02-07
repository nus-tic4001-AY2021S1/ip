package duke.ui;

import duke.task.TaskList;

/**
 * Responsible for displaying all messages and its format to the user except for error-related messages.
 */

public class Ui {

    public String printDukeLogo() {
        return Style.LOGO.getString();
    }

    public String printGreeting() {
        return "Hello! I'm Duke.\r"
            + "I can help you manage a list of tasks!\r"
            + "What you can tell me to do is listed below:\r"
            + "  ⬡  Create a Todo task     | todo <task>\r"
            + "  ⬢  Create a Deadline task | deadline <task> /by <dd/MM/yyyy HHmm>\r"
            + "  ⬡  Create an Event task   | event <task> /at <dd/MM/yyyy HHmm> /to <HHmm>\r"
            + "  ⬢  Complete a task        | done <index>\r"
            + "  ⬡  Delete a task          | delete <index>\r"
            + "  ⬢  List down all tasks    | list\r"
            + "  ⬡  Find tasks with word   | find <word>\r"
            + "  ⬢  Add a note to a task   | note <index> <text>\r"
            + "  ⬡  Exit my program        | bye or exit";
    }

    public String printFarewell() {
        return "Bye. Hope to see you again soon!";
    }

    public String printTaskAdded(TaskList tasks) {
        return "Great! You have entered a proper task as shown below:\r"
            + tasks.size() + ". " + tasks.get(tasks.size() - 1).getDescription()
            + "\rWe now have " + tasks.size() + " task(s) in your list!";
    }

    public String printTaskRemoved(TaskList tasks, int index) {
        return "Okay! We have removed the task as shown below:\r"
            + index + ". " + tasks.get(index - 1).getDescription()
            + "\rWe now have " + (tasks.size() - 1) + " task(s) in your list!";
    }

    public String printTaskCompleted(int index, TaskList tasks) {
        return "Good work there! Now we have completed the task as shown below:\r"
            + index + ". " + tasks.get(index - 1).getDescription();
    }

    public String printNoteAdded(TaskList tasks, int index) {
        return "Great! You have entered a proper note as shown below:\r"
            + index + ". " + tasks.get(index - 1).getDescription();
    }

    public String printInvalidCommand() {
        return "It seems that you have typed something out of my unfortunately\r"
            + "limited vocabulary. Can you try again?";
    }

    public String printInvalidTask(int index, String fileName) {
        return "\r[Warning] Line " + (index + 1) + " is not a Todo, Deadline, Event or Note. "
            + "Please verify " + fileName + ".\r";
    }

    public String printNoFileFound() {
        return "\rIt looks like it's your first time as I could not find any existing task file.\r"
            + "Get started by creating a task!";
    }

    public String printFileExists() {
        return "\r\rAn existing task file is found!\r";
    }
}
