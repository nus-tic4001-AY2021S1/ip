
package com.example.duke;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GUITest {

    //@Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }
}
