package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.OtherCommand;
import duke.command.TagCommand;
import duke.command.TodoCommand;
import duke.exceptions.DukeException;

public class Parser {

    private static String[] commandSplit(String s, String splitBy) {
        return s.split(splitBy);
    }

    public static Command getCommand(String userInput) throws DukeException {
        String[] cmd = Parser.commandSplit(userInput, "\\s+");
        switch(cmd[0]) {
        case "list":
            return new ListCommand();
        case "done":
            try {
                return new DoneCommand(userInput.split(" ")[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The task does not exist.");
            } catch (NumberFormatException e) {
                throw new DukeException("\u2639 OOPS!!! Please specify the task need to be done.");
            }
        case "delete":
            try {
                return new DeleteCommand(userInput.split(" ")[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The task does not exist.");
            } catch (NumberFormatException e) {
                throw new DukeException("\u2639 OOPS!!! Please specify the number of the task need to be delete.");
            }
        case "todo":
            try {
                return new TodoCommand(userInput.substring(5));
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");
            }
        case "deadline":
            try {
                String deadlineSpliter = "/by";
                String[] deadlineContent = userInput.split(deadlineSpliter);
                LocalDate.parse(deadlineContent[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return new DeadlineCommand(
                        deadlineContent[0].substring(9, deadlineContent[0].length() - 1),
                        deadlineContent[1].trim());
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The keyword /by is missing.");
            } catch (java.time.format.DateTimeParseException e) {
                throw new DukeException("\u2639 OOPS!!! The time format is illegal.Format should be in \"yyyy-MM-dd\" ");
            }
        case "event":
            try {
                String eventSpliter = "/at";
                String[] eventContent = userInput.split(eventSpliter);
                LocalDate.parse(eventContent[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return new EventCommand(
                        eventContent[0].substring(6, eventContent[0].length() - 1),
                        eventContent[1].trim());
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The description of a event cannot be empty.");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The keyword /at is missing.");
            } catch (java.time.format.DateTimeParseException e) {
                throw new DukeException("\u2639 OOPS!!! The time format is illegal.Format should be in \"yyyy-MM-dd\"");
            }
        case "find":
            return new FindCommand(userInput.substring(5));
        case "tag":
            //valid command format: tag 1 /t xxxxxxx
            try {
                String tagSpliter = "/t";
                String[] tagCommandContent = userInput.split(tagSpliter);
                int index = Integer.parseInt(tagCommandContent[0].split(" ")[1]);
                return new TagCommand(index, tagCommandContent[1]);
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The description of the tag cannot be empty.");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("\u2639 OOPS!!! The keyword /t is missing.");
            } catch (NumberFormatException e) {
                throw new DukeException("\u2639 OOPS!!! Please specify the number of the task need to be tagged.");
            }
        default:
            return new OtherCommand(cmd[0]);
        }
    }

}
