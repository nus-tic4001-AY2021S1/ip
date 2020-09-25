package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void testStringConversion() {
        assertEquals("[D][✘] 111 (by: Sep 18 2020)" , new Deadline("111", "2020-09-18").toString());
    }
}
