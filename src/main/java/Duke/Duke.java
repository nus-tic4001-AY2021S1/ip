package Duke;

import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Duke  {
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private TaskList taskList;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    public Duke() {

    }

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        taskList = storage.load();
    }

    public void run() {
        ui.printGreetings();
        while(!ui.getIsExit()) {
            String fullCommand = ui.readCommand();
            ui.printLine(); // show the divider line ("_______")
            parser.execute(fullCommand, ui, storage, taskList);
            ui.printLine();
        }
    }

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        checkFolder(dir);
        checkTextFile(dir);
        new Duke(dir+"/data/duke.txt").run();
    }

    public static void checkFolder(String dir){
        //check if folder exists
        java.nio.file.Path checkFolderPath = java.nio.file.Paths.get(dir+"/data");
        boolean folderExists = java.nio.file.Files.exists(checkFolderPath);
        //folder not exists, create one
        if(!folderExists) {
            new File(dir+"/data").mkdirs();
        }
    }

    public static void checkTextFile(String dir){
        //check if text file exists
        java.nio.file.Path checkFilePath = java.nio.file.Paths.get(dir+"/data/duke.txt");
        boolean fileExists = java.nio.file.Files.exists(checkFilePath);
        //text file not exists, create one
        if(!fileExists) {
            try {
                File dukeFile = new File(dir+"/data/duke.txt");
                dukeFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating file.");
                e.printStackTrace();
            }
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }

}
