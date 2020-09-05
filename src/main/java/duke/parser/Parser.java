package duke.parser;

import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

public class Parser {
    /**
     * @param line The entire user input.
     */
    String getCommandWord(String line) {
        return line.trim().split(" ")[0];
    }

    /**
     * @param line  The entire user input.
     * @param ui    The UI created in the Duke class.
     * @param tasks The TaskList created in the Duke class.
     */
    public boolean parseInput(String line, Ui ui, TaskList tasks) {

        String command = getCommandWord(line);
        switch (command) {
            case "list" -> {
                ui.printAllTasks(tasks);
                return true;
            }
            case "done" -> {
                tasks.setAsDone(line, ui, tasks);
                return true;
            }
            case "todo" -> {
                tasks.createTodo(line, ui, tasks);
                return true;
            }
            case "deadline" -> {
                tasks.createDeadline(line, ui, tasks);
                return true;
            }
            case "event" -> {
                tasks.createEvent(line, ui, tasks);
                return true;
            }
            case "bye", "" -> {     // also exits when user input is empty
                ui.printFarewell();
                return false;
            }
            default -> {
                ui.printInvalidCommand();
                return true;
            }
        }
    }
}
