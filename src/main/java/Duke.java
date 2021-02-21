import java.io.IOException;

import command.Command;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.DoneCommand;
import command.EventCommand;
import command.InvalidCommand;
import exceptions.DukeException;
import task.Deadlines;
import task.Events;
import task.Tasks;
import task.ToDos;


/**
 * This class implements the Duke chatbot that can interact with user,
 * it can read from user inputs, give user outputs and save user inputs.
 */
public class Duke {

    static final String PATH = "/data/duke.txt";
    static final String HELLO = " Hello! I'm Duke\n" + " What can I do for you?";
    static final String BYE = " Bye. Hope to see you again soon!";


    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * constructor
     */
    public Duke() {
        this.ui = new Ui();
        this.storage = new Storage(PATH);
        this.tasks = new TaskList();
    }

    String loadFile() {
        try {
            storage.load(tasks);
            return "Load data successfully.";
        } catch (DukeException | IOException e) {
            return "Load data fails. Reason: " + e.getMessage();
        }
    }

    private static String executeCommand(Command cmd, TaskList tasks, Ui ui) {
        StringBuffer s = new StringBuffer();
        switch (cmd.getCommandType()) {
        case "list" :
            s.append("Here are the tasks in your list:" + System.lineSeparator());
            listTasks(tasks, s);
            return s.toString();
        case "done":
            changeTaskStatus(tasks, cmd, s);
            return s.toString();
        case "todo":
            ToDos todo = new ToDos(cmd.getCommandContent());
            tasks.add(todo);
            return ui.printTask(todo, tasks);
        case "deadline":
            Deadlines ddl = new Deadlines(cmd.getCommandContent(), ((DeadlineCommand) cmd).getTime());
            tasks.add(ddl);
            return ui.printTask(ddl, tasks);
        case "event":
            Events event = new Events(cmd.getCommandContent(), ((EventCommand) cmd).getTime());
            tasks.add(event);
            return ui.printTask(event, tasks);
        case "delete":
            deleteTask(tasks, cmd, s);
            return s.toString();
        case "find":
            s.append("Here are the matching tasks in your list:" + System.lineSeparator());
            return s.toString();
        case "help":
            printHelpInfor(s);
            return s.toString();
        default:
            return "Nothing has been done, please try again.";
        }
    }

    private static void changeTaskStatus(TaskList tasks, Command cmd, StringBuffer s) {
        int index = ((DoneCommand) cmd).getIndex();
        tasks.get(index - 1).setTaskStatus(true);
        s.append("Cool! I've marked this task as done: " + System.lineSeparator());
        s.append(tasks.get(index - 1).toString() + System.lineSeparator());
    }

    private static void deleteTask(TaskList tasks, Command cmd, StringBuffer s) {
        int index = ((DeleteCommand) cmd).getIndex();
        s.append("Noted. I've removed this task: " + System.lineSeparator());
        s.append(tasks.get(index - 1).toString() + System.lineSeparator());
        tasks.remove(index - 1);
        s.append("Now you have " + tasks.size() + " task(s) in the list.");
    }

    private static void findTask(TaskList tasks, Command cmd, StringBuffer s) {
        int i = 1;
        for (Tasks t : tasks.findTask(cmd.getCommandContent())) {
            s.append(i + "." + t.toString() + System.lineSeparator());
            i++;
        }
    }

    private static void listTasks(TaskList tasks, StringBuffer s) {
        int i = 1;
        for (Tasks t : tasks.getAllTaskList()) {
            s.append(i + "." + t.toString() + System.lineSeparator());
            i++;
        }
    }

    private static void printHelpInfor(StringBuffer s) {
        String help = "Below is the table to summarise the features and its relevant commands:\n"
                + " - 1. Add a todo task: todo + task name \n"
                + " - 2. Add a deadline task: deadline + (task name)+  /by + (date) \n"
                + " - 3. Add an event task: event + (task name) +  /at + (date)  \n"
                + " - 4. List all tasks: list \n"
                + " - 5. Set task status as completed: done + (task id) \n"
                + " - 6.  Find (search) tasks: find + (key word) \n"
                + " - 7. Delete a task: delete + (task id) \n"
                + " - 8. Exit the program: bye \n"
                + " - 9. Help: Help \n"
                + "*More help information, please visit https://yiheng0410.github.io/ip/)\n";
        s.append(help);
    }

    String getResponse(String input) {
        Command cmd = null;
        String result = null;
        try {
            cmd = Parser.getCommand(input);
        } catch (DukeException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "OOPS!!! Unknown internal error occurs.";
        }
        if (cmd instanceof InvalidCommand && cmd.getCommandType().equalsIgnoreCase("bye")) {
            return BYE;
        } else if (cmd instanceof InvalidCommand) {
            return new DukeException("OOPS!!! I'm sorry, please enter a valid command:-(").getMessage();
        }
        try {
            result = executeCommand(cmd, tasks, ui);
        } catch (Exception e) {
            result = new DukeException("OOPS!!! Unknown error occurs when process command.").getMessage();
        }
        try {
            storage.save(tasks);
        } catch (IOException e) {
            return "OOPS!!!Updating file is fail.";
        }
        return result;
    }
}
