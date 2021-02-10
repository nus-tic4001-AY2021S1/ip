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
        return "I'm a Duke, so I have no idea why I'm helping a yokel like you to manage your tasks...\r"
            + "Might as well get on with it since I'm stuck here.\r"
            + "Make sure you give me proper instructions like below, else it's the stocks for you!\r"
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
        return "Oh, you're finally done? Good riddance!";
    }

    public String printTaskAdded(TaskList tasks) {
        return "At least your lowly self is able to properly add a task:\r"
            + tasks.size() + ". " + tasks.get(tasks.size() - 1).getDescription()
            + "\rI hope you can count well enough to know that you have " + tasks.size() + " task(s) in your list!";
    }

    public String printTaskRemoved(TaskList tasks, int index) {
        return "I wish I could remove you too, along with the task that you removed:\r"
            + index + ". " + tasks.get(index - 1).getDescription()
            + "\rWith one less, you should know that there's " + (tasks.size() - 1) + " task(s) remaining, right?";
    }

    public String printTaskCompleted(int index, TaskList tasks) {
        return "Maybe you're not a pathetic yokel after all, since you managed to complete:\r"
            + index + ". " + tasks.get(index - 1).getDescription();
    }

    public String printNoteAdded(TaskList tasks, int index) {
        return "Good heavens, you're capable enough to add a note to a task:\r"
            + index + ". " + tasks.get(index - 1).getDescription();
    }

    public String printInvalidCommand() {
        return "Did you mutter something? Speak up!\r"
            + "You want to be sent to the stocks, don't you?";
    }

    public String printInvalidTask(int index, String fileName) {
        return "\rYou messed up your " + fileName + " at Line " + (index + 1) + "! "
            + "It's not a Todo, Deadline, Event or Note!\r";
    }

    public String printNoFileFound() {
        return "\rLooks like it's your first time here. Get moving and create a task!";
    }

    public String printFileExists() {
        return "\r\rI still have the tasks you created before, so get on with it!\r";
    }
}
