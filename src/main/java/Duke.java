import Duke.Command.*;
import Duke.Exceptions.DukeException;
import Duke.Tasks.Deadlines;
import Duke.Tasks.Events;
import Duke.Tasks.Task;
import Duke.Tasks.ToDos;
import Duke.Ui;
import Duke.Storage;
import Duke.Parser;
import Duke.TaskList;

import java.io.IOException;

public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    static final String HELLO = " Hello! I'm Duke\n" +
            " What can I do for you?";

    static final String BYE = " Bye. Hope to see you again soon!";

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
            if (cmd instanceof OtherCommand && cmd.getCMDType().equalsIgnoreCase("bye")) {
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
        switch (cmd.getCMDType()) {
            case "list":
                ui.show("Here are the tasks in your list:");
                int i = 1;
                for (Task t : tasks.getWholeList()) {
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
                ToDos t = new ToDos(cmd.getCMDContent());
                tasks.add(t);
                ui.printTask(t, tasks);
                break;
            case "deadline":
                Deadlines d = new Deadlines(cmd.getCMDContent(), ((DeadlineCommand) cmd).getTime());
                tasks.add(d);
                ui.printTask(d, tasks);
                break;
            case "event":
                Events e = new Events(cmd.getCMDContent(), ((EventCommand) cmd).getTime());
                tasks.add(e);
                ui.printTask(e, tasks);
                break;
        }
    }

}
