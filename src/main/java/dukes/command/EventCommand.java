package dukes.command;

import dukes.Ui;
import dukes.exception.DukeException;
import dukes.storage.Storage;
import dukes.tasks.Event;
import dukes.tasks.Task;
import dukes.tasks.TaskList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventCommand extends Command {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");

    /**
     * Adds a Event task to the task list and save the list to disk and display to user.
     *
     * @param input  The strings contains keywords and descriptions.
     * @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files,temporary save and store in hard disk.
     */
    @Override
    public String execute(String input, TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task taskWord;
        if (input.length() < 7 || input.isEmpty()) {
            throw new DukeException("OOPS!!! The description of an event cannot be empty.\n");
        }
        String[] splitEvent = input.split("/at");
        if (splitEvent.length < 2) {
            throw new DukeException("OOPS!!! Please refer to [Help] to key in Correct Format.\n");
        }
        String event = splitEvent[0].substring(6);
        String time = splitEvent[1];
        try {
            Date timeEvent = format.parse(time);
            taskWord = new Event(event, formatter.format(timeEvent));
        } catch (Exception e) {
            throw new DukeException("Please input a date in this format : dd/MM/yyyy HHmm");
        }
        tasks.list.add(taskWord);
        storage.saveTaskFile(tasks.list);
        return ui.printAddedMessage(taskWord, tasks.list.size());
    }

}
