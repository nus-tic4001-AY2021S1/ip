package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

public class DeleteCommand extends Command {
    public String execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException {
        if (others.isEmpty()) {
            throw new DukeException("The index of a delete command cannot be empty.");
        }
        int index = Integer.parseInt(others);
        String toPrint = ui.indentPrint("Noted. I've removed this task: ");
        toPrint += ui.indentPrint("  " + taskList.deleteTaskAt(index - 1).toString());
        storage.saveToFile(taskList);
        return toPrint;
    }
}
