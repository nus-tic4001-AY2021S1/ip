package duke.main;

import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Implements an application that allows users to manage tasks.
 * It contains methods that allow the creation, modification and storage of tasks.
 */
public class Duke {
    private final Storage storage;
    private final Ui ui;
    private TaskList tasks;

    /**
     * Initializes a <code>Duke</code> object.
     *
     * @param filePath Path of the text file used for storing app data.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks(filePath));
        } catch (DukeException e) {
            ui.printError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        ui.clearOutput();
        Command c = Parser.parse(input);
        try {
            c.execute(tasks, ui, storage);
            if (c.isBye()) {
                return null;
            }
        } catch (DukeException e) {
            return e.getMessage();
        }
        return ui.getOutput();
    }
}
