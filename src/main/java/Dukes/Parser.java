package Dukes;

import Dukes.Exceptions.DukeException;
import Dukes.Tasks.Deadline;
import Dukes.Tasks.Event;
import Dukes.Tasks.Task;
import Dukes.Tasks.ToDo;
import Dukes.command.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     * @throws <code>DukeException</code>If a new command cannot be created due to invalid input parameters.
     */

    public static Command parse(String input) throws DukeException {
        Task taskWord;
        String keyword;
        Command c = null;
        String action = input.split(" ")[0].toLowerCase();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy, hh:mm a");
        switch (action) {
            case "list":
                c = new ListCommand();
                break;

            case "todo":
                if (input.length() < 6) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                taskWord = new ToDo(input.substring(5));
                c = new AddCommand(taskWord);
                break;

            case "delete":
                if (input.isEmpty() || input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! There is no specific task to delete.\n");
                }
                int toDelete = Ui.indexDetails(input);
                c = new DeleteCommand(toDelete);
                break;

            case "done":
                if (input.length() < 6) {
                    throw new DukeException("please key in correct format.\n");
                }
                int toEdit = Ui.indexDetails(input);
                c = new DoneCommand(toEdit);
                break;

            case "deadline":
                if (input.length() < 10) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                }
                String[] splitDetail = input.split("/by");
                if (splitDetail.length < 2) {
                    throw new DukeException("Please specify the deadline date and time\n");
                }
                String task = splitDetail[0].substring(9);
                String by = splitDetail[1];
                try {
                    Date byDeadline = format.parse(by);
                    taskWord = new Deadline(task, formatter.format(byDeadline));
                }catch (Exception e){
                    throw new DukeException("Please input a date in this format : dd/MM/yyyy HHmm");
                }
                c = new AddCommand(taskWord);
                break;

            case "event":
                if (input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n");
                }
                String[] splitEvent = input.split("/at");
                if (splitEvent.length < 2) {
                    throw new DukeException("Please specify the event time\n");
                }
                String event = splitEvent[0].substring(6);
                String time = splitEvent[1];
                try {
                    Date timeEvent = format.parse(time);
                    taskWord = new Event(event, formatter.format(timeEvent));
                }catch(Exception e){
                    throw new DukeException("Please input a date in this format : dd/MM/yyyy HHmm");
                }
                c = new AddCommand(taskWord);
                break;
            case "find":
                if (input.length() < 6) {
                    throw new DukeException("☹ OOPS!!! The description of a find cannot be empty.\n");
                }
                try {
                    keyword = input.substring(5).toLowerCase();
                    c = new FindCommand(keyword);
                    break;
                } catch (NumberFormatException e) {
                    throw new DukeException("please key in correct format");
                }

            case "bye":
            case "exit":
                c = new ExitCommand();
                break;

            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        return c;
    }

}

