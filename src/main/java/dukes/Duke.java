package dukes;


import dukes.command.Command;
import dukes.exception.DukeException;
import dukes.parser.Parser;
import dukes.storage.Storage;
import dukes.tasks.TaskList;

/**
 * The Dukes.Duke program implements an application that can store a list of task,save to a txt file.
 * and print the task on the screen.
 * it link to other classes which is an member for Dukes.Duke such as Storage, Task and Ui Class
 *
 * @author LIN QING
 * @version 1.0
 * @since 18/1/2021
 */
public class Duke {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /** Path program will store the task in this path. */
    public Duke(String path)  {
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.printLoadingError("Problem reading file. Starting with an empty task list.");
            tasks = new TaskList();
        }
    }

    /**
     * run program implements an application that simply shows the tasks and print on the screen
     * DukeException if the command word not in the case.
     */
    public void run() {
        ui.printWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * This is main method which made use of Dukes.Duke and run methods.
     */
    public static void main(String[] args) {
        assert (args.length) > 0;
        new Duke("data/duke.txt").run();
    }
}




