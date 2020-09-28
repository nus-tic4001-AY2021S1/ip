package duke.commands;

import duke.database.Database;
import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Ui;

import java.io.IOException;
/**
 * A command to set a particular task as completed.
 */
public class DoneCommand extends Command {
    public static final String word = "done";

    public DoneCommand(String line, TaskList tasks, Ui ui, Database database) {
        super(line, tasks, ui, database);
    }

    @Override
    public void execute() {
        try {
            if (tasks.size() == 0) {
                ui.printRedBorderlines("It appears that you have no tasks yet, so you can't complete any!\n" +
                        "Perhaps you should start creating one?");
                return;
            }
            if (line.isEmpty()) {
                throw new DukeException("You almost typed a proper done command, but you missed out the number!\n" +
                        "Please type in the 'done <task index number>' format.");
            }
            int index = Integer.parseInt(line);
            tasks.get(index - 1).setDone();
            ui.printTaskCompleted(index, tasks);
            database.updateDatabase(tasks);

        } catch (DukeException | IOException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (NumberFormatException e) {
            ui.printRedBorderlines("I'm sorry, but the list goes numerically.\nPerhaps you could type a number for the index?");
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It appears that you only have " + tasks.size() + " task(s) in your list,\n" +
                    "perhaps you might want to try typing an index number from 1 to " + tasks.size() + " instead?");
        }
    }
}
