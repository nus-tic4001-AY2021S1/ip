package duke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoTest {
    private Todo task1 = new Todo("To try out Todo");

    @Test
    void testToString() {
        assertEquals("[T][X] To try out Todo", task1.toString());
    }
}