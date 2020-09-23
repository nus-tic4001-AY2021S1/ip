package duke.commands;

import duke.database.Database;
import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

import java.io.IOException;
/**
 * A command that is similar to a Deadline task but with a different time keyword '/at'.
 */
public class EventCommand extends DeadlineCommand {
    public static final String word = "event";

    public EventCommand(String taskDescription, TaskList tasks, Ui ui, Database database) {
        super(taskDescription, tasks, ui, database);
    }

    @Override
    public void execute() {
        try {
            if (taskDescription.isEmpty() || !taskDescription.contains("/at")) {
                throw new DukeException("It seems that you've missed out the task description " +
                        "or the /at <when to when> segment!\n" +
                        "Please type in the 'event <something> /at <when to when>' format.");
            }
            String[] split = taskDescription.split("/at");

            if (split[0].isEmpty() || split[1].isEmpty()) {
                throw new DukeException("It seems that you've missed out the task description " +
                        "or the /at <when to when> segment!\n" +
                        "Please type in the 'event <something> /at <when to when>' format.");
            }

            taskDescription = reformatLine("[Event]    ", "at", taskDescription);
            tasks.add(new Deadline(taskDescription));
            ui.printTaskAdded(tasks);
            database.updateDatabase(tasks);

        } catch (DukeException | IOException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It seems that you've missed out the event time!\n" +
                    "Please type in something for <when> after 'deadline <something> /by'.");
        }
    }
}