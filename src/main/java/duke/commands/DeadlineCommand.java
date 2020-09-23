package duke.commands;

import duke.database.Database;
import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

import java.io.IOException;
/**
 * A command to create a Deadline task that has a deadline.
 */
public class DeadlineCommand extends Command {
    public static final String word = "deadline";

    public DeadlineCommand(String taskDescription, TaskList tasks, Ui ui, Database database) {
        super(taskDescription, tasks, ui, database);
    }

    public String reformatLine(String type, String keyword, String line) {
        line = line.replaceFirst("/" + keyword, "(" + keyword + ":").concat(")");
        return type + line;
    }
    @Override
    public void execute() {
        try {
            if (taskDescription.isEmpty() || !taskDescription.contains("/by")) {
                throw new DukeException("It seems that you've missed out the task description or the /by <when> segment!\n" +
                        "Please type in the 'deadline <something> /by <when>' format.");
            }
            String[] split = taskDescription.split("/by");

            if (split[0].isEmpty() || split[1].isEmpty()) {
                throw new DukeException("It seems that you've missed out the task description or the /by <when> segment!\n" +
                        "Please type in the 'deadline <something> /by <when>' format.");
            }

            taskDescription = reformatLine("[Deadline] ", "by", taskDescription);
            tasks.add(new Deadline(taskDescription));
            ui.printTaskAdded(tasks);
            database.updateDatabase(tasks);

        } catch (DukeException | IOException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It seems that you've missed out the deadline time!\n" +
                    "Please type in something for <when> after 'deadline <something> /by'.");
        }
    }
}