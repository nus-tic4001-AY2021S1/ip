package Duke;

//import com.sun.glass.ui.Application;
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

public class Duke extends Application {

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

    public void run(){
        paser = new Parser(ui,tasks);
        ui.printLogo();
        ui.greetMessage();
        Scanner in = new Scanner(System.in);
        String str = "";

        while (!str.equals("bye") ) {
            try {
                str = ui.getInput(in);
                paser.handleCommands(str);
                storage.saveToFile(tasks);
            }catch (DukeException e){
                ui.printError(e);
            }
        }
    }

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

            stage.setScene(scene);
            stage.show();
            
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

            //Step 3. Add functionality to handle user input.
            sendButton.setOnMouseClicked((event) -> {
                dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
                userInput.clear();
            });

            userInput.setOnAction((event) -> {
                dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
                userInput.clear();
            });
        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        //Part 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });

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
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
        private void handleUserInput() {
            Label userText = new Label(userInput.getText());
            Label dukeText = new Label(getResponse(userInput.getText()));
            dialogContainer.getChildren().addAll(
                new DialogBox(userText, new ImageView(user)),
                new DialogBox(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {
        return "Duke heard: " + input;
    }

    public static void main(String[] args) {
        new Duke("/Users/chenduo/Desktop/ip/Duke.txt").run();
        /*
        LocalDate d1 = LocalDate.parse("2019-12-01");
        LocalDate d2 = LocalDate.parse("2019-12-02");
        LocalDate d3 = LocalDate.parse("2019-12-02");


        System.out.println(d1.isBefore(d2)); // -> true
        System.out.println(d1.isAfter(d2)); // -> false
        System.out.println(d2.equals(d3)); // -> true


        System.out.println(d1.getDayOfWeek()); // -> SUNDAY
        System.out.println(d1.getMonth()); // -> DECEMBER
        System.out.println(d1.plus(1, ChronoUnit.YEARS));  // -> 2020-12-01


        LocalDate d4 = LocalDate.now();
        System.out.println(d4); // -> 2019-10-15
        System.out.println(d4.format(DateTimeFormatter.ofPattern("MMM d yyyy"))); // -> Oct 15 2019
      */
    }

}


