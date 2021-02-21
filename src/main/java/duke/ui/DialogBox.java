package duke.ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

// Reference https://se-education.org/guides/tutorials/javaFxPart4.html
// Edit: JavaFX tutorial part 4 Using FXML
public class DialogBox extends HBox {
    // Sets the background of message box based on the role: User or Duke
    private static final String User_MessageBox =
            "-fx-background-color: rgba(165, 239, 127, 0.9); -fx-background-radius: 15; -fx-font-weight: bold;";
    private static final String Duke_MessageBox =
            "-fx-background-color: rgba(252, 253, 253, 0.9); -fx-background-radius: 15; -fx-font-weight: bold;";

    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img, boolean isDuke) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        if (isDuke) {
            dialog.setStyle(Duke_MessageBox);
        } else {
            dialog.setStyle(User_MessageBox);
        }


        displayPicture.setImage(img);
        final Circle clip = new Circle(50, 50, 45);
        displayPicture.setClip(clip);
    }

    /**
     * Flips the dialog box to set the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img,false);
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img,true);
        db.flip();
        return db;
    }
}