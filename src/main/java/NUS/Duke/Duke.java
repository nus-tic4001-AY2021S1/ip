package NUS.Duke;


import NUS.Duke.DTO.TaskDTO;
import NUS.Duke.utils.ParserUtil;
import NUS.Duke.utils.UI;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.util.List;


public class Duke extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    public static void main(String[] args) {
        ParserUtil.readTaskFromFile();
        Application.launch(Duke.class, args);
//        UI ui = new UI();
//        UI.printWelcomeMessage();
//        String command = ui.readCommand();
//
//        while (!ParserUtil.getFunctionCommand(command).equals("bye")) {
//            processCommand(command);
//            command = ui.readCommand();
//        }

    }



    public static void processCommand(String originalCommand) {
        System.out.println("____________________________________________________________");
        String operation = ParserUtil.getFunctionCommand(originalCommand);
        String details = originalCommand.substring(originalCommand.indexOf(' ') + 1);


        switch (operation){
            case "todo":
                ParserUtil.createTodoTask(details,0);
                break;
            case "deadline":
                ParserUtil.createDeadlineTask(details,0);
                break;
            case "event":
                try {
                    ParserUtil.createEventTask(details,0);
                } catch (ProcessingException e) {
                    e.printStackTrace();
                }
                break;
            case "list":
                UI.printList(ParserUtil.taskList);
                break;
            case "bye":
                UI.printByeMessage();
                System.exit(0);
                break;
            case "done":
                ParserUtil.doneTask(Integer.parseInt(details));
                break;
            case "delete":
                    ParserUtil.deleteTask(Integer.parseInt(details));
                break;
            case "save":
                ParserUtil.writeToFile();
                break;
            case "find":
                ParserUtil.findTask(details);
                break;
            case "deleteall":
                ParserUtil.deleteAllTask();
                break;
            case "help":
                UI.printHelpList();
                break;
            default:
                UI.printErrorMessage("Sorry I dont understand the command, please use 'help' to see the command list");


        }

        System.out.println("____________________________________________________________");
    }


    @Override
    public void start(Stage stage) {
//        BorderPane borderPane = new BorderPane();
//        HBox hBox = new HBox();
//        VBox vBox = new VBox();
//        userInput = new TextField();
//        sendButton = new Button("Send");
//        ObservableList list = hBox.getChildren();
//        list.addAll(userInput,sendButton);
//        borderPane.setTop(hBox);
//
//        Pane pane = new Pane();
//        pane.getChildren().add(new Label("Hello Pane"));
//
//
//        scrollPane = new ScrollPane();
//        dialogContainer = new VBox();
//        scrollPane.setContent(dialogContainer);
//
//
//
//        AnchorPane mainLayout = new AnchorPane();
//        mainLayout.getChildren().addAll(pane, scrollPane, userInput, sendButton);
//
//        scene = new Scene(borderPane);
//
//
//
//        stage.setTitle("Duke");
//        stage.setResizable(true);
//        stage.setMinHeight(600.0);
//        stage.setMinWidth(400.0);
//
//        mainLayout.setPrefSize(400.0, 600.0);
//
//        scrollPane.setPrefSize(385, 535);
//        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//
//        scrollPane.setVvalue(1.0);
//        scrollPane.setFitToWidth(true);
//
//        // You will need to import `javafx.scene.layout.Region` for this.
//        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
//
//        userInput.setPrefWidth(325.0);
//
//        sendButton.setPrefWidth(55.0);
//
//        AnchorPane.setTopAnchor(scrollPane, 2.0);
//        AnchorPane.setTopAnchor(pane, 1.0);
//
//        AnchorPane.setBottomAnchor(sendButton, 1.0);
//        AnchorPane.setRightAnchor(sendButton, 1.0);
//
//        AnchorPane.setLeftAnchor(userInput , 1.0);
//        AnchorPane.setBottomAnchor(userInput, 1.0);
//        stage.setScene(scene);
//        stage.show();
//
//        sendButton.setOnMouseClicked((event) -> {
//            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
//            userInput.clear();
//        });
//
//        userInput.setOnAction((event) -> {
//            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
//            userInput.clear();
//        });

        //Instantiating the BorderPane class
        AnchorPane mainLayout = new AnchorPane();
        VBox vBox = new VBox();
        BorderPane bPane = new BorderPane();
        bPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
        bPane.setPrefHeight(600);

        Button playButton = new Button("Play");
        ChoiceBox cb = new ChoiceBox();
        cb.setItems(FXCollections.observableArrayList(
                "List",
                new Separator(), "Create Todo", "Create Event", "Create Deadline",
                new Separator(),"Delete","Delete All","Mark as done","Save",
                new Separator(),"Exit")
        );

        HBox hBox = new HBox();
        Label label = new Label("Select Action : ");
        ObservableList list = hBox.getChildren();
        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                        System.out.println(t1);
                        if (t1.intValue()==6){
                            bPane.setCenter(deleteOneSection());
                        }else {
                            bPane.setCenter(new TextField("Left"));
                        }
            }
        });

        //Adding all the nodes to the observable list (HBox)
        list.addAll(label, cb);
        //Setting the top, bottom, center, right and left nodes to the pane
        bPane.setTop(hBox);
//        bPane.setLeft(new TextField("Left"));
//        bPane.setRight(new TextField("Right"));
        bPane.setBottom(topSelectionBox());

        //Creating a scene object
        Scene scene = new Scene(bPane);

        //Setting title to the Stage
        stage.setTitle("BorderPane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

    public HBox topSelectionBox(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setPrefWidth(300);

        ListView listView = new ListView();

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listView.setPrefWidth(300);
        listView.setPrefHeight(100);
        StringBuilder sb = new StringBuilder();
        List<TaskDTO> taskList = ParserUtil.taskList;
        if (taskList.size()==0){

            listView.getItems().add("You have no task yet, please add task.");
        }else {
            taskList.forEach(task -> {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(taskList.indexOf(task)+1 + ". ");
                stringBuilder.append(task.getTaskFullDescription());
                listView.getItems().add(stringBuilder.toString());
            });

            System.out.println(sb.toString());
        }

        hbox.getChildren().addAll(listView);

        return hbox;
    }
    public VBox deleteOneSection(){
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        Label label = new Label("Please enter task id you want to delete: ");
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 0, 5,0 ));
        hbox.setSpacing(10);
        TextField textField = new TextField();
        Button button = new Button("Delete");
        hbox.getChildren().addAll(textField,button);
        vBox.getChildren().addAll(label,hbox);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                label.setText(textField.getText());
                Stage newStage = new Stage();
                VBox comp = new VBox();
                TextField nameField = new TextField("Name");
                TextField phoneNumber = new TextField("Phone Number");
                comp.getChildren().add(nameField);
                comp.getChildren().add(phoneNumber);

                Scene stageScene = new Scene(comp, 100, 100);
                newStage.setScene(stageScene);
                newStage.show();
            }
        });
        return vBox;
    }


}
