package duke;

import duke.command.CommandHandler;
import duke.fileManager.FileManager;
import duke.input.InputHandler;
import duke.input.InputParser;
import duke.output.DisplayHandler;
import duke.storage.ListHandler;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.scene.layout.Region;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Duke extends Application {

    // Instantiate Duke program components
    DisplayHandler displayHandler = new DisplayHandler();
    InputHandler inputHandler = new InputHandler();
    InputParser parser = new InputParser();
    ListHandler list = new ListHandler();
    CommandHandler command = new CommandHandler();
    FileManager fileManager = new FileManager("data.txt");

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @Override
    public void start(Stage stage) {

        //Step 1. Setting up required components
        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        //Step 2. Formatting the window to look as expected
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        //Step 3. Program opening & read Duke data from file
        displayDukeResponse(displayHandler.ProgramOpening());
        displayDukeResponse(fileManager.ReadFile(list));

        //Part 4. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput(parser, displayHandler, command, list, fileManager);
        });

        userInput.setOnAction((event) -> {
            handleUserInput(parser, displayHandler, command, list, fileManager);
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        //Prepare & show UI
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    /**
     * Iteration 2:
     * Creates two dialog boxes, one displaying user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput(InputParser parser, DisplayHandler displayHandler, CommandHandler command, ListHandler list, FileManager fileManager) {

            // Get user input
            String input = userInput.getText();
            displayUserInput(input);

            // Parse User input
            String keyWord = parser.extractKeyWord(input);
            String body = parser.extractKeyWordBody(input, keyWord);

            // If input is not recognised Keyword
            if (parser.checkIfKeyWord(keyWord) == false) {
                displayDukeResponse(displayHandler.DisplayInvalidInput());
            }
            // If input is a recognised Keyword
            else {
                displayDukeResponse(command.checkCommandType(keyWord, body, list));
            }
            fileManager.SaveFile(list.GetList());

            userInput.clear();

    }

    /**
     * Iteration 3:
     * Creates dialog boxes containing Duke's reply and then appends them to
     * the dialog container.
     */
    private void displayDukeResponse(String response) {
        Label dukeText = new Label(getResponse(response));
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
    }

    /**
     * Iteration 4:
     * Creates dialog boxes containing User's Input and then appends them to
     * the dialog container.
     */
    private void displayUserInput(String input) {
        Label userText = new Label(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user))
        );
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {
        return "Duke: " + input;
    }
}
