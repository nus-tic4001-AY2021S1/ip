package duke;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import duke.tasks.TaskList;

public class Duke {
    private Ui ui = new Ui();
    private TaskList taskList = new TaskList();
    private Storage store = new Storage(taskList);
    private Parser parser = new Parser();
    private String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    Duke() {
        Ui ui = new Ui();
        TaskList taskList = new TaskList();
        Storage store = new Storage(taskList);
        Parser parser = new Parser();
    }

    public static void run(){

    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */

    String getResponse(String input) {
        //ui.greetUser();
        while (!store.getIsExit()) {
            try {
                return parser.getCommand(input, store, ui, taskList);
            } catch (Exception e) {
                return "OOPS!!! " + e.getMessage();
            }
        }

        return "Duke heard: " + input;
    }

    boolean getExit() {
        return store.getIsExit();
    }

    /**
    public static void main(String[] args) {


        ui.greetUser();
        while (!store.getIsExit()) {
            try {
                parser.getCommand(ui.readCommand(), store, ui, taskList);
            } catch (Exception e) {
                ui.indentPrint("OOPS!!! " + e.getMessage());
            }
            ui.printLine();
        }
    }
     */
}
