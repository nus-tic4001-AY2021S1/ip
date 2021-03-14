package duke.parser;

import duke.commands.ByeCommand;
import duke.commands.ListCommand;
import duke.commands.DoneCommand;
import duke.commands.DeleteCommand;
import duke.commands.TodoCommand;
import duke.commands.DeadLineCommand;
import duke.commands.EventCommand;
import duke.commands.FindCommand;
import duke.commands.ClearCommand;
import duke.commands.UnknownCommand;
import duke.commands.Command;
import duke.commands.SortCommand;
import duke.exceptions.DukeException;
import duke.ui.Ui;
import duke.tasks.Event;

/** .
 * Parser: deals with making sense of the user command
 */
public class Parser {
    public static final String KEYWORD_MULTIPLE_SPACE = "  +";
    public static final String KEYWORD_ONE_SPACE = " ";

    /**
     * Parses a String input into a command.
     *
     * @param input The input to parse.
     * @return Command associated with the input.
     * @throws DukeException If the input does not match any command.
     */
    public static Command parse(String input) throws DukeException {

        assert input != null;
        String[] inputArr = getInputArray(input);
        String commandFirstWord =  inputArr[0].toLowerCase();
        //extract the first word of the user input, and lowercase it.

        try {
            switch (commandFirstWord) {
            case "bye":
                return new ByeCommand(input);
            case "list":
                return new ListCommand(input);
            case "done":
                return new DoneCommand(input);
            case "delete":
                return new DeleteCommand(input);
            case "todo":
                return new TodoCommand(input);
            case "deadline":
                return new DeadLineCommand(input);
            case "event":
                return new EventCommand(input);
            case "find":
                return new FindCommand(input);
            case "clear":
                return new ClearCommand(input);
            case "sort":
                return new SortCommand(input);
            default:
                return new UnknownCommand(input);

            }

        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }


        return null;
    }

    /**
     * Get a String input into a list.
     *
     * @param input The input to parse.
     * @return Command associated with the input.
     */
    public static String[] getInputArray(String input) {
        return input.trim().replaceAll(KEYWORD_MULTIPLE_SPACE, KEYWORD_ONE_SPACE).split(KEYWORD_ONE_SPACE, 2);
    }




}
















