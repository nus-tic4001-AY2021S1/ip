package parser;

import exception.DukeException;
import data.Deadline;
import data.Event;
import data.Todo;

/**
 * Code structure referenced from https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/parser/Parser.java
 */
public class Parser {

    /**
     * Split the user input and return the command action to process
     * @param fullCommand
     * @return
     */
    public static String getCommandWord(String fullCommand) {
        String command = fullCommand.trim().split(" ")[0];
        return command;
    }

    public static String getKeyword(String fullCommand) {
        String keyword = fullCommand.trim().split(" ")[1];
        return keyword;
    }

    /**
     * Creates a Todo object and returns it.
     * @param fullCommand
     * @return
     * @throws DukeException
     */
    public static Todo createTodo(String fullCommand) throws DukeException {
        String description = fullCommand.substring("todo".length()).trim();
        //Use isBlank() rather than isEmpty(). isBlank() checks for whitespace
        if (description.isBlank()) {
            throw new DukeException("Empty description for TODO");
        } else {
            return new Todo(description);
        }

    }

    /**
     * Creates a Deadline object and returns it
     * @param fullCommand
     * @return
     * @throws DukeException
     */
    public static Deadline createDeadLine(String fullCommand) throws DukeException {
        int idxOfBy = fullCommand.indexOf("/by");
        if (idxOfBy < 0) {
            throw new DukeException("Deadline does not contain /by");
        }

        String description = fullCommand.substring(0, idxOfBy).substring("deadline".length()).trim();
        //Use isBlank() rather than isEmpty(). isBlank() checks for whitespace
        if (description.isEmpty() || description.equals("")) {
            throw new DukeException("Empty description for DEADLINE");
        }
        String deadline = fullCommand.substring(idxOfBy, fullCommand.length()).substring("/by".length()).trim();
        if (deadline.isEmpty() || deadline.equals("")) {
            throw new DukeException("Empty deadline for DEADLINE");
        }
//        return new Deadline(description, deadline);
        return new Deadline(description, deadline);
    }

    /**
     * Creates a Event object and returns it
     * @param fullCommand
     * @return
     * @throws DukeException
     */
    public static Event createEvent(String fullCommand) throws DukeException {
        int idxOfBy = fullCommand.indexOf("/at");
        if (idxOfBy < 0) {
            throw new DukeException("Event does not contain /at");
        }

        String description = fullCommand.substring(0, idxOfBy).substring("event".length()).trim();
        //assert (fullCommand.contains(description)) : "Something went wrong during the substring for event description";
        if (description.isEmpty() || description.equals("")) {
            throw new DukeException("Empty description for EVENT");
        }
        String schedule = fullCommand.substring(idxOfBy, fullCommand.length()).substring("/at".length()).trim();
        if (schedule.isEmpty() || schedule.equals("")) {
            throw new DukeException("Empty schedule for EVENT");
        }
        return new Event(description, schedule);
    }

    /**
     * Parses the user input for the idx of the Task and returns as Int
     * @param fullCommand
     * @return
     */
    public static int parseTaskNum(String fullCommand) {
        int index = fullCommand.contains("undone") ?
                Integer.parseInt(fullCommand.substring("undone".length()).trim()) : Integer.parseInt(fullCommand.substring("done".length()).trim());
        return index;
    }

}
