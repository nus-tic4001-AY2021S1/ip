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

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * @param relativePath constructor, generate Duke with an relative path
     */
    public Duke(String relativePath) {
        this.ui = new Ui();
        this.storage = new Storage(relativePath);
        this.tasks = new TaskList();
    }

    /**
     * @param args A commandline starting args.
     */
    public static void main(String[] args) {
        new Duke("/data/duke.txt").run();
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

    private static void processCommand(Command cmd, TaskList tasks, Ui ui) {
        int index;
        int i = 1;

        switch (cmd.getCmdType()) {
        case "list":
            ui.show("Here are the tasks in your list:");
            for (Task t : tasks.getWholeList()) {
                ui.show(i + "." + t.toString());
                i++;
            }
            break;
        case "find":
            ui.show("Here are the matching tasks in your list:");
            for (Task t : tasks.findKeywordList(cmd.getCmdContent())) {
                ui.show(i + "." + t.toString());
                i++;
            }
            break;
        case "done":
            index = ((DoneCommand) cmd).getIndex();
            tasks.get(index - 1).setDone(true);
            ui.show("Nice! I've marked this task as done: ");
            ui.show(tasks.get(index - 1).toString());
            break;
        case "delete":
            index = ((DeleteCommand) cmd).getIndex();
            ui.show("Noted. I've removed this task: ");
            ui.show(tasks.get(index - 1).toString());
            tasks.remove(index - 1);
            ui.show("Now you have " + tasks.size() + " tasks in the list.");
            break;
        case "todo":
            ToDos t = new ToDos(cmd.getCmdContent());
            tasks.add(t);
            ui.printTask(t, tasks);
            break;
        case "deadline":
            Deadlines d = new Deadlines(cmd.getCmdContent(), ((DeadlineCommand) cmd).getTime());
            tasks.add(d);
            ui.printTask(d, tasks);
            break;
        case "event":
            Events e = new Events(cmd.getCmdContent(), ((EventCommand) cmd).getTime());
            tasks.add(e);
            ui.printTask(e, tasks);
            break;
        default:
            break;
        }
    }

}
