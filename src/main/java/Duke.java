import Task.Deadlines;
import Task.Events;
import Task.Tasks;
import Task.ToDos;
import Exceptions.DukeException;
import Command.*;

import java.io.IOException;



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

    public Duke(String path) {
        this.ui = new Ui();
        this.storage = new Storage(path);
        this.tasks = new TaskList();
    }

    public static void main(String[] args) {
//        ArrayList<Tasks> tasks = new ArrayList<>();
//        TaskList tasks= new TaskList();
//        Storage storage = new Storage("/Users/yiheng/school_project/ip-master/data/duke.txt");
//        Scanner scanner = new Scanner(System.in);

        new Duke("/Users/yiheng/school_project/ip-master/data/duke.txt").run();

    }


    public void run() {

        ui.printLine();
        ui.print(greetingMsg);
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
            3.Check if user command is in correct format
             */
            if (cmd instanceof OtherCommand && cmd.getCommandType().equalsIgnoreCase("bye")) {
                break;
            } else if (cmd instanceof OtherCommand) {
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
            case"find":
                findTask(tasks,cmd);
                break;
        }
    }


    public static void changeTaskStatus(TaskList tasks, boolean status, Command cmd) {
        int index = ((DoneCommand) cmd).getIndex();
        tasks.get(index - 1).setTaskStatus(status);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks.get(index - 1).toString());
    }

    public static void printTask(Tasks task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
    }

    public static void printTaskList(TaskList tasks) {
        int index = 1;
        for (Tasks task : tasks.getAllTaskList()) {
            System.out.println(index + "." + task.toString());
            index++;
        }
    }

    public static void deleteTask(TaskList tasks, Command cmd) {
        int index = ((DeleteCommand) cmd).getIndex();
        System.out.println(" Noted. I've removed this task:  ");
        System.out.println(tasks.get(index - 1).toString());
        tasks.remove(index - 1);
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");

    }

    public static void updateDataFile(TaskList tasks) {
        Storage storage = new Storage("/data/duke.txt");
        try {
            storage.saveToFile(tasks);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!!Update failed. Something went wrong when save data to the data file, please try again.");
        }
    }

    public static void findTask(TaskList tasks,Command cmd){
        int i=0;
        System.out.println("Here are the matching tasks in your list:");
        for (Tasks t : tasks.findTask(cmd.getCommandContent())) {
            System.out.println(i + "." + t.toString());
            i++;
        }
    }

}
