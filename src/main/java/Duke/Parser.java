package Duke;

import Duke.Command.*;
import Duke.Exceptions.DukeException;

import javax.print.attribute.standard.MediaSize;

public class Parser {

    private static String DEADLINE_SPLITER = "/by";
    private static String EVENT_SPLITER = "/at";

    public static String[] commandSplit(String s,String splitBy){
        return s.split(splitBy);
    }

    public static Command getCommand(String userInput) throws DukeException {
        String[] cmd = Parser.commandSplit(userInput,"\\s+");
        switch(cmd[0]){
            case "list":
                return new ListCommand();
            case "done":
                try {
                    return new DoneCommand(userInput.split(" ")[1]);
                }catch(IndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The task does not exist.");
                }catch (NumberFormatException e) {
                    throw new DukeException("☹ OOPS!!! Please specify the task need to be done.");
                }
            case "delete":
                try {
                    return new DeleteCommand(userInput.split(" ")[1]);
                }catch(IndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The task does not exist.");
                }catch (NumberFormatException e) {
                    throw new DukeException("☹ OOPS!!! Please specify the number of the task need to be delete.");
                }
            case "todo":
                try {
                    return new TodoCommand(userInput.substring(5, userInput.length()));
                }catch(StringIndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            case "deadline":
                try {
                    String[] deadlineContent = userInput.split(DEADLINE_SPLITER);
                    return new DeadlineCommand(deadlineContent[0].substring(9, deadlineContent[0].length()), deadlineContent[1]);
                }catch(StringIndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }catch(ArrayIndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The keyword /by is missing.");
                }
            case "event":
                try {
                    String[] eventContent = userInput.split(EVENT_SPLITER);
                    return new EventCommand(eventContent[0].substring(6, eventContent[0].length()), eventContent[1]);
                }catch(StringIndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                }catch(ArrayIndexOutOfBoundsException e){
                    throw new DukeException("☹ OOPS!!! The keyword /at is missing.");
                }
            default:
                return new OtherCommand(cmd[0]);
        }
    }

}
