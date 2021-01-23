import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListTest {


    private Todo taskT = new Todo("To try out Todo");

    DateTimeFormatter formatterDT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formatDateTime = LocalDateTime.parse("2020-10-14 22:00", formatterDT);
    private Event taskE = new Event("To try out Event", formatDateTime);


    DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate formatDate = LocalDate.parse("2020-10-14", formatterD);
    private duke.tasks.Deadline taskD = new Deadline("To try out Event",formatDate);



    // An array list of task objects
    private static ArrayList<Task> taskList;

    /** .
     * creating an TodoList object
     */
    public TaskListTest() {
        taskList = new ArrayList<>();
        taskList.add(taskT);
        taskList.add(taskE);
        taskList.add(taskD);
        System.out.println(taskList);

    }

    @Test
    void getList() {
        assertEquals("[[T][X] To try out Todo, [E][X] To try out Event "
                + "(at: Wednesday, Oct 14, 2020 22:00:00 PM), "
                +  "[D][X] To try out Event (by: Wednesday, October 14, 2020)]", taskList.toString());
    }


}