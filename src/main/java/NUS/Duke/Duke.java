package NUS.Duke;

import NUS.Duke.utils.DialogBox;
import NUS.Duke.utils.ParserUtil;
import NUS.Duke.utils.UI;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.control.ScrollPane;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Duke extends Application {
    private Image user = new Image(this.getClass().getResourceAsStream("/image/userFemale.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/image/userMale.png"));

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    public static void main(String[] args) {
        Application.launch(Duke.class, args);
    }



    public static String processCommand(String originalCommand) {
        System.out.println("____________________________________________________________");
        String operation = ParserUtil.getFunctionCommand(originalCommand);
        String details = originalCommand.substring(originalCommand.indexOf(' ') + 1);
        String result = "";


        switch (operation){
            case "todo":
                result=ParserUtil.createTodoTask(details,0);
                break;
            case "deadline":
                result=ParserUtil.createDeadlineTask(details,0);
                break;
            case "event":
                try {
                    result=ParserUtil.createEventTask(details,0);
                } catch (ProcessingException e) {
                    e.printStackTrace();
                }
                break;
            case "list":
                result=UI.printList(ParserUtil.taskList);
                break;
            case "bye":
                result=UI.printByeMessage();
                System.exit(0);
                break;
            case "done":
                result=ParserUtil.doneTask(Integer.parseInt(details));
                break;
            case "delete":
                result=ParserUtil.deleteTask(Integer.parseInt(details));
                break;
            case "save":
                result=ParserUtil.writeToFile();
                break;
            case "find":
                result=ParserUtil.findTask(details);
                break;
            case "findby":
                result=ParserUtil.findTaskByDate(details);
                break;
            case "deleteall":
                result=ParserUtil.deleteAllTask();
                break;
            case "help":
                result=UI.printHelpList();
                break;
            case "startwelcome":
                result = ParserUtil.readTaskFromFile();
                break;
            default:
                result=("Sorry I dont understand the command, please use 'help' to see the command list");


        }

        return result;

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

        // more code to be added here later

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

        dialogContainer.setPadding(new Insets(10,10,10,10));

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        // more code to be added here later

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

        sendButton.setOnMouseClicked((event) -> {
            String command = userInput.getText();
            handleUserInput(command);
        });

        userInput.setOnAction((event) -> {
            String command = userInput.getText();
            handleUserInput(command);
        });

        handleUserInput("startWelcome");
    }

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
    private void handleUserInput(String command) {


        UI ui = new UI();
//        UI.printWelcomeMessage();
//        String command = userInput.getText();

        String result  = processCommand(command);
        Label userText = new Label(command);


        userText.setTextFill(Color.web("#000000"));
        userText.setPadding(new Insets(10,10,10,10));
        userText.setStyle("-fx-background-radius: 18 18 18 18;-fx-border-radius: 18 18 18 18;" +
                "-fx-background-color: dodgerblue; -fx-start-margin: 10px");
        Label dukeText = new Label(result);


        dukeText.setTextFill(Color.web("#000000"));
        dukeText.setPadding(new Insets(10,10,10,10));
        dukeText.setStyle("-fx-background-radius: 18 18 18 18;-fx-border-radius: 18 18 18 18;" +
                "-fx-background-color: white; -fx-start-margin: 10px");

        if (command!="startWelcome") {
            dialogContainer.getChildren().addAll(DialogBox.getUserDialog(userText, new ImageView(user)));
        }
        dialogContainer.getChildren().addAll(DialogBox.getDukeDialog(dukeText, new ImageView(duke)));

        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {
        return "Duke heard: " + input;
    }


}
