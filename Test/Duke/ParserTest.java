package duke;

import duke.command.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    String cmdTodo="todo read book";
    String cmdDeadline="deadline watch movie /by 2020-09-14";
    String cmdEvent="event meeting with John /at 2020-09-20";
    String cmdList = "list";
    String cmdDelete = "delete 1";
    String cmdDone = "done 1";
    String cmdUnknown = "what is this?";

    @Test
    void getCommand() {
        Command todo = new TodoCommand("read book");
        Command deadline = new DeadlineCommand("watch movie","2020-09-14");
        Command event = new EventCommand("meeting with John","2020-09-20");
        Command list = new ListCommand();
        Command delete = new DeleteCommand("1");
        Command done = new DoneCommand("1");
        Command unknown = new OtherCommand("what");

        try {

            assertEquals(todo.getCMDType(), Parser.getCommand(cmdTodo).getCMDType());
            assertEquals(deadline.getCMDType(),Parser.getCommand(cmdDeadline).getCMDType());
            assertEquals(event.getCMDType(),Parser.getCommand(cmdEvent).getCMDType());
            assertEquals(list.getCMDType(),Parser.getCommand(cmdList).getCMDType());
            assertEquals(delete.getCMDType(),Parser.getCommand(cmdDelete).getCMDType());
            assertEquals(done.getCMDType(),Parser.getCommand(cmdDone).getCMDType());
            assertEquals(unknown.getCMDType(),Parser.getCommand(cmdUnknown).getCMDType());

            assertEquals(todo.getCMDContent(), Parser.getCommand(cmdTodo).getCMDContent());
            assertEquals(deadline.getCMDContent(),Parser.getCommand(cmdDeadline).getCMDContent());
            assertEquals(event.getCMDContent(),Parser.getCommand(cmdEvent).getCMDContent());
            assertEquals(delete.getCMDContent(),Parser.getCommand(cmdDelete).getCMDContent());
            assertEquals(done.getCMDContent(),Parser.getCommand(cmdDone).getCMDContent());

        }catch(Exception e){
            e.getMessage();
        }

    }
}