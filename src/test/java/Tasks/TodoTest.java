package Tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    private Todo task1 = new Todo("To try out Todo");

    @Test
    void testToString() {
        assertEquals("[T][✘] To try out Todo", task1.toString());
    }
}