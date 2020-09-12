package duke;

/**
 * A <code>Parser</code> class contains methods that deals with parsing
 * user commands to extract meaningful details from it.
 */
public class Parser {
    /**
     *  Get the command word from user's input string.
     *  @param fullCommand User's full input string.
     *  @return Command word from user's input string.
     */
    public static String getCommand(String fullCommand) {
        return fullCommand.split(" ")[0];
    }

    /**
     * Creates a <code>Todo</code> object.
     *
     * @param fullCommand User's full input string.
     * @return <code>Todo</code> object.
     * @throws DukeException If description for <code>Todo</code> is missing.
     */
    public static Todo createTodo(String fullCommand) throws DukeException {
        String commandParameter = getCommandParameter(fullCommand);
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a todo task cannot be empty.");
        }
        return new Todo(commandParameter);
    }

    /**
     * Creates a <code>Deadline</code> object.
     *
     * @param fullCommand User's full input string.
     * @return <code>Deadline</code> object.
     * @throws DukeException If description or by field for <code>Deadline</code> is missing.
     */
    public static Deadline createDeadline(String fullCommand) throws DukeException {
        String commandParameter = getCommandParameter(fullCommand);
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a deadline task cannot be empty.");
        }

        String description;
        String by;
        try {
            description = commandParameter.split("/by")[0].trim();
            by = commandParameter.split("/by")[1].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new DukeException("The by field of the deadline task is missing.");
        }
        if (description.isEmpty()){
            throw new DukeException("The description of a deadline task cannot be empty.");
        }
        return new Deadline(description, by);
    }

    /**
     * Creates an <code>Event</code> object.
     *
     * @param fullCommand User's full input string.
     * @return <code>Event</code> object.
     * @throws DukeException If description or at field for <code>Deadline</code> is missing.
     */
    public static Event createEvent(String fullCommand) throws DukeException {
        String commandParameter = getCommandParameter(fullCommand);
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a deadline task cannot be empty.");
        }

        String description;
        String at;
        try {
            description = commandParameter.split("/at")[0].trim();
            at = commandParameter.split("/at")[1].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new DukeException("The at field of the event task is missing.");
        }
        if (description.isEmpty()){
            throw new DukeException("The description of an event task cannot be empty.");
        }
        return new Event(description, at);
    }

    private static String getCommandParameter(String fullCommand) {
        return fullCommand.replace("todo", "")
                .replace("deadline", "")
                .replace("event", "")
                .replace("done", "")
                .replace("delete", "")
                .replace("list", "")
                .trim();
    }

    /**
     *  Gets task index from user's full input string.
     *
     * @param fullCommand User's full input string.
     * @return Task index.
     * @throws DukeException If task index is missing or invalid.
     */
    public static int getTaskIndex(String fullCommand) throws DukeException {
        String commandParameter = getCommandParameter(fullCommand);
        if (commandParameter.isEmpty()){
            throw new DukeException("The description of a deadline task cannot be empty.");
        }

        int taskIndex;
        try {
            taskIndex = Integer.parseInt(commandParameter);
        } catch(NumberFormatException e) {
            throw new DukeException("The task index is invalid.");
        }
        return taskIndex - 1;
    }
}
