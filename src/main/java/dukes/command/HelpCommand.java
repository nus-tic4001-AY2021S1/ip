package dukes.command;

import dukes.Ui;
import dukes.exception.DukeException;
import dukes.storage.Storage;
import dukes.tasks.TaskList;

public class HelpCommand extends Command {

    /**
     * Parses the arguments of the Command and executes it.
     *
     * @param tasks   the TaskList of Tasks
     * @param ui      The User Interface
     * @param storage Storage
     *
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage)  {
        return ui.showHelp();
    }
}
