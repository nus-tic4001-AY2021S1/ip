import static org.junit.jupiter.api.Assertions.assertEquals;

import duke.commands.NoteCommand;
import duke.commands.TodoCommand;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

public class NoteCommandTest {
    @Test
    public void noteCommandTest() {
        Ui ui = new Ui();
        TaskList tasks = new TaskList();
        Database database = new Database("duke.txt", tasks, ui);
        String lineWithoutCommand = "Create a note for this task";
        new TodoCommand(lineWithoutCommand, tasks, ui, database).execute();
        String noteWithIndex = "1 This note should work fine";
        new NoteCommand(noteWithIndex, tasks, ui, database).execute();

        assertEquals(tasks.get(0).getDescription(),"[X] [Todo]     Create a note for this task"
            + "\r       [Note]     This note should work fine");
    }
}