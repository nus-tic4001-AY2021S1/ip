package duke.parser;

import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;
/**
 * Parses the user command to extract meaningful details from it.
 */
public class Parser {
    /**
     * @param line The entire user input.
     */
    String getCommandWord(String line) {
        return line.trim().split(" ")[0];
    }

    public boolean parseInput(String line, Ui ui, TaskList tasks, Database database) {

        String command = getCommandWord(line);
        String taskDescription = line.substring(line.indexOf(" ") + 1).trim();

        switch (command) {
            case "list" -> {
                ui.printAllTasks(tasks);
                return true;
            }
            case "done" -> {
                tasks.setAsCompleted(taskDescription, tasks, ui, database);
                return true;
            }
            case "delete" -> {
                tasks.deleteTask(taskDescription, tasks, ui, database);
                return true;
            }
            case "todo" -> {
                tasks.createTodo(taskDescription, tasks, ui, database);
                return true;
            }
            case "deadline" -> {
                tasks.createDeadline(taskDescription, tasks, ui, database);
                return true;
            }
            case "event" -> {
                tasks.createEvent(taskDescription, tasks, ui, database);
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
