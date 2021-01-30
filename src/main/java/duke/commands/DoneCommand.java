package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

public class DoneCommand {
    public String execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException {
        if (others.isEmpty()) {
            throw new DukeException("The index of a done command cannot be empty.");
        }
        int index = Integer.parseInt(others);
        taskList.setDoneAt(index - 1);
        String toPrint = ui.indentPrint("Nice! I've marked this task as done: ");
        toPrint += ui.indentPrint("  " + taskList.getTask(index - 1).toString());
        storage.saveToFile(taskList);
        return toPrint;
    }
}
