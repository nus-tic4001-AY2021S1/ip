package Dukes.command;

import Dukes.Storage;
import Dukes.TaskList;
import Dukes.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)  {
        ui.showExitMessage(tasks.list);
        storage.saveTaskFile(tasks.list);
    }

}
