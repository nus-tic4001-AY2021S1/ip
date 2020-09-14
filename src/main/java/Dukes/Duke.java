package Dukes;
import Dukes.Exceptions.DukeException;
import Dukes.Tasks.TaskList;
import Dukes.command.Command;


/**
 * The Duke program implements an application that can store a list of task,save to a txt file.
 * and print the task on the screen.
 * it link to other classes which is an member for Duke such as Storage, Task and Ui Class
 *
 * @author LIN QING
 * @version 1.0
 * @since 14/9/2020
 */
public class Duke {
    private  Storage storage;
    private TaskList tasks;
    private  Ui ui;
    /**
     * @param path program will store the task in this path
     * @throws <code>DukeException</code> if problem reading file.
     */
    public Duke(String path)  {
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = new TaskList(storage.load());
        } catch ( DukeException e ) {
            ui.printLoadingError("Problem reading file. Starting with an empty task list.");
            tasks = new TaskList();
        }
    }

    /**
     * run program implements an application that simply shows the tasks and print on the screen
     *
     * @return task and the number of task in the list
     * @throws <code>DukeException</code>Exception if the command word not in the case.
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
     * This is main method which made use of Duke and run methods
     */
        public static void main(String[] args){
            assert (args.length) > 0;
                new Duke("data/duke.txt").run();
        }
}




