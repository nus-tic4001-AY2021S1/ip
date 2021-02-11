package duke.ui;

import duke.Duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.application.Platform;

import java.util.TimerTask;
import java.util.Timer;

// Reference https://se-education.org/guides/tutorials/javaFxPart4.html
// Edit: JavaFX tutorial part 4 Using FXML
/** .
 * Controller for MainWindow.
 * Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;


    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Set the main window to show Greeting Message from Duke.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(new Ui().greetMessage(), dukeImage)
        );
    }


    public void setDuke(Duke d) {
        duke = d;
    }

    /** .
     * Set two dialog boxes:user input and Duke's reply
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );

        if (response.equals("Bye. Hope to see you again soon!")) {
            startExit();
        }

        userInput.clear();
    }

    /** .
     * Execute the program exit and close the GUI when the user inputs the command
     *
     */
    private void startExit() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.exit();
                System.exit(0);
            }
        };
        Timer delay = new Timer();
        delay.schedule(timerTask, 1500);
    }


}
