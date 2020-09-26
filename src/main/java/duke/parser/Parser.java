package duke.parser;

import duke.commands.*;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;

public class Parser {
    /**
     * Parses the user input into meaningful details and returns the appropriate command.
     */
    public Command parseInput(String line, Ui ui, TaskList tasks, Database database) {

        String commandWord = line.trim().split(" ")[0];
        String lineWithoutCommand = line.substring(line.indexOf(" ") + 1).trim();

        switch (commandWord) {
            case ListCommand.word -> {
                return new ListCommand(tasks, ui);
            }
            case FindCommand.word -> {
                return new FindCommand(lineWithoutCommand, tasks, ui);
            }
            case DoneCommand.word -> {
                return new DoneCommand(lineWithoutCommand, tasks, ui, database);
            }
            case DeleteCommand.word -> {
                return new DeleteCommand(lineWithoutCommand, tasks, ui, database);
            }
            case TodoCommand.word -> {
                return new TodoCommand(lineWithoutCommand, tasks, ui, database);
            }
            case DeadlineCommand.word -> {
                return new DeadlineCommand(lineWithoutCommand, tasks, ui, database);
            }
            case EventCommand.word -> {
                return new EventCommand(lineWithoutCommand, tasks, ui, database);
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
