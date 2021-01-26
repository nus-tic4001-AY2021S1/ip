package duke.commands;

import duke.ui.Ui;
/**
 * A command to exit the program.
 */

public class ExitCommand extends Command {
    public ExitCommand(Ui ui) {
        super(ui);
    }

    @Override
    public String execute()  {
        return ui.printFarewell();
    }
}