package duke.commands;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import duke.database.Database;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to create a Deadline task that has a deadline.
 */

public class DeadlineCommand extends Command {
    public static final String word = "deadline";

    public DeadlineCommand(String line, TaskList tasks, Ui ui, Database database) {
        super(line, tasks, ui, database);
    }

    /**
     * Changes the format of the whole line into proper task format.
     */

    public String reformatLine(String type, String keyword, String line) {
        line = line.replaceFirst("/" + keyword, "(" + keyword + ":").concat(")");
        return type + line;
    }

    public String reformatDateTime(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime date = LocalDateTime.parse(dateTime, formatter);
        return date.format(DateTimeFormatter.ofPattern("d MMM yyyy h:mma"));
    }

    @Override
    public String execute() {
        try {
            if (line.isEmpty() || !line.contains("/by")) {
                return "You've missed out the task description or the /by <when> segment!\r"
                    + "Type in the 'deadline <something> /by <dd/MM/yyyy HHmm>' format, you dolt!";
            }
            String description = line.split("/by ")[0];
            String dateTime = line.split("/by ")[1];

            if (description.isEmpty() || dateTime.isEmpty()) {
                return "You've missed out the task description or the /by <when> segment!\r"
                    + "Type in the 'deadline <something> /by <dd/MM/yyyy HHmm>' format, you dolt!";
            }
            line = description + "/by " + reformatDateTime(dateTime);
            line = reformatLine("[Deadline] ", "by", line);
            tasks.add(new Deadline(line));
            database.updateDatabase(tasks);
            return ui.printTaskAdded(tasks);

        } catch (IOException e) {
            return e.getMessage();
        } catch (IndexOutOfBoundsException e) {
            return "You've missed out the deadline time!\r"
                + "Please type in something for <dd/MM/yyyy HHmm> after 'deadline <something> /by'.";
        } catch (DateTimeParseException e) {
            return "You didn't enter the time in the right format!\r"
                + "Type in the 'deadline <something> /by <dd/MM/yyyy HHmm>' format, you dolt!";
        }
    }
}