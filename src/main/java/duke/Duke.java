package duke;

import duke.commands.Command;
import duke.exceptions.DukeException;
import duke.ui.Ui;
import duke.parser.Parser;
import duke.util.Storage;
import duke.util.TaskList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

/**
 * Represents the main class for the Duke application.
 */
public class Duke {

    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "data/duke.txt";


    private Storage storage;
    private Ui ui;
    private TaskList taskList;
    private Parser parser;


    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));


    /**
     * Constructs an instance of Duke.
     */
    public Duke() throws DukeException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        ui = new Ui();
        parser = new Parser();
        taskList = new TaskList();
        storage = new Storage();

        // reading the date from task data file
        // if this is the first time, a message will be shown that no data file is found
        storage.readFromFile(filename);

        Ui.sayWelcome();


    }



    /**
     * Returns Duke's response to a command after executing it.
     *
     * @param input User command.
     * @return Duke's response.
     * @throws DukeException if there is any exception.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            String reply = command.execute(taskList, ui, storage);
            storage.saveToFile(filename);
            return reply;
        } catch (DukeException e) {
            return e.getMessage();
        }
    }





}






