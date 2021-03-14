package Duke;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Scanner;

public class Duke {

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private TaskList tasks;
    public Parser paser;
    public Ui ui;
    private Storage storage;

    public Duke(String path){
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException e) {
            ui.printError(e);
            tasks = new TaskList();
        }
    }

    public Duke() {
        ui = new Ui();

        storage = new Storage("/Users/chenduo/Desktop/ip/Duke.txt");
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException e) {
            ui.printError(e);
            tasks = new TaskList();
        }
        paser=new Parser(ui,tasks);
    }


    public String getResponse(String input) {
        String response="";
        try {
            response= paser.handleCommands(input);
            storage.saveToFile(tasks);
        }catch (DukeException e){
            response=e.getMessage();
        }
        return response;
    }
}




