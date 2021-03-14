package duke;

import java.io.IOException;

import duke.exceptions.DukeException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import duke.ui.MainWindow;
import javafx.scene.image.Image;


/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    /** Duke Object created for the GUI. */
    private Duke duke;

    {
        try {
            duke = new Duke();
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets a scene on the stage argument to initialise the GUI.
     *
     * @param stage Stage used by a JavaFX application for the GUI.
     */
    @Override
    public void start(Stage stage) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Duke ChatBot");
            stage.getIcons().add(new Image("/images/robot.png"));
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
