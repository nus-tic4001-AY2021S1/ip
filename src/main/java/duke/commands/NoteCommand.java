package duke.commands;

import java.io.IOException;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to add a note to an existing task.
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
                return "You don't have any tasks you dolt, so you can't add a note to anything!\r"
                    + "Go create a task first!";
            }

            String indexText = line.trim().split(" ")[0];
            String noteText = line.substring(line.indexOf(" ") + 1).trim();
            int index = Integer.parseInt(indexText);

            if (noteText.equals(indexText)) {
                return "You've missed out the note text!\r"
                    + "Type in the 'note <index> <text>' format, you dolt!";
            }

            tasks.get(index - 1).setNote(noteText);
            database.updateDatabase(tasks);
            return ui.printNoteAdded(tasks, index);

        } catch (IOException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return "Type a number for the index, you fool!";
        } catch (IndexOutOfBoundsException e) {
            return "You only have " + tasks.size() + " task(s) in your list,\r"
                + "why can't you type an index number from 1 to " + tasks.size() + "?";
        }
    }
}
