package duke;

import duke.commands.*;
import duke.tasks.TaskList;

/**
 * Parser class handles command parser and identify different keywords with switch cases.
 */
public class Parser {
    public void getCommand (String input, Storage store, Ui ui, TaskList taskList) throws Exception{
        int index;
        ui.printLine();
        String command, others;
        if(input.contains(" ")){
            command = input.split(" ",2)[0];
            others = input.split(" ",2)[1];
        }else{
            command = input;
            others = "";
        }
        switch (command) {
            case "bye":
                new ByeCommand().execute(ui,store,taskList);
                break;
            case "list":
                new ListCommand().execute(ui,store,taskList);
                break;
            case "done":
                new DoneCommand().execute(others,ui,store,taskList);
                break;
            case "delete":
                new DeleteCommand().execute(others,ui,store,taskList);
                break;
            case "todo":
                new TodoCommand().execute(others,ui,store,taskList);
                break;
            case "deadline":
                new DeadlineCommand().execute(others,ui,store,taskList);
                break;
            case "event":
                new EventCommand().execute(others,ui,store,taskList);
                break;
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
