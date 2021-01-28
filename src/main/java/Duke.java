import java.io.IOException;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.OtherCommand;
import duke.exceptions.DukeException;
import duke.tasks.Deadlines;
import duke.tasks.Events;
import duke.tasks.Task;
import duke.tasks.ToDos;
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 */

public class Duke {

    static final String HELLO = " Hello! I'm Duke\n" + " What can I do for you?";

    static final String BYE = " Bye. Hope to see you again soon!";

    private Ui ui;
    private Storage storage;
    private TaskList tasks;
    /*
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
     */

    /**
     * @param relativePath constructor, generate Duke with an relative path
     */
    public Duke(String relativePath) {
        this.ui = new Ui();
        this.storage = new Storage(relativePath);
        this.tasks = new TaskList();
    }

    /**
     * test
     */
    public Duke() {
        this.ui = new Ui();
        //this.storage = new Storage(relativePath);
        this.tasks = new TaskList();
    }

    /**
     * The normal run method.
     */
    public void run() {

        ui.showLine();
        ui.show(HELLO);
        ui.showLine();

        /*
        1. If a file exist, load it to memory, otherwise create a new file
         */
        try {
            storage.load(tasks);
        } catch (DukeException | IOException e) {
            ui.show(e.getMessage());
        }

        while (true) {
            String userInput = ui.getCommand();
            Command cmd = null;

            /*
            2.Parse user command to readable format
             */
            try {
                cmd = Parser.getCommand(userInput);
            } catch (DukeException e) {
                ui.show(e.getMessage());
                continue;
            } catch (Exception e) {
                ui.show("☹ OOPS!!! Unknown internal error occurs.");
                continue;
            }

            /*
            3.Check the user command whether is legal.
             */
            if (cmd instanceof OtherCommand && cmd.getCmdType().equalsIgnoreCase("bye")) {
                break;
            } else if (cmd instanceof OtherCommand) {
                ui.show(new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(").getMessage());
                continue;
            }

            /*
            4.Process the user command
             */
            processCommand(cmd, tasks, ui);

            /*
            5. Update the result to the file and  save it.
             */
            try {
                storage.save(tasks);
            } catch (IOException e) {
                ui.show("☹ OOPS!!!Updating file is fail.");
            }

            ui.showLine();
        }

        ui.show(BYE);
        ui.showLine();
    }

    private static String processCommand(Command cmd, TaskList tasks, Ui ui) {
        int index;
        int i = 1;
        StringBuffer s = new StringBuffer();

        switch (cmd.getCmdType()) {
        case "list":
            s.append("Here are the tasks in your list:" + System.lineSeparator());
            for (Task t : tasks.getWholeList()) {
                s.append(i + "." + t.toString() + System.lineSeparator());
                i++;
            }
            return s.toString();
        case "find":
            s.append("Here are the matching tasks in your list:" + System.lineSeparator());
            for (Task t : tasks.findKeywordList(cmd.getCmdContent())) {
                s.append(i + "." + t.toString() + System.lineSeparator());
                i++;
            }
            return s.toString();
        case "done":
            index = ((DoneCommand) cmd).getIndex();
            tasks.get(index - 1).setDone(true);
            s.append("Nice! I've marked this task as done: " + System.lineSeparator());
            s.append(tasks.get(index - 1).toString() + System.lineSeparator());
            return s.toString();
        case "delete":
            index = ((DeleteCommand) cmd).getIndex();
            s.append("Noted. I've removed this task: " + System.lineSeparator());
            s.append(tasks.get(index - 1).toString() + System.lineSeparator());
            tasks.remove(index - 1);
            s.append("Now you have " + tasks.size() + " tasks in the list.");
            return s.toString();
        case "todo":
            ToDos t = new ToDos(cmd.getCmdContent());
            tasks.add(t);
            return ui.printTask(t, tasks);
        case "deadline":
            Deadlines d = new Deadlines(cmd.getCmdContent(), ((DeadlineCommand) cmd).getTime());
            tasks.add(d);
            return ui.printTask(d, tasks);
        case "event":
            Events e = new Events(cmd.getCmdContent(), ((EventCommand) cmd).getTime());
            tasks.add(e);
            return ui.printTask(e, tasks);
        default:
            return "Nothing done bro.";
        }
    }
    /*
    @Override
    public void start(Stage primaryStage) {
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        //1. set up the entire GUI
        primaryStage.setScene(scene); // Setting the stage to show our screen
        primaryStage.setResizable(false);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("Duke");

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        primaryStage.show(); // Render the stage.

        //Step 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        userInput.setOnAction((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
    }
     */

    /*
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    /*
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }
     */

    /*
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    /*
    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }
     */

    /*
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */

    String getResponse(String input) {
        Command cmd = null;

        try {
            cmd = Parser.getCommand(input);
        } catch (DukeException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "☹ OOPS!!! Unknown internal error occurs.";
        }

        if (cmd instanceof OtherCommand && cmd.getCmdType().equalsIgnoreCase("bye")) {
            return BYE;
        } else if (cmd instanceof OtherCommand) {
            return new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(").getMessage();
        }

        return processCommand(cmd, tasks, ui);

    }

}
