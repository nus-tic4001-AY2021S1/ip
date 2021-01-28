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

import duke.exceptions.DukeException;
import duke.ui.Ui;

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
                return new DoneCommand(getSecondWord(input));
            case "delete":
                return new DeleteCommand(getSecondWord(input));
            case "todo":
                return new TodoCommand(filterTaskDetails(input));
            case "deadline":
                return new DeadLineCommand(filterTaskDetails(input));
            case "event":
                return new EventCommand(filterTaskDetails(input));
            case "find":
                return new FindCommand(filterTaskDetails(input));
            case "clear":
                return new ClearCommand(input);
            default:
                return new UnknownCommand(input);
            }

        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }


        return null;
    }


    private static String[] getInputArray(String input) {
        return input.trim().replaceAll(KEYWORD_MULTIPLE_SPACE, KEYWORD_ONE_SPACE).split(KEYWORD_ONE_SPACE, 2);
    }

    /**
     * A method to parser a String.
     * Assume that the Task Details start from the second words. This method can filter out the first words.
     *
     * @param line A String that holds the user input.
     * @throws DukeException If Task Detail is Empty/Null:
     *          Returning to Main MenuShow the message to user and notify the user.
     * */
    public static String filterTaskDetails(String line) throws DukeException {
        String taskDetail;
        int len = line.split(" ").length; // to check who many words
        String[] lineArr = line.split(" ", 2);
        String commandFirstWord = line.split(" ")[0].toLowerCase();

        if (len > 1) {
            taskDetail = lineArr[1].trim();  // filter out the first words
        } else {
            throw new DukeException("OOPS!!! The description of a " + commandFirstWord + " cannot be empty.");
        }
        return taskDetail;
    }

    /**
     * A method to parser a String and get the second word from the string.
     *
     * @param input A String that holds the user input.
     */

    public static String getSecondWord(String input) {
        String commandSecondWord = input.split(" ")[1];
        return commandSecondWord;
    }


    /**
     * A method to parser a String and process necessary steps and tasks based on the user inputs.
     * Assume that the Task Details start from the second words. This method can filter out the first words.
     *  @param input       A String that holds the user input.
     * @param ui          A Ui that show message to user.
     * @param programExit A ProgramExit  to check if it is needed to exit the program.
     * @param taskList    A Task TodoList contains the ArrayList of Task objects,
     *                    contains the task list e.g., it has operations to add/delete tasks in the list
     */




}
















