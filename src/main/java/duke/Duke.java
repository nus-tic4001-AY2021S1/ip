package duke;

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

    public void run() {
        ui.printWelcome();
        boolean isBye = false;
        while (!isBye) {
            try {
                String fullCommand = ui.readUserInput();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isBye = c.isBye();
            } catch (DukeException e) {
                ui.printError(e.getMessage());
            }
        }
        ui.printGoodbye();
    }

    /**
     *  Main method of Duke. This is the starting point of the app.
     *  @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}