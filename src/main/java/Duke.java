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

    /**
     * Main method
     */
    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }

    /**
     * The normal run method.
     */
    public void run() {

        ui.showLine();
        ui.show(HELLO);
        ui.showLine();

        /*
        1. If a file exist, load it to memory, otherwise create a new file
         */
        try {
            storage.load(tasks);
        } catch (DukeException | IOException e) {
            ui.show(e.getMessage());
        }

        while (true) {
            String userInput = ui.getCommand();
            Command cmd = null;

            /*
            2.Parse user command to readable format
             */
            try {
                cmd = Parser.getCommand(userInput);
            } catch (DukeException e) {
                ui.show(e.getMessage());
                continue;
            } catch (Exception e) {
                ui.show("☹ OOPS!!! Unknown internal error occurs.");
                continue;
            }

            /*
            3.Check the user command whether is legal.
             */
            if (cmd instanceof OtherCommand && cmd.getCmdType().equalsIgnoreCase("bye")) {
                break;
            } else if (cmd instanceof OtherCommand) {
                ui.show(new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(").getMessage());
                continue;
            }

            /*
            4.Process the user command
             */
            processCommand(cmd, tasks, ui);

            /*
            5. Update the result to the file and  save it.
             */
            try {
                storage.save(tasks);
            } catch (IOException e) {
                ui.show("☹ OOPS!!!Updating file is fail.");
            }

            ui.showLine();
        }

        ui.show(BYE);
        ui.showLine();
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
        int index;
        int i = 1;
        StringBuffer s = new StringBuffer();

        switch (cmd.getCmdType()) {
        case "list":
            s.append("Here are the tasks in your list:" + System.lineSeparator());
            for (Task t : tasks.getWholeList()) {
                s.append(i + "." + t.toString() + System.lineSeparator());
                i++;
            }
            return s.toString();
        case "find":
            s.append("Here are the matching tasks in your list:" + System.lineSeparator());
            for (Task t : tasks.findKeywordList(cmd.getCmdContent())) {
                s.append(i + "." + t.toString() + System.lineSeparator());
                i++;
            }
            return s.toString();
        case "done":
            index = ((DoneCommand) cmd).getIndex();
            tasks.get(index - 1).setDone(true);
            s.append("Nice! I've marked this task as done: " + System.lineSeparator());
            s.append(tasks.get(index - 1).toString() + System.lineSeparator());
            return s.toString();
        case "delete":
            index = ((DeleteCommand) cmd).getIndex();
            s.append("Noted. I've removed this task: " + System.lineSeparator());
            s.append(tasks.get(index - 1).toString() + System.lineSeparator());
            tasks.remove(index - 1);
            s.append("Now you have " + tasks.size() + " tasks in the list.");
            return s.toString();
        case "todo":
            ToDos t = new ToDos(cmd.getCmdContent());
            tasks.add(t);
            return ui.printTask(t, tasks);
        case "deadline":
            Deadlines d = new Deadlines(cmd.getCmdContent(), ((DeadlineCommand) cmd).getTime());
            tasks.add(d);
            return ui.printTask(d, tasks);
        case "event":
            Events e = new Events(cmd.getCmdContent(), ((EventCommand) cmd).getTime());
            tasks.add(e);
            return ui.printTask(e, tasks);
        default:
            return "Nothing done bro.";
        }
    }

    /*
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */

    String getResponse(String input) {
        Command cmd = null;

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

        String result = processCommand(cmd, tasks, ui);

        try {
            storage.save(tasks);
        } catch (IOException e) {
            return "☹ OOPS!!!Updating file is fail.";
        }

        return result;

    }

}
