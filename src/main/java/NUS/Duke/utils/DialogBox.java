package NUS.Duke.utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;


public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    public DialogBox(Label l, ImageView iv) {
        text = l;
        displayPicture = iv;

        text.setWrapText(true);
        displayPicture.setFitWidth(50.0);
        displayPicture.setFitHeight(50.0);
        this.setPadding(new Insets(10,10,10,10));
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, displayPicture);

    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public static DialogBox getUserDialog(Label l, ImageView iv) {
        DialogBox dialogBox = new DialogBox(l, iv);
//        dialogBox.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
        return dialogBox;
    }

    public static DialogBox getDukeDialog(Label l, ImageView iv) {
        DialogBox dialogBox = new DialogBox(l, iv);
//        dialogBox.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));
        dialogBox.flip();
        return dialogBox;
    }
}