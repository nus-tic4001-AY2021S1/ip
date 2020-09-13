package Dukes.command;

import Dukes.Storage;
import Dukes.Task;
import Dukes.TaskList;
import Dukes.Ui;
import Dukes.DukeException;

public abstract class Command {

    protected Task task;
    protected int index;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return false;
    }

}
