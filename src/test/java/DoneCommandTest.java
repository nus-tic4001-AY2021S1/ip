import static org.junit.jupiter.api.Assertions.assertEquals;

import duke.commands.DoneCommand;
import duke.commands.TodoCommand;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

public class DoneCommandTest {
    @Test
    public void doneCommandTest() {
        Ui ui = new Ui();
        TaskList tasks = new TaskList();
        Database database = new Database("duke.txt", tasks, ui);
        String lineWithoutCommand = "Task to set as completed";
        new TodoCommand(lineWithoutCommand, tasks, ui, database).execute();
        String taskIndex = "1";
        new DoneCommand(taskIndex, tasks, ui, database).execute();

        assertEquals(tasks.get(0).getDescription(),"[D] [Todo]     Task to set as completed");
    }
}