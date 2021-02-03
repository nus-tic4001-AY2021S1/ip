package dukes.command;

import dukes.storage.Storage;
import dukes.tasks.TaskList;
import dukes.Ui;
/**
 * Create a ListCommand. It lists all tasks for users.
 */

public class ListCommand extends Command {

    /**
     * Constructor for <code>ListCommand</code>.
     */
    public ListCommand() {
        super();
    }

    /**
     * List all the tasks in the task list that was saved on the disk, and display to user.
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws IndexOutOfBoundsException if there is empty list.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int count = tasks.list.size();
            if (count == 0) {
                return ("OOPS!!! There are no tasks in your list.");
            } else {
                String toPrint = ui.indentPrint("     Here are the tasks in your list:");
                for (int i = 0; i < tasks.list.size(); i++) {
                    toPrint += ui.indentPrint("    " + (i + 1) + "." + tasks.list.get(i));
                }
                return toPrint;
            }
        } catch (IndexOutOfBoundsException e) {
            return ("current task is empty in your list.");
        }
    }
}
