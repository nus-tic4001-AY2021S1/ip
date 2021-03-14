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
import duke.tasks.Task;
import duke.ui.Ui;
import duke.tasks.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static duke.util.TaskList.isValidDateTimeFormat;

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

    /**
     * Get a String input into command parameter.
     *
     * @param input The input to parse.
     * @return Command associated with the input.
     */
    private static String getCommandParameter(String input) {
        return input.replaceFirst("(?i)todo", "")
                .replaceFirst("(?i)deadline", "")
                .replaceFirst("(?i)event", "")
                .replaceFirst("(?i)done", "")
                .replaceFirst("(?i)delete", "")
                .replaceFirst("(?i)list", "")
                .replaceFirst("(?i)sort", "")
                .trim();
    }

    /**
     * Creates an <code>Event</code> object.
     *
     * @param input User's full input string.
     * @return <code>Event</code> object.
     * @throws DukeException If description or at field for <code>Event</code> is missing.
     */
    public static Event createEvent(String input) throws DukeException {
        String commandParameter = getCommandParameter(input);
        if (commandParameter.isEmpty()) {
            throw new DukeException("OOPS!!! The description of a event task cannot be empty.");
        }

        String description;
        String taskEventDate;
        try {
            description = commandParameter.split("/at")[0].trim();
            taskEventDate = commandParameter.split("/at")[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Please enter valid task details. e.g Event task description /at yyyy-MM-dd HH:mm");
        }
        if (description.isEmpty()) {
            throw new DukeException("Please enter valid task details.");
        }
        if (taskEventDate.isEmpty()) {
            throw new DukeException("Please enter valid task details.");
        }


        boolean dateTimeFormatChecker = isValidDateTimeFormat("yyyy-MM-dd HH:mm", taskEventDate, Locale.ENGLISH);
        // to check if the user enter the correct date format
        if (!dateTimeFormatChecker) {
            throw new DukeException("Please enter correct event Date yyyy-MM-dd HH:mm, example: 2019-12-31 11:10");
        }

        LocalDateTime formatDateTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        formatDateTime = LocalDateTime.parse(taskEventDate, formatter);

        return new Event(description, formatDateTime);
    }



}
















