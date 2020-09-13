package Dukes;


import Dukes.command.Command;
import java.io.FileNotFoundException;


public class Duke {
    private  Storage storage;
    private TaskList tasks;
    private  Ui ui;

    public Duke(String path) throws Dukes.FileNotFoundException {
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = new TaskList(storage.load());
        } catch ( DukeException e ) {
            ui.printLoadingError("Problem reading file. an empty task list is there");
            tasks = new TaskList();
        }
    }


    public void run() {
        ui.printWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
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

        public static void main(String[] args) throws Dukes.FileNotFoundException {
            assert (args.length) > 0;
                new Duke("data/duke.txt").run();
        }
}




