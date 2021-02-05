package dukes.command;

import dukes.storage.Storage;
import dukes.tasks.TaskList;
import dukes.Ui;
/**
 * Create an ExitCommand. It ends and exit the programme and stores user's tasks.
 */

public class ExitCommand extends Command {
    /**
     * Saves the tasks into storage and display bye message to the user.
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @return a goodbye message will be show.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage)  {
        return ui.showExitMessage(tasks.list);
    }

    /**
     * Checks if this object is an <code>ExitCommand</code>.
     * @return Whether this command is an exit command.
     */
    public boolean isExit() {
        return true;
    }

}
