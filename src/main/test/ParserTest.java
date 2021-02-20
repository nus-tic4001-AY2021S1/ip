import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import command.Command;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.DoneCommand;
import command.EventCommand;
import command.InvalidCommand;
import command.ListCommand;
import command.TodoCommand;

class ParserTest {
    private String cmdTodo = "todo go to gym";
    private String cmdDeadline = "deadline buy milk /by 2020-08-15";
    private String cmdEvent = "event attend wedding /at 2020-08-16";
    private String cmdList = "list";
    private String cmdDelete = "delete 3";
    private String cmdDone = "done 2";
    private String cmdInvalid = "that's all?";

    @Test
    void getCommand() {
        Command todo = new TodoCommand("todo go to gym");
        Command deadline = new DeadlineCommand("buy milk", "2020-08-15");
        Command event = new EventCommand("attend wedding", "2020-08-16");
        Command list = new ListCommand();
        Command delete = new DeleteCommand("3");
        Command done = new DoneCommand("2");
        Command unknown = new InvalidCommand("that's");

        try {
            assertEquals(todo.getCommandType(), Parser.getCommand(cmdTodo).getCommandType());
            assertEquals(deadline.getCommandType(), Parser.getCommand(cmdDeadline).getCommandType());
            assertEquals(event.getCommandType(), Parser.getCommand(cmdEvent).getCommandType());
            assertEquals(list.getCommandType(), Parser.getCommand(cmdList).getCommandType());
            assertEquals(delete.getCommandType(), Parser.getCommand(cmdDelete).getCommandType());
            assertEquals(done.getCommandType(), Parser.getCommand(cmdDone).getCommandType());
            assertEquals(unknown.getCommandType(), Parser.getCommand(cmdInvalid).getCommandType());
            assertEquals(todo.getCommandType(), Parser.getCommand(cmdTodo).getCommandType());
            assertEquals(deadline.getCommandType(), Parser.getCommand(cmdDeadline).getCommandType());
            assertEquals(event.getCommandType(), Parser.getCommand(cmdEvent).getCommandType());
            assertEquals(delete.getCommandType(), Parser.getCommand(cmdDelete).getCommandType());
            assertEquals(done.getCommandType(), Parser.getCommand(cmdDone).getCommandType());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}