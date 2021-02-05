package dukes.parser;

import dukes.Ui;
import dukes.command.AddCommand;
import dukes.command.Command;
import dukes.command.DeleteCommand;
import dukes.command.DoneCommand;
import dukes.command.ExitCommand;
import dukes.command.ListCommand;
import dukes.command.FindCommand;
import dukes.command.HelpCommand;
import dukes.exception.DukeException;
import dukes.tasks.Deadline;
import dukes.tasks.Event;
import dukes.tasks.Task;
import dukes.tasks.ToDo;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Task taskWord;
        String action = input.split(" ")[0].toLowerCase();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy, hh:mm a");
        switch (action) {
        case "list":
            return new ListCommand();
        case "todo":
            if (input.length() < 6) {
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }
            return  new AddCommand(new ToDo(input.substring(5)));
        case "delete":
            if (input.isEmpty() || input.length() < 7) {
                throw new DukeException("OOPS!!! There is no specific task to delete.\n");
            }
            int toDelete = Ui.indexDetails(input);
            return new DeleteCommand(toDelete);
        case "done":
            if (input.length() < 6) {
                throw new DukeException("please key in correct format.\n");
            }
            int toEdit = Ui.indexDetails(input);
            return new DoneCommand(toEdit);
        case "deadline":
            if (input.length() < 10) {
                throw new DukeException("OOPS!!! The description of a deadline cannot be empty.\n");
            }
            String[] splitDetail = input.split("/by");
            if (splitDetail.length < 2) {
                throw new DukeException("Please specify the deadline date and time.\n");
            }
            String task = splitDetail[0].substring(9);
            String by = splitDetail[1];
            try {
                Date byDeadline = format.parse(by);
                taskWord = new Deadline(task, formatter.format(byDeadline));
            } catch (Exception e) {
                throw new DukeException("Please input a date in this format : dd/MM/yyyy HHmm");
            }
            return new AddCommand(taskWord);
        case "event":
            if (input.length() < 7) {
                throw new DukeException("OOPS!!! The description of a event cannot be empty.\n");
            }
            String[] splitEvent = input.split("/at");
            if (splitEvent.length < 2) {
                throw new DukeException("Please specify the event date and time\n");
            }
            String event = splitEvent[0].substring(6);
            String time = splitEvent[1];
            try {
                Date timeEvent = format.parse(time);
                taskWord = new Event(event, formatter.format(timeEvent));
            } catch (Exception e) {
                throw new DukeException("Please input a date in this format : dd/MM/yyyy HHmm");
            }
            return new AddCommand(taskWord);
        case "find":
            if (input.length() < 6) {
                throw new DukeException("OOPS!!! The description of a find cannot be empty.\n");
            }
            try {
                return new FindCommand(input.substring(5).toLowerCase());
            } catch (NumberFormatException e) {
                throw new DukeException("please key in correct format.");
            }
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

