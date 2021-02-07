package duke.parser;

import duke.commands.Command;
import duke.commands.DeadlineCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.EventCommand;
import duke.commands.ExitCommand;
import duke.commands.FindCommand;
import duke.commands.InvalidCommand;
import duke.commands.ListCommand;
import duke.commands.NoteCommand;
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
        String lineWithoutCommand = line.substring(line.indexOf(" ") + 1).trim();

        switch (commandWord) {
        case ListCommand.word:
            return new ListCommand(tasks, ui);
        case FindCommand.word:
            return new FindCommand(lineWithoutCommand, tasks, ui);
        case DoneCommand.word:
            return new DoneCommand(lineWithoutCommand, tasks, ui, database);
        case DeleteCommand.word:
            return new DeleteCommand(lineWithoutCommand, tasks, ui, database);
        case TodoCommand.word:
            return new TodoCommand(lineWithoutCommand, tasks, ui, database);
        case DeadlineCommand.word:
            return new DeadlineCommand(lineWithoutCommand, tasks, ui, database);
        case EventCommand.word:
            return new EventCommand(lineWithoutCommand, tasks, ui, database);
        case NoteCommand.word:
            return new NoteCommand(lineWithoutCommand, tasks, ui, database);
        case "bye":
        case "exit":
            return new ExitCommand(ui);
        default:
            return new InvalidCommand(ui);
        }
    }
}
