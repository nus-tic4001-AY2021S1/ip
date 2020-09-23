package duke.parser;

import duke.commands.Command;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.DeadlineCommand;
import duke.commands.EventCommand;
import duke.commands.ExitCommand;
import duke.commands.ListCommand;
import duke.commands.InvalidCommand;
import duke.commands.TodoCommand;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;

public class Parser {
    /**
     * Parses the user input into meaningful details and returns the appropriate command.
     */
    public Command parseInput(String line, Ui ui, TaskList tasks, Database database) {

        String commandWord = line.trim().split(" ")[0];
        String taskDescription = line.substring(line.indexOf(" ") + 1).trim();

        switch (commandWord) {
            case ListCommand.word -> {
                return new ListCommand(tasks, ui);
            }
            case DoneCommand.word -> {
                return new DoneCommand(taskDescription, tasks, ui, database);
            }
            case DeleteCommand.word -> {
                return new DeleteCommand(taskDescription, tasks, ui, database);
            }
            case TodoCommand.word -> {
                return new TodoCommand(taskDescription, tasks, ui, database);
            }
            case DeadlineCommand.word -> {
                return new DeadlineCommand(taskDescription, tasks, ui, database);
            }
            case EventCommand.word -> {
                return new EventCommand(taskDescription, tasks, ui, database);
            }
            case "bye", "exit", "" -> {     // also exits when user input is empty
                return new ExitCommand(ui);
            }
            default -> {
                return new InvalidCommand(ui);
            }
        }
    }
}
