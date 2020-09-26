package duke.commands;

import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;
/**
 * An abstract class that is inherited by every command.
 */
public abstract class Command {
    public String line;
    public TaskList tasks;
    public Ui ui;
    public Database database;

    protected Command(String line, TaskList tasks, Ui ui, Database database) {
        this.line = line;
        this.database = database;
        this.tasks = tasks;
        this.ui = ui;
    }

    protected Command(String line, TaskList tasks, Ui ui) {
        this.line = line;
        this.tasks = tasks;
        this.ui = ui;
    }

    protected Command(TaskList tasks, Ui ui) {
        this.tasks = tasks;
        this.ui = ui;
    }

    protected Command(Ui ui) {
        this.ui = ui;
    }

    public abstract void execute();
}