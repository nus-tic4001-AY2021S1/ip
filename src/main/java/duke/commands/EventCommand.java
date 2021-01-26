package duke.commands;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import duke.database.Database;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command that is similar to a Deadline task but with a different time keyword '/at' and has a time duration.
 */

public class EventCommand extends DeadlineCommand {
    public static final String word = "event";

    public EventCommand(String taskDescription, TaskList tasks, Ui ui, Database database) {
        super(taskDescription, tasks, ui, database);
    }

    /**
     * Changes the format of the whole line into proper task format.
     */

    public String reformatLine(String type, String keyword, String keyword2, String line) {
        line = line.replaceFirst("/" + keyword, "(" + keyword + ":").concat(")");
        line = line.replace("/" + keyword2, "-");
        return type + line;
    }

    public String reformatTime(String time) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        LocalTime date = LocalTime.parse(time, formatter);
        return date.format(DateTimeFormatter.ofPattern("h:ma"));
    }

    @Override
    public String execute() {
        try {
            if (line.isEmpty() || !line.contains("/at") || !line.contains("/to")) {
                return ui.printRed("It seems that you've missed out the required keyword(s)!\n"
                    + "Please type in the 'event <something> /at <dd/MM/yyyy HHmm> /to <HHmm>' format.");
            }
            String description = line.split("/at ")[0];
            String startDateTime = line.split("/at ")[1].split(" /to ")[0];
            String endTime = line.split("/at ")[1].split(" /to ")[1];

            if (description.isEmpty() || startDateTime.isEmpty() || endTime.isEmpty()) {
                return ui
                    .printRed("It seems that you've missed out the task description or the start and end duration!\n"
                        + "Please type in the 'event <something> /at <dd/MM/yyyy HHmm> /to <HHmm>' format.");
            }
            startDateTime = reformatDateTime(startDateTime);
            endTime = reformatTime(endTime);
            line = description + "/at " + startDateTime + " /to " + endTime;
            line = reformatLine("[Event]    ", "at", "to", line);
            tasks.add(new Event(line));
            database.updateDatabase(tasks);
            return ui.printTaskAdded(tasks);

        } catch (IOException e) {
            return ui.printRed(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            return ui.printRed("It seems that you've missed out the event duration!\n"
                + "Please type in something for <dd/MM/yyyy HHmm> after 'event <something> /at'.");
        } catch (DateTimeParseException e) {
            return ui.printRed("It seems that you didn't enter the time in the right format!\n"
                + "Please type in the 'event <something> /at <dd/MM/yyyy HHmm>' format.");
        }
    }
}