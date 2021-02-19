package duke.command;


import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * An abstract class that is inherited by every command.
 */

public abstract class Command {

    public String line;
    public Ui ui;
    public Storage storage;
    public ArrayList commandName;

    protected Command() {

    }

    protected Command(Ui ui) {
        this.ui = ui;

    }

    protected Command(String line, Ui ui, Storage storage, ArrayList commandName) {

        this.line = line;
        this.ui = ui;
        this.storage = storage;
        this.commandName = commandName;
    }

    public abstract String execute();


}
