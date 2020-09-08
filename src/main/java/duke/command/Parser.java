package duke.command;

import duke.Tasks.Deadline;
import duke.Tasks.Todo;

public class Parser {

    public static Ui ui;

    static TaskList tasks;

    private static String commandWord;

    public Parser(String commandWord) {
        Parser.commandWord = commandWord;
    }

    public static String getCommand(String fullCommand) {
        commandWord = fullCommand.trim().split(" ")[0];
        return commandWord;
    }

    public static Todo createTodo(String line) throws TaskException {
        String substring = line.trim().substring("todo".length());
        String description = substring.trim();
        if (description.isEmpty()) {
            throw new TaskException("Error: Empty description for TODO");
        }
        return new Todo(substring.trim());
    }

    public static Deadline createDeadline(String line) throws TaskException {
        String description = line.substring("deadline".trim().length());

        if (description.isEmpty()) {
            throw new TaskException("Error: Empty description for TODO");
        }
        if (!description.contains("/by")) {
            throw new TaskException("☹ OOPS!!!: need '/by' for DEADLINE");
        }
        return new Deadline(line.trim().substring("deadline".length()).trim().split(" /by")[0],
                line.trim().split("/by ")[1]);
    }

}


