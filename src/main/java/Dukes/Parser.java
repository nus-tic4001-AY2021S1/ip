package Dukes;

import Dukes.Exceptions.DukeException;
import Dukes.command.AddCommand;
import Dukes.command.DeleteCommand;
import Dukes.command.DoneCommand;
import Dukes.command.ExitCommand;
import Dukes.command.Command;
import Dukes.command.ListCommand;

/**
 * Parser program containing methods that deals with parsing the user command to extract meaningful details from it.
 */
public class Parser {
    /**
     * Processes the user input and creates the corresponding commands.
     * @param input Command input by user.
     * @return Corresponding command that is input by user.
     * @throws <code>DukeException</code>If a new command cannot be created due to invalid input parameters.
     */

    public static Command parse(String input) throws DukeException {
        Task taskWord;
        Command c;
        String action = input.split(" ")[0].toLowerCase();
        switch (action) {
            case "list":
                c = new ListCommand();
                break;

            case "todo":
                if (input.length() < 6) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                taskWord = new ToDo(input.substring(5));
                c = new AddCommand(taskWord);
                break;

            case "delete":
                if (input.isEmpty() || input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! There is no specific task to delete.\n");
                }
                int toDelete = Ui.indexDetails(input);
                c = new DeleteCommand(toDelete);
                break;

            case "done":
                if (input.length() < 6) {
                    throw new DukeException("please key in correct format.\n");
                }
                int toEdit = Ui.indexDetails(input);
                c = new DoneCommand(toEdit);
                break;

            case "deadline":
                if (input.length() < 10) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                }
                String[] splitDetail = input.split("/by");
                if (splitDetail.length < 2) {
                    throw new DukeException("Please specify the deadline time\n");
                }
                String task = splitDetail[0].substring(9);
                String by = splitDetail[1];
                taskWord = new Deadline(task, by);
                c = new AddCommand(taskWord);
                break;

            case "event":
                if (input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n");
                }
                String[] splitEvent = input.split("/at");
                if (splitEvent.length < 2) {
                    throw new DukeException("Please specify the event time\n");
                }
                String event = splitEvent[0].substring(7);
                String time = splitEvent[1];
                taskWord = new Event(event, time);
                c = new AddCommand(taskWord);
                break;

            case "bye":
            case "exit":
                c = new ExitCommand();
                break;

            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        return c;
    }
}




  /*  private static Command list() {
        return new ListCommand();
    }
    private void addCommandTask(String input) {
        Task taskWord;
        try {
            if (input.startsWith("todo") && input.contains(" ")) {

                addTask(taskWord);
            } else if (input.startsWith("deadline") && input.contains(" ")) {
                if (input.length() < 10) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                }
                String[] splitDetail = input.split("/by");
                if (splitDetail.length < 2) {
                    throw new DukeException("Please specify the deadline time\n");
                }
                String task = splitDetail[0];
                String by = splitDetail[1];
                taskWord = new Deadline(task, by);
                //taskWord = new Deadline(task, Deadline.timeChange(by));
                addTaskCase(taskWord);
            } else if (input.startsWith("event") && input.contains(" ")) {
                if (input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n");
                }
                String[] splitEvent = input.split("/at");
                if (splitEvent.length < 2) {
                    throw new DukeException("Please specify the event time\n");
                }
                String event = splitEvent[0];
                String time = splitEvent[1];
                taskWord = new Event(event, time);
                addTaskCase(taskWord);
            } else if(input.startsWith("delete") && input.contains(" ")){
                if(tasks.isEmpty() || input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! There is no specific task to delete.\n");
                }
                int toDelete = Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
                Task task = tasks.getTask(toDelete);
                tasks.deleteTask(toDelete);
                System.out.println("Noted, I've removed the following task:\n"
                        + "  "
                        + task
                        + "\n"
                        + "Now you have "
                        + tasks.getSize()
                        + " tasks in the list.");
            } else if (input.startsWith("done") && input.contains(" ")) {
                if (input.length() < 6) {
                    throw new DukeException("please key in correct format.\n");
                }
                else if(tasks.isEmpty()){
                    throw new DukeException("There is no task need to be done\n");
                }
                int toEdit = Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
                Task task = tasks.getTask(toEdit);
                task.setDone();
                System.out.println("     Nice! I've marked this task as done:\n"
                        + task
                        + "\n"
                        + "___________________________________________________________________\n");
            }else{
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
            }
        }catch (DukeException e) {
            System.out.print(e.getMessage());
        } catch (Exception e) {
            assert false : "Uncaught exception";
            System.out.println("Please input a date in this format : dd/MM/yy HHmm");
        }

    }


}*/
