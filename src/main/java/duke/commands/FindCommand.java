package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

public class FindCommand extends Command {
    protected TaskList findResult;

    public FindCommand() {
        findResult = new TaskList();
    }

    public String execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException {
        if (others.isEmpty()) {
            throw new DukeException("The find term cannot be empty.");
        }
        for (int i = 0;i < taskList.getSize();i++) {
            if (taskList.getTask(i).getDescription().contains(others)) {
                findResult.addTask(taskList.getTask(i));
            }
        }
        String toPrint = ui.indentPrint("Here are the matching tasks in your list:");
        for (int j = 0;j < findResult.getSize();j++) {
            toPrint += ui.indentPrint((j + 1) + ". " + findResult.getTask(j).toString());
        }
        return toPrint;
    }
}
