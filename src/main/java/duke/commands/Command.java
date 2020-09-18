package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

/**
 * An abstract Command Class to provide structure for
 * other commands
 */
public abstract class Command {
    protected String commandBody;
    public Command(String fullCommand){
        this.commandBody=fullCommand;
    }
    public Command(){ }
    public abstract void execute(Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException;
}
