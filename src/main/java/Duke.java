import Task.Deadlines;
import Task.Events;
import Task.Tasks;
import Task.ToDos;
import Exceptions.DukeException;
import Command.*;

import java.io.IOException;


/**
 * This class implements the Duke chatbot that can interact with user, it can read from user inputs, give user outputs and save user inputs.
 */
public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    static final String greetMsg = " Hello! I'm Duke\n" + logo +
            " What can I do for you?";

    static final String exitMsg = " Bye. Hope to see you again soon!";

    public Duke(String filepath) {
        this.ui = new Ui();
        this.storage = new Storage(filepath);
        this.tasks = new TaskList();
    }

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
        ui.print(greetMsg);
        ui.printLine();

          /*
        1. Check if a data file is existed.
           If Existed, load the task from the data file, otherwise create a data file.
         */
        try {
            storage.loadFromFile(tasks);
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
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
                ui.print(e.getMessage());
                continue;
            } catch (Exception e) {
                ui.print("☹ OOPS!!! Please try again.");
                continue;
            }

            /*
            3.Check if user commands are
            in correct format
             */
            if (cmd instanceof OtherCommand && cmd.getCommandType().equalsIgnoreCase("bye")) {
                break;
            }
            else if (cmd instanceof OtherCommand) {
                ui.print(new DukeException("☹ OOPS!!! I'm sorry, I don't understand what are you trying to say").getMessage());
                continue;
            }

            /*
            4.Execute the user command and update teh data file whenever user makes any changes
             */
            executeCommand(cmd, tasks);
        }

        ui.print(exitMsg);
        ui.printLine();

    }

    /**
     * @param cmd User inputs
     * @param tasks A TaskList
     */
    private static void executeCommand(Command cmd, TaskList tasks) {
        switch (cmd.getCommandType()) {
            case "list": {
                printTaskList(tasks);
                break;
            }
            case "done":
                changeTaskStatus(tasks, true, cmd);
                updateDataFile(tasks);
                break;
            case "todo":
                ToDos todo = new ToDos(cmd.getCommandContent());
                tasks.add(todo);
                printTask(todo, tasks);
                updateDataFile(tasks);
                break;
            case "deadline":
                Deadlines ddl = new Deadlines(cmd.getCommandContent(), ((DeadlineCommand) cmd).getTime());
                tasks.add(ddl);
                printTask(ddl, tasks);
                updateDataFile(tasks);
                break;
            case "event":
                Events event = new Events(cmd.getCommandContent(), ((EventCommand) cmd).getTime());
                tasks.add(event);
                printTask(event, tasks);
                updateDataFile(tasks);
                break;
            case "delete":
                deleteTask(tasks, cmd);
                updateDataFile(tasks);
                break;
            case "find":
                findTask(tasks, cmd);
                break;
        }
    }


    /**
     * This method will mark task status to "Done"
     * @param tasks The task that need to be updated as "Done"
     * @param status true is done, false is not done
     * @param cmd User Input
     */
    public static void changeTaskStatus(TaskList tasks, boolean status, Command cmd) {
        int index = ((DoneCommand) cmd).getIndex();
        tasks.get(index - 1).setTaskStatus(status);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks.get(index - 1).toString());
    }

    /**
     * @param task The new added task
     * @param tasks The list contains all tasks
     */
    public static void printTask(Tasks task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
    }

    /**
     * @param tasks The list contains all tasks
     */
    public static void printTaskList(TaskList tasks) {
        int index = 1;
        for (Tasks task : tasks.getAllTaskList()) {
            System.out.println(index + "." + task.toString());
            index++;
        }
    }

    /**
     * @param tasks the task that need to be deleted
     * @param cmd user inputs
     */
    public static void deleteTask(TaskList tasks, Command cmd) {
        int index = ((DeleteCommand) cmd).getIndex();
        System.out.println(" Noted. I've removed this task:  ");
        System.out.println(tasks.get(index - 1).toString());
        tasks.remove(index - 1);
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");

    }

    /**
     * @param tasks the updated list of tasks that will be saved to the data file
     */
    public static void updateDataFile(TaskList tasks) {
        Storage storage = new Storage("/data/duke.txt");
        try {
            storage.saveToFile(tasks);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!!Update failed. Something went wrong when save data to the data file, please try again.");
        }
    }

    /**
     * @param tasks the list of all the tasks
     * @param cmd keywords used to search for the tasks
     */
    public static void findTask(TaskList tasks, Command cmd) {
        int i = 0;
        System.out.println("Here are the matching tasks in your list:");
        for (Tasks t : tasks.findTask(cmd.getCommandContent())) {
            System.out.println(i + "." + t.toString());
            i++;
        }
    }

}
