package dukes;


import dukes.command.Command;
import dukes.exception.DukeException;
import dukes.parser.Parser;
import dukes.storage.Storage;
import dukes.tasks.TaskList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

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
    public static String path = "data/duke.txt";
    private TaskList tasks;
    private final Ui ui;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private final Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /** Path program will store the task in this path.
     * @param path the path of which data is saved and loaded from
     * */
    public Duke(String path)  {
        ui = new Ui();
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.printLoadingError("Problem reading file. Starting with an empty task list.");
            tasks = new TaskList();
        }
    }

    public Duke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Parser parser = new Parser();
        tasks = new TaskList();
        storage = new Storage();
        ui = new Ui();
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
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */

    String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    /**
     * This is main method which made use of Dukes.Duke and run methods.
     * @param args a value passed to a function.
     */
    public static void main(String[] args) {
        assert (args.length) > 0;
        new Duke("data/duke.txt").run();
    }
}




