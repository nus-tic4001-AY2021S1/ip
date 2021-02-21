package duke.commands;

import duke.util.Storage;
import duke.exceptions.DukeException;
import duke.tasks.Task;
import duke.util.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

/** .
 * An abstract Command Class
 */
public abstract class Command {
    // An array list of task objects
    public ArrayList<Task> taskList;

    protected String input;


    Command(String input) {
        this.input = input;

    }



    /**
     * Executes the command and then returns a response.
     *
     * @param taskList Contains the current tasks.
     * @param ui Responsible for displaying information to the user.
     * @param storage Reads and stores data into memory.
     * @throws DukeException If could not execute command.
     */
    public abstract String execute(TaskList taskList, Ui ui, Storage storage)
            throws DukeException;


}
