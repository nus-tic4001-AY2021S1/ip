import duke.database.Database;
import duke.parser.Parser;
import duke.commands.Command;
import duke.commands.TodoCommand;
import duke.task.TaskList;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void testParseInput() {
        Ui ui = new Ui();
        Parser parser = new Parser();
        TaskList tasks = new TaskList();
        Database database = new Database(null, tasks, ui);

        Command first = parser.parseInput("todo something", ui, tasks, database);
        TodoCommand second = new TodoCommand("something", tasks, ui, database);

        assertEquals(TodoCommand.class.isAssignableFrom(first.getClass()), TodoCommand.class.isAssignableFrom(second.getClass()));
    }
}