package dukes.command;

import dukes.exception.DukeException;
import dukes.storage.Storage;
import dukes.tasks.Task;
import dukes.tasks.TaskList;
import dukes.Ui;


/**
 * Creates a FindCommand. It search for tasks when given keyword.
 */
public class FindCommand extends Command {
    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * Finds the tasks with the given keyword.
     *  @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files.
     * @return
     */

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        TaskList filteredTasks = new TaskList();
        int count = 0;
        try {
            for (Task task : tasks.list) {
                String description = task.getDescription().toLowerCase();
                if (description.contains(keyWord)) {
                    filteredTasks.list.add(task);
                    count += 1;
                }
            }
            if (count == 0) {
                throw new DukeException("OOPS!!! There is no matching task in the list");
            } else {
                String toPrint = ui.indentPrint("Here are the matching tasks in your list:");
                for (int i = 0; i < filteredTasks.list.size(); i++) {
                    toPrint += ui.indentPrint((i + 1) + "." + filteredTasks.list.get(i));
                }
                return toPrint;
            }
        } catch (IndexOutOfBoundsException e) {
            return ("Current task is empty in your list.");
        }
    }
}


