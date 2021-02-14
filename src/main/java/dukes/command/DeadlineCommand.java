package dukes.command;

import dukes.Ui;
import dukes.exception.DukeException;
import dukes.storage.Storage;
import dukes.tasks.Deadline;
import dukes.tasks.Task;
import dukes.tasks.TaskList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeadlineCommand extends Command {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy, hh:mm a");

    /**
     * Adds a Deadline task to the task list and save the list to disk and display to user.
     *
     * @param input  The strings contains keywords and descriptions.
     * @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files,temporary save and store in hard disk.
     */
    @Override
    public String execute(String input, TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task taskWord;
        if (input.length() < 10) {
            throw new DukeException("OOPS!!! The description of a deadline cannot be empty.\n");
        }
        String[] splitDetail = input.split("/by");
        if (splitDetail.length < 2) {
            throw new DukeException("OOPS!!! Please refer to [Help] to key in Correct Format.\n");
        }
        String task = splitDetail[0].substring(9);
        String by = splitDetail[1];
        try {
            Date byDeadline = format.parse(by);
            taskWord = new Deadline(task, formatter.format(byDeadline));
        } catch (Exception e) {
            throw new DukeException("Please input a date in this format : dd/MM/yyyy HHmm");
        }
        tasks.list.add(taskWord);
        storage.saveTaskFile(tasks.list);
        return ui.printAddedMessage(taskWord, tasks.list.size());

    }
}
