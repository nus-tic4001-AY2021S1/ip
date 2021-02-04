package duke;

import duke.commands.ByeCommand;
import duke.commands.DeadlineCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.DuplicateCommand;
import duke.commands.EventCommand;
import duke.commands.FindCommand;
import duke.commands.ListCommand;
import duke.commands.TodoCommand;
import duke.tasks.TaskList;

/**
 * Parser class handles command parser and identify different keywords with switch cases.
 */
public class Parser {
    public String getCommand(String input, Storage store, Ui ui, TaskList taskList) throws Exception {
        int index;
        String command;
        String others;
        if (input.contains(" ")) {
            command = input.split(" ",2)[0];
            others = input.split(" ",2)[1];
        } else {
            command = input;
            others = "";
        }
        switch (command) {
        case "bye":
            return new ByeCommand().execute(ui,store,taskList);
        case "list":
            return new ListCommand().execute(ui,store,taskList);
        case "done":
            return new DoneCommand().execute(others,ui,store,taskList);
        case "delete":
            return new DeleteCommand().execute(others,ui,store,taskList);
        case "todo":
            return new TodoCommand().execute(others,ui,store,taskList);
        case "deadline":
            return new DeadlineCommand().execute(others,ui,store,taskList);
        case "event":
            return new EventCommand().execute(others,ui,store,taskList);
        case "find":
            return new FindCommand().execute(others,ui,store,taskList);
        case "duplicate":
            return new DuplicateCommand().execute(others,ui,store,taskList);
        default:
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
