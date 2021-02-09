package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

/**
 *This Parser class is to parser users' command and create todo, deadline, event tasks.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Parser {

    //public TaskList tasks;

    private static String commandWord;

    /**
     * This constructs parser with command string.
     *
     * @param commandWord user command string
     */
    public Parser(String commandWord) {
        Parser.commandWord = commandWord;
    }

    /**
     * This function is get key command word from full command.
     *
     * @param fullCommand tasks' full command
     * @return tasks' commandWord
     */
    public static String getCommand(String fullCommand) {
        commandWord = fullCommand.trim().split(" ")[0];
        return commandWord;
    }

    /**
     * This function is create todo object in task arraylist.
     *
     * @param line tasks' full command
     * @return tasks' Todo
     * @throws TaskException if empty description for todo can
     *                              throw this exception.
     */
    public static Todo createTodo(String line) throws TaskException {
        String substring = line.trim().substring("todo".length());
        String description = substring.trim();
        if (description.isEmpty()) {
            throw new TaskException("\nOOPS!!! Empty description for TODO");
        }
        return new Todo(substring.trim());
    }

    /**
     * This function is create deadline object in task arraylist.
     *
     * @param line tasks' full command
     * @return tasks' Deadline and by
     * @throws TaskException if empty description for deadline and /by can
     *                              throw this exception.
     */
    public static Deadline createDeadline(String line) throws TaskException {
        String description = line.substring("deadline".trim().length());

        if (description.isEmpty()) {
            throw new TaskException("\nOOPS!!! Empty description for Deadline");
        }
        if (!description.contains("/by")) {
            throw new TaskException("\nOOPS!!!: need '/by' for DEADLINE");
        }
        if (description.trim().split("/by",2)[1].isBlank()) {
            throw new TaskException("\nOOPS!!!:  Empty description for Event /by");
        }
        return new Deadline(line.trim().substring("deadline".length()).trim().split(" /by")[0],
                line.trim().split("/by ")[1]);
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    public static Event createEvent(String line) throws TaskException {
        String description = line.substring("event".trim().length());

        if (description.isEmpty()) {
            throw new TaskException("\nOOPS!!! Empty description for Event");
        }
        if (!description.contains("/at")) {
            throw new TaskException("\nOOPS!!!: need '/at' for Event");
        }
        if (description.trim().split("/at",2)[1].isBlank()) {
            throw new TaskException("\nOOPS!!!:  Empty description for Event /at");
        }
        return new Event(line.trim().substring("event".length()).trim().split(" /at")[0],
                    line.trim().split("/at ")[1]);

    }

}


