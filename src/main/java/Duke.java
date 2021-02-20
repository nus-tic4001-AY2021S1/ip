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

    private Ui ui;
    private Storage storage;
    private TaskList tasks;


    /**
     * @param filepath the path of duke.txt file
     */
    public Duke(String filepath) {
        this.ui = new Ui();
        this.storage = new Storage(filepath);
        this.tasks = new TaskList();
    }

    /**
     * @param args main method to run the program
     */
    public static void main(String[] args) {
        new Duke("./data/duke.txt").run();

    }

    /**
     * This method firstly print the greeting message to the user
     * Then it will check if a data file is existed, if existed load the data file otherwise create a new data file
     * Then it will parse user command to readable format and check if the commands are in the correct format
     * Finally it will execute the user command and save changes to the data file
     */
    public void run() {

        ui.printLine();
        ui.printGreetMsg();
        ui.printLine();

        //Check if a data file is existed. If Existed, load the task from the data file, otherwise create a data file.
        try {
            storage.loadFromFile(tasks);
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
        }

        //Parse user command to readable format
        while (true) {
            String userInput = ui.getCommand();
            Command cmd = null;
            try {
                cmd = Parser.getCommand(userInput);
            } catch (DukeException e) {
                ui.print(e.getMessage());
                continue;
            } catch (Exception e) {
                ui.print("☹ OOPS!!! Please try again.");
                continue;
            }
            //Check if user commands are in correct format
            if (cmd instanceof InvalidCommand && cmd.getCommandType().equalsIgnoreCase("bye")) {
                break;
            } else if (cmd instanceof InvalidCommand) {
                ui.print(new DukeException("☹ OOPS!!! I'm sorry, "
                        + "I don't understand what are you trying to say").getMessage());
                continue;
            }

            //Execute the user command and update teh data file whenever user makes any changes
            executeCommand(cmd, tasks);
        }

        ui.printExitMsg();
        ui.printLine();

    }

    /**
     * @param cmd   User inputs
     * @param tasks A TaskList
     */
    private void executeCommand(Command cmd, TaskList tasks) {
        switch (cmd.getCommandType()) {
        case "list" :
            ui.printTaskList(tasks);
            break;
        case "done":
            changeTaskStatus(tasks, true, cmd);
            updateDataFile(tasks);
            break;
        case "todo":
            ToDos todo = new ToDos(cmd.getCommandContent());
            tasks.add(todo);
            ui.printTask(todo, tasks);
            updateDataFile(tasks);
            break;
        case "deadline":
            Deadlines ddl = new Deadlines(cmd.getCommandContent(), ((DeadlineCommand) cmd).getTime());
            tasks.add(ddl);
            ui.printTask(ddl, tasks);
            updateDataFile(tasks);
            break;
        case "event":
            Events event = new Events(cmd.getCommandContent(), ((EventCommand) cmd).getTime());
            tasks.add(event);
            ui.printTask(event, tasks);
            updateDataFile(tasks);
            break;
        case "delete":
            deleteTask(tasks, cmd);
            updateDataFile(tasks);
            break;
        case "find":
            findTask(tasks, cmd);
            break;
        default:
            break;
        }
    }

    /**
     * This method will mark task status to "Done"
     *
     * @param tasks  The task that need to be updated as "Done"
     * @param status true is done, false is not done
     * @param cmd    User Input
     */
    public void changeTaskStatus(TaskList tasks, boolean status, Command cmd) {
        int index = ((DoneCommand) cmd).getIndex();
        tasks.get(index - 1).setTaskStatus(status);
        ui.print("Nice! I've marked this task as done: ");
        ui.print(tasks.get(index - 1).toString());
    }


    /**
     * @param tasks the task that need to be deleted
     * @param cmd   user inputs
     */
    public void deleteTask(TaskList tasks, Command cmd) {
        int index = ((DeleteCommand) cmd).getIndex();
        ui.print(" Noted. I've removed this task:  ");
        ui.print(tasks.get(index - 1).toString());
        tasks.remove(index - 1);
        ui.print("Now you have " + tasks.size() + " task(s) in the list.");

    }

    /**
     * @param tasks the updated list of tasks that will be saved to the data file
     */
    public void updateDataFile(TaskList tasks) {
        Storage storage = new Storage("/data/duke.txt");
        try {
            storage.saveToFile(tasks);
        } catch (IOException e) {
            ui.print("☹ OOPS!!!Update failed. Something went wrong when save data to the data file, please try again.");
        }
    }

    /**
     * @param tasks the list of all the tasks
     * @param cmd   keywords used to search for the tasks
     */
    public void findTask(TaskList tasks, Command cmd) {
        int i = 1;
        ui.print("Here are the matching tasks in your list:");
        for (Tasks t : tasks.findTask(cmd.getCommandContent())) {
            ui.print(i + "." + t.toString());
            i++;
        }
    }

}
