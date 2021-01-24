package duke;

import duke.command.*;

/**
 * This class implements simple Duke chat bot named Jojo,that can write, read and save
 * tasks in the assigned filePath.
 * This Duke class contained 3 methods Duke ,run and main.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */

public class Duke {

    public TaskList tasks;
    public Ui ui;
    public Storage storage;

    /**
     * This constructs is TaskManager with a filePath,
     * This TaskManager try call save.readTaskFromFile to load tasks from filePath
     * and throw an exception if the file does not exist yet!
     *
     * @param filePath duke command save file path
     */
    public Duke(String filePath)  {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.readTaskFromFile());
        } catch (TaskException e) {
            ui.showToUser("OOPS!!!folder does not exist yet!");
            tasks = new TaskList();
        }
    }


    public static void main(String[] args) {
        new Duke("Jojo.txt").run();
    }

    /**
     * This run method switch different duke command to different method.
     */
    public void run() {
        ui.printLogo();
        ui.greetUser();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                String commandWord = Parser.getCommand(fullCommand);//convert command word to lowercase
                switch (commandWord) {
                    case "bye":
                        ui.farewellUser();
                    case "":
                        isExit = true;
                        break;
                    case "todo":
                        tasks.addTodo(fullCommand);
                        break;
                    case "deadline":
                        tasks.addDeadline(fullCommand);
                        break;
                    case "done":
                        tasks.markAsDone(fullCommand);
                        break;
                    case "list":
                        tasks.showTasks(fullCommand);
                        break;
                    case "event":
                        tasks.addEvent(fullCommand);
                        break;
                    case "delete":
                        tasks.deleteTasks(fullCommand);
                        break;
                    case "find":
                        tasks.findTasks(fullCommand);
                        break;
                    case "save":
                        tasks.saveTasks();
                        break;
                    default:
                        ui.printError();
                }
            } catch (TaskException e) {
                ui.printError(e.getMessage());
            }
        }
    }
}