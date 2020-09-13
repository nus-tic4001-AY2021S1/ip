package duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaskList {
    private TaskList tasks = new TaskList();
    @Test
    public void testGetSize() {
        tasks.addTask(new Todo("Have lunch with John"));
        tasks.addTask(new Todo("Have lunch with Sam"));
        assertEquals(2, tasks.getSize());
    }
}