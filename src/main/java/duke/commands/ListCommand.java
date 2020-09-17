package duke.commands;

import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

public class ListCommand {
    public void execute(Ui ui, Storage storage, TaskList taskList) {
        ui.indentPrint("Here are the tasks in your list:");
        for(int i=0;i<taskList.getSize();i++){
            ui.indentPrint((i+1)+". "+taskList.getTask(i).toString());
        }
    }
}
