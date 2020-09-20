package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class EventCommand extends Command {
    private final String fullCommand;

    public EventCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(Parser.createEvent(fullCommand));
        tasks.setIsInitialized(false);
        storage.saveTasks(tasks);
        ui.printAddedTask(tasks);
    }
}