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
import duke.tasks.Deadline;
import duke.tasks.Todo;

import java.time.LocalDate;
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
    private static String getElement(String input) {
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
        String commandElement = getElement(input);
        if (commandElement.isEmpty()) {
            throw new DukeException("OOPS!!! The description of a event task cannot be empty.");
        }

        String description;
        String taskEventDate;
        try {
            description = commandElement.split("/at")[0].trim();
            taskEventDate = commandElement.split("/at")[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Please enter valid task details. e.g Event task description /at yyyy-MM-dd HH:mm");
        }
        if (description.isEmpty()) {
            throw new DukeException("Please enter valid task details. The description of a task cannot be empty.");
        }
        if (taskEventDate.isEmpty()) {
            throw new DukeException("Please enter valid task details. The description of a task cannot be empty.");
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



    /**
     * Creates a <code>Deadline</code> object.
     *
     * @param input User's full input string.
     * @return <code>Deadline</code> object.
     * @throws DukeException If description or by field for <code>Deadline</code> is missing.
     */
    public static Deadline createDeadline(String input) throws DukeException {
        String commandElement = getElement(input);
        if (commandElement.isEmpty()) {
            throw new DukeException("OOPS!!! The description of a deadline task cannot be empty.");
        }

        String description;
        String taskDeadline;
        try {
            description = commandElement.split("/by")[0].trim();
            taskDeadline = commandElement.split("/by")[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Please enter valid task details. e.g Deadline task description /by yyyy-MM-dd");
        }
        if (description.isEmpty()) {
            throw new DukeException("Please enter valid task details. The description of a task cannot be empty.");
        }
        if (taskDeadline.isEmpty()) {
            throw new DukeException("Please enter valid task details. The description of a task cannot be empty.");
        }

        boolean dateTimeFormatChecker = isValidDateTimeFormat("yyyy-MM-dd", taskDeadline, Locale.ENGLISH);
        // to check if the user enter the correct date format
        if (!dateTimeFormatChecker) {
            throw new DukeException("Please enter correct deadline Due Date yyyy-MM-dd, example: 2019-12-31");
        }

        LocalDate dueDate = LocalDate.parse(taskDeadline);

        return new Deadline(description, dueDate);
    }


    /**
     * Creates a <code>Todo</code> object.
     *
     * @param input User's full input string.
     * @return <code>Todo</code> object.
     * @throws DukeException If description for <code>Todo</code> is missing.
     */
    public static Todo createTodo(String input) throws DukeException {
        String commandElement = getElement(input);
        if (commandElement.isEmpty()) {
            throw new DukeException("OOPS!!! The description of a todo task cannot be empty.");
        }
        return new Todo(commandElement);
    }

    /**
     * Gets find keywords from user's input.
     *
     * @param input User's full input string.
     * @return search keywords.
     * @throws DukeException If keyword is missing.
     */
    public static String findTaskDetail(String input) throws DukeException {

        String taskDetail;
        int len = input.split(" ").length; // to check who many words
        String[] lineArr = input.split(" ", 2);
        String commandFirstWord = input.split(" ")[0].toLowerCase();

        if (len > 1) {
            taskDetail = lineArr[1].trim();  // filter out the first words
        } else {
            throw new DukeException("OOPS!!! The description of a " + commandFirstWord + " cannot be empty.");
        }

        return taskDetail;
    }



}
















