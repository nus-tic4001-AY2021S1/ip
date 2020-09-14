import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    String line = "event visit company";


    @Test
    void filterTaskDetails987 (String line) throws Exception {
        Parser.filterTaskDetails(line);

    }

    @Test
    void getSecondWord() {
    }

    @Test
    void getCommand() {
    }
}