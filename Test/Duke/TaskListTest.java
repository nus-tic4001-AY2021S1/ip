package duke;

import duke.tasks.Deadlines;
import duke.tasks.Events;
import duke.tasks.Task;
import duke.tasks.ToDos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    ToDos todo1 = new ToDos("read book");
    ToDos todo2 = new ToDos("read two book");
    Deadlines deadline1 = new Deadlines("watch movies", "2020-09-14");
    Events event1 = new Events("book a room", "2020-09-15");

    @Test
    void findKeywordList() {
        ArrayList<Task> a = new ArrayList<>();
        TaskList original = new TaskList();
        String keyword = "book";

        a.add(todo1);
        a.add(todo2);
        a.add(event1);

        original.add(todo1);
        original.add(todo2);
        original.add(deadline1);
        original.add(event1);

        assertEquals(a, original.findKeywordList(keyword));

    }
}