package Dukes.command;

import Dukes.Storage;
import Dukes.TaskList;
import Dukes.Task;
import Dukes.Ui;
import Dukes.DukeException;

public class DoneCommand extends Command {
    public DoneCommand(int index) {
        super.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            Task doneTask = tasks.list.get(index).markAsDone();
            ui.printDoneMessage(doneTask);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please key in a number from the list");
        }
    }
}
