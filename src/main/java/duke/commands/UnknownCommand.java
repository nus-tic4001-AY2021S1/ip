package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.ui.Ui;


public class UnknownCommand extends Command {
    public UnknownCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage)  {
        return String.format(
                "OOPS!!! I'm sorry, but I don't know what that means :-(");
    }


}
