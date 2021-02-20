package duke.parser;

import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.HelpCommand;
import duke.command.InvalidCommand;
import duke.command.ListCommand;
import duke.command.SaveCommand;
import duke.command.SendCommand;
import duke.command.TodoCommand;
import duke.command.DeleteCommand;
import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * A command handler, redirect all the commandline.
 */

public class Parser {

    public Command parserInput(String line, Ui ui, Storage storage, ArrayList commandName) {


        String commandWord = line.trim().split(" ", 2)[0];

        System.out.println(commandWord);
        switch (commandWord) {
        case HelpCommand.word:
            return new HelpCommand(ui);
        case TodoCommand.word:
            return new TodoCommand(line, ui, storage, commandName);
        case DeadlineCommand.word:
            return new DeadlineCommand(line, ui, storage, commandName);
        case EventCommand.word:
            return new EventCommand(line, ui, storage, commandName);
        case FindCommand.word:
            return new FindCommand(line, ui, storage, commandName);
        case SendCommand.word:
            return new SendCommand(line, ui, storage, commandName);
        case DoneCommand.word:
            return new DoneCommand(line, ui, storage, commandName);
        case DeleteCommand.word:
            return new DeleteCommand(line, ui, storage, commandName);
        case ListCommand.word:
            return new ListCommand(line, ui, storage, commandName);
        case SaveCommand.word:
            return new SaveCommand(line, ui, storage, commandName);
        default:
            return new InvalidCommand();
        }


    }
}
