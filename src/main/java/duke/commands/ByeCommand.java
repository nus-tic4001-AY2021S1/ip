package duke.commands;

import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

public class ByeCommand extends Command {
    public void execute(Ui ui, Storage storage, TaskList taskList){
        storage.toExit();
        ui.byeToUser();
    }
}
