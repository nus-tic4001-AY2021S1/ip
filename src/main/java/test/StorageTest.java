import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import data.Deadline;
import data.Task;
import data.TaskList;
import data.Todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import exception.DukeException;
import org.junit.jupiter.api.Test;
import storage.Storage;

public class StorageTest {
    @Test
    public void saveTasks() throws FileNotFoundException, DukeException {
        Storage storage = new Storage("data/tasks_tests.txt");
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("Task 1"));
        tasks.add(new Deadline("Task 2", "Tuesday 4PM"));
        storage.save(tasks);

        TaskList tasksList = new TaskList(storage.load());

        String[] tasksFromFile = tasksList.getDescription().split("\\|");
        System.out.println(tasksList.getDescription());
        assertEquals("Task 1", tasksFromFile[0]);
        assertEquals("Task 2", tasksFromFile[1]);
    }
}
