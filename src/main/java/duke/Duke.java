package duke;

import duke.command.Parser;
import duke.command.Storage;
import duke.command.TaskException;
import duke.command.TaskList;
import duke.command.Ui;

/**
 * This class implements simple Duke chat bot named Jojo,that can write, read and save
 * tasks in the assigned filePath.
 * This Duke class contained 3 methods Duke ,run and main.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */

@SuppressWarnings("checkstyle:RightCurly")
public class Duke {

    public TaskList tasks;
    public Ui ui;
    public Storage storage;

    /**
     * This constructs is TaskManager with a filePath,
     * This TaskManager try call save.readTaskFromFile to load tasks from filePath
     * and throw an exception if the file does not exist yet!
     *
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage("data.txt");
        try {
            tasks = new TaskList(storage.readTaskFromFile());
        } catch (TaskException e) {
            ui.showToUser("OOPS!!!folder does not exist yet!");
            tasks = new TaskList();
        }
    }

    /**
     * This run method switch different duke command to different method.
     */
    @SuppressWarnings("checkstyle:Indentation")
    public String getResponse(String input) {
        try {
            String commandWord = Parser.getCommand(input);//convert command word to lowercase
            switch (commandWord) {
                case "bye":
                    System.exit(0); // End program
                    break;
                case "todo":
                    return tasks.addTodo(input);
                case "deadline":
                    return tasks.addDeadline(input);
                case "done":
                    return tasks.markAsDone(input);
                case "list":
                    return tasks.showTasks(input);
                case "event":
                    return tasks.addEvent(input);
                case "delete":
                    return tasks.deleteTasks(input);
                case "find":
                    return tasks.findTasks(input);
                case "save":
                    return tasks.saveTasks();
                case "help":
                    return ui.showHelp();
                default:
                    ui.printError();
                    break;
            }
        } catch (TaskException e) {
            return String.valueOf(e);
        }
        return "Oops, I didn't understand your command: " + input + "\nPlease try use 'help' command.";
    }

}