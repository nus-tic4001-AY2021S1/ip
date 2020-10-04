import Command.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    String cmdTodo="todo go to gym";
    String cmdDeadline="deadline buy milk /by 2020-08-15";
    String cmdEvent="event attend wedding /at 2020-08-16";
    String cmdList = "list";
    String cmdDelete = "delete 3";
    String cmdDone = "done 2";
    String cmdUnknown = "that's all?";

    @Test
    void getCommand() {
        Command todo = new TodoCommand("todo go to gym");
        Command deadline = new DeadlineCommand("buy milk","2020-08-15");
        Command event = new EventCommand("attend wedding","2020-08-16");
        Command list = new ListCommand();
        Command delete = new DeleteCommand("3");
        Command done = new DoneCommand("2");
        Command unknown = new OtherCommand("that");

        try {

            assertEquals(todo.getCommandType(), Parser.getCommand(cmdTodo).getCommandType());
            assertEquals(deadline.getCommandType(),Parser.getCommand(cmdDeadline).getCommandType());
            assertEquals(event.getCommandType(),Parser.getCommand(cmdEvent).getCommandType());
            assertEquals(list.getCommandType(),Parser.getCommand(cmdList).getCommandType());
            assertEquals(delete.getCommandType(),Parser.getCommand(cmdDelete).getCommandType());
            assertEquals(done.getCommandType(),Parser.getCommand(cmdDone).getCommandType());
            assertEquals(unknown.getCommandType(),Parser.getCommand(cmdUnknown).getCommandType());

            assertEquals(todo.getCommandType(), Parser.getCommand(cmdTodo).getCommandType());
            assertEquals(deadline.getCommandType(),Parser.getCommand(cmdDeadline).getCommandType());
            assertEquals(event.getCommandType(),Parser.getCommand(cmdEvent).getCommandType());
            assertEquals(delete.getCommandType(),Parser.getCommand(cmdDelete).getCommandType());
            assertEquals(done.getCommandType(),Parser.getCommand(cmdDone).getCommandType());

        }catch(Exception e){
            e.getMessage();
        }
    }
}