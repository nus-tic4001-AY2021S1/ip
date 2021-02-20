import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import command.Command;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.DoneCommand;
import command.EventCommand;
import command.FindCommand;
import command.InvalidCommand;
import command.ListCommand;
import command.TodoCommand;
import exceptions.DukeException;


public class Parser {
    private static String deadlineSplitter = "/by";
    private static String eventSplitter = "/at";

    /**
     * @param s user inputs
     * @param splitBy a specified string string splitter
     * @return a array of string contains split user commands
     */
    private static String[] splitCommand(String s, String splitBy) {
        return s.split(splitBy);
    }

    /**
     * This method will process the user input to get the respective user commands for each actions.
     * It will also check if the date are in the correct format.
     * @param userInput
     * @return the command for each user actions. e.g. list, done, delete etc.
     * @throws DukeException
     */
    public static Command getCommand(String userInput) throws DukeException {
        String[] cmd = Parser.splitCommand(userInput , "\\s+");
        switch(cmd[0]) {
        case "list":
            return new ListCommand();
        case "done":
            try {
                return new DoneCommand(userInput.split(" ")[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! There is no such task.");
            } catch (NumberFormatException e) {
                throw new DukeException("☹ OOPS!!! Please let me know which task need to be done?.");
            }
        case "delete":
            try {
                return new DeleteCommand(userInput.split(" ")[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! There is no such task.");
            } catch (NumberFormatException e) {
                throw new DukeException("☹ OOPS!!! Please tell me the number of the task need to be delete.");
            }
        case "todo":
            try {
                return new TodoCommand(userInput.substring(5));
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
            }
        case "deadline":
            try {
                String[] deadlineContent = userInput.split(deadlineSplitter);
                LocalDate.parse(deadlineContent[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return new DeadlineCommand(deadlineContent[0].substring(9, deadlineContent[0].length() - 1),
                        deadlineContent[1].trim());
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The keyword /by is missing.");
            } catch (java.time.format.DateTimeParseException e) {
                throw new DukeException("☹ OOPS!!! "
                        + "The date format is incorrect.Format should be in \"yyyy-MM-dd\", please enter again.");
            }
        case "event":
            try {
                String[] eventContent = userInput.split(eventSplitter);
                LocalDate.parse(eventContent[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return new EventCommand(eventContent[0].substring(6, eventContent[0].length() - 1),
                        eventContent[1].trim());
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The keyword /at is missing.");
            } catch (java.time.format.DateTimeParseException e) {
                throw new DukeException("☹ OOPS!!! "
                        + "The date format is incorrect.Format should be in \"yyyy-MM-dd\"，please enter again.");
            }
        case "find":
            return new FindCommand(userInput.substring(5));
        default:
            return new InvalidCommand(cmd[0]);
        }
    }

}
