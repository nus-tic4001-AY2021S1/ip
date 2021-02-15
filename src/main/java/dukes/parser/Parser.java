package dukes.parser;


import dukes.command.Command;
import dukes.command.ExitCommand;
import dukes.command.DoneCommand;
import dukes.command.DeleteCommand;
import dukes.command.ListCommand;
import dukes.command.FindCommand;
import dukes.command.DeadlineCommand;
import dukes.command.EventCommand;
import dukes.command.AddCommand;
import dukes.command.HelpCommand;
import dukes.exception.DukeException;
import dukes.tasks.ToDo;


/**
 * Parser program containing methods that deals with parsing the user command to extract meaningful details from it.
 */
public class Parser {
    /**
     * Processes the user input and creates the corresponding commands.
     *
     * @param input Command input by user.
     * @return Corresponding command that is input by user.
     * @throws DukeException If a new command cannot be created due to invalid input parameters.
     */
    public static Command parse(String input) throws DukeException {
        String action = input.split(" ")[0].toLowerCase();
        switch (action) {
        case "list":
            return new ListCommand();
        case "todo":
            return  new AddCommand(new ToDo(input.substring(5)));
        case "delete":
            return new DeleteCommand(input);
        case "done":
            return new DoneCommand(input);
        case "deadline":
            return new DeadlineCommand();
        case "event":
            return new EventCommand();
        case "find":
            return new FindCommand(input.substring(5).toLowerCase());
        case "help":
            return new HelpCommand();
        case "bye":
        case "exit":
            return new ExitCommand();
        default:
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}

