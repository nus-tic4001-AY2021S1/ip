package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateCommand {
    public String execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException {
        int[][] duplicate = new int[taskList.getSize()][taskList.getSize()];
        int index;
        boolean noDuplicate = true;
        for (int i = 0; i < taskList.getSize(); i++) {
            index = 1;
            for (int j = i + 1; j < taskList.getSize(); j++) {
                if (duplicate[j][0] == 0 && duplicate[i][0] != -1) {
                    if (taskList.getTask(i).isEquals(taskList.getTask(j))) {
                        duplicate[i][0]++;
                        duplicate[i][index] = j;
                        duplicate[j][0] = -1;
                        index++;
                        noDuplicate = false;
                    }
                }
            }
        }
        String toPrint;
        if (noDuplicate) {
            toPrint = ui.indentPrint("There is no duplicated task in your list.");
        } else {
            toPrint = ui.indentPrint("Here are duplicated tasks in your list:");
            for (int i = 0; i < taskList.getSize(); i++) {
                if (duplicate[i][0] > 0) {
                    toPrint += ui.indentPrint((i + 1) + ". " + taskList.getTask(i).toString());
                    toPrint += ui.indentPrint("Duplicates:");
                    for (int j = 1; j <= duplicate[i][0]; j++) {
                        toPrint += ui.indentPrint((duplicate[i][j] + 1)
                                + ". " + taskList.getTask(duplicate[i][j]).toString());
                    }
                }
            }
        }
        return toPrint;
    }
}
