import org.junit.jupiter.api.Test;

import task.Tasks;
import task.ToDos;
import task.Deadlines;
import task.Events;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    ToDos todo1 = new ToDos("go to gym");
    ToDos todo2 = new ToDos("go to supermarket");
    Deadlines ddl1 = new Deadlines("buy milk", "2020-08-15");
    Events event1 = new Events("attend wedding", "2020-08-16");

    @Test
    void findTask() {

        ArrayList<Tasks> taskList= new ArrayList<>();
        TaskList original = new TaskList();
        String keyword = "supermarket";

        taskList.add(todo2);

        original.add(todo1);
        original.add(todo2);
        original.add(ddl1);
        original.add(event1);

        assertEquals(taskList, original.findTask(keyword));
    }
}