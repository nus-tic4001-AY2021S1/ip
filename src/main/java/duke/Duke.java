package duke;

import ui.Storage;
import ui.Parser;
import ui.TaskList;
import ui.Ui;

import java.io.IOException;
import java.util.Scanner;

public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Duke(String filePath) throws IOException, DukeException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            //ui.showLoadingError();
            storage.createFile();
            tasks = new TaskList();
        }
    }

    public void run() throws IOException {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();

            if (!(input.toLowerCase()).equals("bye")) {
                Parser.processInput(input, tasks.getTasksArr());
            } else {
                ui.greetNote("bye");
                Storage.writeToFile(tasks.getTasksArr());
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException, DukeException {
        new Duke("record.txt").run();
    }
}
