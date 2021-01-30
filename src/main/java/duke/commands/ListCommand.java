package duke.commands;

import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

public class ListCommand {
    public String execute(Ui ui, Storage storage, TaskList taskList) {
        String toPrint = ui.indentPrint("Here are the tasks in your list:");
        for (int i = 0;i < taskList.getSize();i++) {
            toPrint += ui.indentPrint((i + 1) + ". " + taskList.getTask(i).toString());
        }
        return toPrint;
    }
}
