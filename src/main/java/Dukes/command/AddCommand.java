package Dukes.command;

import Dukes.Storage;
import Dukes.Task;
import Dukes.TaskList;
import Dukes.Ui;

public class AddCommand extends Command {
    public AddCommand(Task task) {
        super.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.list.add(task);
        ui.printAddedMessage(task, tasks.list.size());
    }
}
