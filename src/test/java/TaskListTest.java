import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {


    private Todo task1 = new Todo("To try out Todo");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formatDateTime = LocalDateTime.parse("2020-10-14 22:00", formatter);
    private Event task2 = new Event("To try out Event", formatDateTime);



/*
    [[T][✘] write a program,
    [E][✓] visit zoo (at: 星期二, 11月 10, 2020 10:30:00 上午),
    [D][✓] read book (by: 2020年11月23日星期一),
    [T][✘] hahah, [T][✘] sdfhskj,
    [D][✘] dksfh (by: 2022年12月12日星期一),
    [T][✓] MEET FRIENDS,
    [E][✘] be happy (at: 星期六, 10月 10, 2020 11:11:00 上午),
    [D][✘] to submit assignment (by: 2020年10月11日星期日)]
*/


    @Test
    void getList() {
    }

    @Test
    void listAllTasks() {
    }

    @Test
    void isValidDateTimeFormat() {
    }

    @Test
    void addToDoType() {
    }

    @Test
    void addDeadlineType() {
    }

    @Test
    void addEventType() {
    }

    @Test
    void readTaskFromUser() {
    }

    @Test
    void markSelectedTaskDelete() {
    }

    @Test
    void markSelectedTaskDone() {
    }

    @Test
    void findTaskByKeyword() {
    }
}