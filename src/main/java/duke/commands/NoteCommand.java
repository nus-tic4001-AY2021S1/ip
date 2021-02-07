package duke.commands;

import java.io.IOException;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to set a particular task as completed.
 */

public class NoteCommand extends Command {
    public static final String word = "note";

    public NoteCommand(String line, TaskList tasks, Ui ui, Database database) {
        super(line, tasks, ui, database);
    }

    @Override
    public String execute()  {
        try {
            if (tasks.size() == 0) {
                return "It appears that you have no tasks to add notes to!\r"
                    + "Perhaps you should start creating one?";
            }
            if (line.isEmpty()) {
                return "It seems that you've missed out the task index or the note text!\r"
                    + "Please type in the 'note <index> <text>' format.";
            }

            String indexText = line.trim().split(" ")[0];
            String noteText = line.substring(line.indexOf(" ") + 1).trim();

            int index = Integer.parseInt(indexText);
            tasks.get(index - 1).setNote(noteText);
            database.updateDatabase(tasks);
            return ui.printNoteAdded(tasks, index);

        } catch (IOException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return
                "I'm sorry, but the list goes numerically.\rPerhaps you could type a number for the index?";
        } catch (IndexOutOfBoundsException e) {
            return "It appears that you only have " + tasks.size() + " task(s) in your list,\r"
                + "perhaps you might want to try typing an index number from 1 to " + tasks.size() + " instead?";
        }
    }
}
