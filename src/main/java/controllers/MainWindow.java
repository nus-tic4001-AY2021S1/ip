package controllers;

import duke.Duke;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */

public class MainWindow {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/Alan-Turing.jpg"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/java-duke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        duke = d;
        runDuke();
    }

    private void runDuke() {
        showToUser(duke.displayWelcomeMsg());
        showToUser(duke.loadTasksFromFile());
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        showUserInput(input);
        //   dialogContainer.getChildren().addAll(
        //       DialogBox.getUserDialog(input, userImage),
        //       DialogBox.getDukeDialog(response, dukeImage)
        //        );
        showToUser(duke.run(input));
        userInput.clear();
    }

    /**
     * Takes in a string and outputs it to the dialogbox to display to the user.
     * @param msg
     */
    public void showToUser(String msg) {
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(msg, dukeImage)
        );
    }

    public void showUserInput(String msg){
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(msg, userImage)
        );
    }
}
