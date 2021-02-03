package duke;

import jdk.jfr.Event;
import org.junit.jupiter.api.Test;
import ui.Parser;
import ui.TaskList;
import ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class DukeTest {
    @Test
    public void duke() throws IOException, DukeException {

        String command = "Todo Adding New";

        ArrayList<Task> expectedTasks = new ArrayList<>();
        expectedTasks.add(new ToDos("Adding New"));

        ArrayList<Task> actualTasks = new ArrayList<>();
        Parser parser = new Parser(command);
        TaskList tasklist = new TaskList(actualTasks);
        parser.processInput(command,actualTasks);
        actualTasks = tasklist.getTasksArr();

        assertEquals(expectedTasks,actualTasks);
    }

    @Test
    public void checkDeleteFunction() throws IOException, DukeException {

        ArrayList<Task> expectedTasks = new ArrayList<>();
        expectedTasks.add(new ToDos("Adding New One"));

        ArrayList<Task> actualTasks = new ArrayList<>();
        String commandAdd = "Todo Adding New One";
        String commandAdd2 = "Deadlines Adding New 2 /by 2020-09-20 09:00";
        final String deleteCommand = "delete 2";
        Parser parser = new Parser(commandAdd);
        TaskList tasklist = new TaskList(actualTasks);
        parser.processInput(commandAdd,actualTasks);
        parser.processInput(commandAdd2, actualTasks);
        actualTasks = tasklist.getTasksArr();

        parser.processInput(deleteCommand, actualTasks);

        assertEquals(expectedTasks,actualTasks);
    }
}