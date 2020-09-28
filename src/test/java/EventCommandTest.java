import duke.commands.EventCommand;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventCommandTest {
    @Test
    public void eventCommandTest() {
        Ui ui = new Ui();
        TaskList tasks = new TaskList();
        Database database = new Database("duke.txt", tasks, ui);
        String lineWithoutCommand = "submit /at 27/09/2020 2323 /to 2359";
        new EventCommand(lineWithoutCommand, tasks, ui, database).execute();

        assertEquals(tasks.get(0).getDescription(),"[\u2718] [Event]    submit (at: 27 Sep 2020 11:23pm - 11:59pm)");
    }
}