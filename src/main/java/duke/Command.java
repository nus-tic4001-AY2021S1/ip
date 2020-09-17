package duke;

import duke.tasks.TaskList;

import java.io.IOException;

public abstract class Command {
    protected String commandBody;
    public Command(String fullCommand){
        this.commandBody=fullCommand;
    }
    public Command(){ }
    public abstract void execute(Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException;
}
