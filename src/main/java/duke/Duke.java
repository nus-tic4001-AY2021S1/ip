package duke;

import duke.tasks.TaskList;

public class Duke {
    private Ui ui = new Ui();
    private TaskList taskList = new TaskList();
    private Storage store = new Storage(taskList);
    private Parser parser = new Parser();


    String getResponse(String input) {
        while (!store.getIsExit()) {
            try {
                return parser.getCommand(input, store, ui, taskList);
            } catch (Exception e) {
                return "OOPS!!! " + e.getMessage();
            }
        }

        return "Duke heard: " + input;
    }

    boolean getExit() {
        return store.getIsExit();
    }

}
