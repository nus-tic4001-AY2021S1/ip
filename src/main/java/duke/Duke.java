package duke;

import duke.command.Parser;
import duke.command.Storage;
import duke.command.TaskException;
import duke.command.TaskList;
import duke.command.Ui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class implements simple Duke chat bot named Jojo,that can write, read and save
 * tasks in the assigned filePath.
 * This Duke class contained 3 methods Duke ,run and main.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */

@SuppressWarnings("checkstyle:RightCurly")
public class Duke {

    public TaskList tasks;
    public Ui ui;
    public Storage storage;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * create an empty Duke constructor.
     */
    public Duke() {
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {
        return "Duke heard: " + input;
    }

    /**
     * This constructs is TaskManager with a filePath,
     * This TaskManager try call save.readTaskFromFile to load tasks from filePath
     * and throw an exception if the file does not exist yet!
     *
     * @param filePath duke command save file path
     */
    public Duke(String filePath)  {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.readTaskFromFile());
        } catch (TaskException e) {
            ui.showToUser("OOPS!!!folder does not exist yet!");
            tasks = new TaskList();
        }
    }

    public static void main(String[] args) {
        new Duke("Jojo.txt").run();
    }

    /**
     * This run method switch different duke command to different method.
     */
    @SuppressWarnings("checkstyle:Indentation")
    public void run() {
        ui.printLogo();
        ui.greetUser();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                String commandWord = Parser.getCommand(fullCommand);//convert command word to lowercase
                switch (commandWord) {
                    case "bye":
                        ui.farewellUser();
                        break;
                    case "":
                        isExit = true;
                        break;
                    case "todo":
                        tasks.addTodo(fullCommand);
                        break;
                    case "deadline":
                        tasks.addDeadline(fullCommand);
                        break;
                    case "done":
                        tasks.markAsDone(fullCommand);
                        break;
                    case "list":
                        tasks.showTasks(fullCommand);
                        break;
                    case "event":
                        tasks.addEvent(fullCommand);
                        break;
                    case "delete":
                        tasks.deleteTasks(fullCommand);
                        break;
                    case "find":
                        tasks.findTasks(fullCommand);
                        break;
                    case "save":
                        tasks.saveTasks();
                        break;
                    default: ui.printError();
                }
            } catch (TaskException e) {
                ui.printError(e.getMessage());
            }
        }
    }

}