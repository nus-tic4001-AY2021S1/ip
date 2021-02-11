import java.io.IOException;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.OtherCommand;
import duke.command.TagCommand;
import duke.exceptions.DukeException;
import duke.tasks.Deadlines;
import duke.tasks.Events;
import duke.tasks.Task;
import duke.tasks.ToDos;

public class Duke {

    static final String HELLO = " Hello! I'm Duke\n" + " What can I do for you?";

    static final String BYE = " Bye. Hope to see you again soon!";

    static final String path = "/data/duke.txt";
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * constructor
     */
    public Duke() {
        this.ui = new Ui();
        this.storage = new Storage(path);
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

    private static String processCommand(Command cmd, TaskList tasks, Ui ui) {
        StringBuffer s = new StringBuffer();

        switch (cmd.getCmdType()) {
        case "list":
            s.append("Here are the tasks in your list:" + System.lineSeparator());
            listTasks(tasks, s);
            return s.toString();
        case "find":
            s.append("Here are the matching tasks in your list:" + System.lineSeparator());
            findKeywordTasks(tasks, cmd, s);
            return s.toString();
        case "done":
            setTaskDone(tasks, cmd, s);
            return s.toString();
        case "delete":
            deleteTask(tasks, cmd, s);
            return s.toString();
        case "tag":
            tagTask(tasks, cmd, s);
            return s.toString();
        case "todo":
            Task t = addTodoTask(tasks, cmd);
            return ui.printTask(t, tasks);
        case "deadline":
            Task d = addDeadlineTask(tasks, cmd);
            return ui.printTask(d, tasks);
        case "event":
            Task e = addEventTask(tasks, cmd);
            return ui.printTask(e, tasks);
        default:
            return "Nothing done bro.";
        }
    }

    private static Task addEventTask(TaskList tasks, Command cmd) {
        Events e = new Events(cmd.getCmdContent(), ((EventCommand) cmd).getTime());
        tasks.add(e);
        return e;
    }

    private static Task addDeadlineTask(TaskList tasks, Command cmd) {
        Deadlines d = new Deadlines(cmd.getCmdContent(), ((DeadlineCommand) cmd).getTime());
        tasks.add(d);
        return d;
    }

    private static Task addTodoTask(TaskList tasks, Command cmd) {
        ToDos t = new ToDos(cmd.getCmdContent());
        tasks.add(t);
        return t;
    }

    private static void tagTask(TaskList tasks, Command cmd, StringBuffer s) {
        int index = ((TagCommand) cmd).getIndex();
        tasks.get(index - 1).addTag(cmd.getCmdContent());
        s.append("Adding tag " + cmd.getCmdContent() + " to task: " + index + System.lineSeparator());
    }

    private static void deleteTask(TaskList tasks, Command cmd, StringBuffer s) {
        int index = ((DeleteCommand) cmd).getIndex();
        s.append("Noted. I've removed this task: " + System.lineSeparator());
        s.append(tasks.get(index - 1).toString() + System.lineSeparator());
        tasks.remove(index - 1);
        s.append("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void setTaskDone(TaskList tasks, Command cmd, StringBuffer s) {
        int index = ((DoneCommand) cmd).getIndex();
        tasks.get(index - 1).setDone(true);
        s.append("Nice! I've marked this task as done: " + System.lineSeparator());
        s.append(tasks.get(index - 1).toString() + System.lineSeparator());
    }

    private static void findKeywordTasks(TaskList tasks, Command cmd, StringBuffer s) {
        int i = 1;
        for (Task t : tasks.findKeywordList(cmd.getCmdContent())) {
            s.append(i + "." + t.toString() + System.lineSeparator());
            i++;
        }
    }

    private static void listTasks(TaskList tasks, StringBuffer s) {
        int i = 1;
        for (Task t : tasks.getWholeList()) {
            s.append(i + "." + t.toString() + System.lineSeparator());
            i++;
        }
    }

    /*
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */

    String getResponse(String input) {
        Command cmd = null;
        String result = null;

        try {
            cmd = Parser.getCommand(input);
        } catch (DukeException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "☹ OOPS!!! Unknown internal error occurs.";
        }

        if (cmd instanceof OtherCommand && cmd.getCmdType().equalsIgnoreCase("bye")) {
            return BYE;
        } else if (cmd instanceof OtherCommand) {
            return new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(").getMessage();
        }

        try {
            result = processCommand(cmd, tasks, ui);
        } catch (Exception e) {
            result = new DukeException("☹ OOPS!!! Unknown error occurs when process command.").getMessage();
        }

        try {
            storage.save(tasks);
        } catch (IOException e) {
            return "☹ OOPS!!!Updating file is fail.";
        }

        return result;

    }

}
