package duke;

import ui.Storage;
import ui.Parser;
import ui.TaskList;
import ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;
    private ArrayList<Task> task;

    public Duke() throws IOException, DukeException {
        ui = new Ui();
        String filePath = "record.txt";
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

            if (!(input).equalsIgnoreCase("bye")) {
                Parser.processInput(input, tasks.getTasksArr());
            } else {
                ui.greetNote("bye");
                Storage.writeToFile(tasks.getTasksArr());
                return;
            }
        }
    }

    public static void main() throws IOException, DukeException {
        new Duke().run();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {
        return  Parser.processInput(input, tasks.getTasksArr());
    }

}