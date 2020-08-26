package Duke.parser;

import Duke.exception.DukeException;
import Duke.task.Deadline;
import Duke.task.Event;
import Duke.task.Todo;

/**
 * public static getCommandWord(String fullCommand): Returns a the command word i.e., the first word of the given fullCommand
 * e.g., Parser.getCommandWord("todo read book") "todo"
 * public static createTodo(String fullCommand): Returns a Todo object to match the fullCommand. Assumption: the fullCommand is for creating a Todo object.
 * e.g., Parser.createTodo("todo read book") a Todo object containing the description "read book"
 */
public class Parser {

    public static String getCommandWord(String fullCommand) {
        String command = fullCommand.trim().split(" ")[0];
        return command;
    }

    public static Todo createTodo(String fullCommand) throws DukeException {
        String description = fullCommand.substring("todo".length()).trim();
        assert (("todo " + description).equals(fullCommand)) : "Something went wrong during the substring for todo description";
        if (description.isEmpty()) {
            throw new DukeException("Empty description for TODO");
        } else {
            return new Todo(description);
        }
    }

    public static Deadline createDeadLine(String fullCommand) throws DukeException {
        int idxOfBy = fullCommand.indexOf("/by");
        if (idxOfBy < 0) {
            throw new DukeException("Deadline does not contain /by");
        }

        String description = fullCommand.substring(0, idxOfBy).substring("deadline".length()).trim();
        assert (fullCommand.contains(description)) : "Something went wrong during the substring for deadline description";
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

    public static Event createEvent(String fullCommand) throws DukeException {
        int idxOfBy = fullCommand.indexOf("/at");
        if (idxOfBy < 0) {
            throw new DukeException("Event does not contain /at");
        }

        String description = fullCommand.substring(0, idxOfBy).substring("event".length()).trim();
        assert (fullCommand.contains(description)) : "Something went wrong during the substring for event description";
        if (description.isEmpty() || description.equals("")) {
            throw new DukeException("Empty description for EVENT");
        }
        String schedule = fullCommand.substring(idxOfBy, fullCommand.length()).substring("/at".length()).trim();
        if (schedule.isEmpty() || schedule.equals("")) {
            throw new DukeException("Empty schedule for EVENT");
        }
        return new Event(description, schedule);
    }

    public static int parseTaskNum(String fullCommand) {
        int index = fullCommand.contains("undone") ?
                Integer.parseInt(fullCommand.substring("undone".length()).trim()) : Integer.parseInt(fullCommand.substring("done".length()).trim());
        return index;
    }

}
