package duke;

import duke.tasks.TaskList;

import java.io.IOException;

public class ByeCommand extends Command {
    public void execute(Ui ui, Storage storage, TaskList taskList){
        storage.toExit();
        ui.byeToUser();
    }
}
