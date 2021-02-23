package duke;

import java.util.ArrayList;

import data.TaskList;
import exception.DukeException;
import logic.Logic;
import parser.Parser;
import storage.Storage;
import ui.Constants;
import ui.Ui;

public class Duke {
    private Logic logic = new Logic();
    private Storage storage = new Storage("data/tasks.txt");
    private TaskList tasks = new TaskList(new ArrayList<>());
    private Ui ui;


    /**
     * Begin running main logic processing loop
     */
    public String run(String userInput) {

        String logicResponse = "";

        String fullCommand = userInput;
        String commandWord = Parser.getCommandWord(fullCommand);

        logicResponse = logic.processUserInput(fullCommand, commandWord, tasks);

        try {
            //Save tasks to file.
            storage.save(tasks.getTasks());
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        }
        return logicResponse;
    }

    public String displayWelcomeMsg() {
        return String.format(Constants.GREETING);
    }

    public String loadTasksFromFile() {
        return String.format(storage.load(tasks));
    }

}
