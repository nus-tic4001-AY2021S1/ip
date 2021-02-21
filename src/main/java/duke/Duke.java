package duke;

import data.TaskList;
import exception.DukeException;

import parser.Parser;
import storage.Storage;

import ui.Constants;
import logic.Logic;
import ui.Ui;

public class Duke {
    private Logic logic = new Logic();
    private Storage storage = new Storage("data/tasks.txt");
    private TaskList tasks;
    private Ui ui;


    /**
     * Begin running main logic processing loop
     */
    public String run(String userInput) {

        String logicResponse = "";

        String fullCommand = userInput;
        String commandWord = Parser.getCommandWord(fullCommand);

        logicResponse = logic.ProcessUserInput(fullCommand, commandWord, tasks);
        try {
            storage.save(tasks.getTasks());
        }catch(DukeException e){
            System.out.println(e.getMessage());
        }
        return logicResponse;
    }


//    public static void main(String[] args) {
//        new Duke("data/tasks.txt").run();
//    }

    public String displayWelcomeMsg() {
        return String.format(Constants.GREETING);
    }

    public String loadTasksFromFile() {
        return String.format(storage.load(tasks));
    }

}
