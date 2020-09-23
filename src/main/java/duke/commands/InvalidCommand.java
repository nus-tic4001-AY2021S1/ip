package duke.commands;

import duke.ui.Ui;
/**
 * A command that handles invalid commands.
 */
public class InvalidCommand extends Command {
    public InvalidCommand(Ui ui) {
        super(ui);
    }

    @Override
    public void execute() {
        ui.printInvalidCommand();
    }
}