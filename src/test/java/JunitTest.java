
import NUS.Duke.utils.ParserUtil;
import NUS.Duke.utils.UI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitTest {

    @Test
    void junitTest() {
        ParserUtil parserUtil = new ParserUtil();
        UI ui = new UI();

        parserUtil.createTodoTask("Buy food",0);
        parserUtil.createDeadlineTask("Happy Birthday To dad /by 2020-01-22",0);
        parserUtil.createTodoTask("TodoTest",0);
        ui.printList(parserUtil.taskList);

        assertTrue(parserUtil.taskList.size()==3);
    }
}
