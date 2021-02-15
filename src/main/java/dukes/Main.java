package dukes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Duke dukes = new Duke();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Duke ChatBot");
            stage.getIcons().add(new Image("/images/Robot.png"));
            fxmlLoader.<MainWindow>getController().setDuke(dukes);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
