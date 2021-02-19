package duke.command;

import duke.ui.Ui;

/**
 * A command to help user if he /she not familiar with the command line.
 */

public class HelpCommand extends Command {

    public static final String word = "--help";


    public HelpCommand(Ui ui) {
        super(ui);
    }

    @Override
    public String execute() {
        return ui.tasks();
    }

}
