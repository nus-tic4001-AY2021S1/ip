import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
    @Test
    public void testExtractTasks() throws IOException {
        Ui ui = new Ui();
        TaskList tasks = new TaskList();
        Database database = new Database("duke.txt", tasks, ui);
        ArrayList<String> lines = new ArrayList<>();
        lines.add("1. [✘] [Todo]     something");
        database.extractTasks(lines, tasks, ui, database);

        assertEquals(tasks.get(0).getDescription(), "[✘] [Todo]     something");
    }
}