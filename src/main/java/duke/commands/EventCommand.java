package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.exceptions.DukeException;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static duke.util.TaskList.isValidDateTimeFormat;

public class EventCommand extends Command {
    private String taskDescription;
    private  LocalDateTime formatDateTime;


    public EventCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        String toAddTaskDetails = input;

        if (!toAddTaskDetails.toLowerCase().contains(" /at")) {
            throw new DukeException("Cannot find '/at' in command.Please enter valid task details.");
        }

        if (toAddTaskDetails.split("(?i)/at ").length < 2) {
            throw new DukeException("No event time found after keyword /at.Please enter valid task details.");
        }

        taskDescription = (toAddTaskDetails.split("(?i)/at")[0]).trim();
        // splits case insensitive
        String taskEventDate = (toAddTaskDetails.split("(?i)/at")[1]).trim();
        // splits case insensitive

        boolean dateTimeFormatChecker = isValidDateTimeFormat("yyyy-MM-dd HH:mm", taskEventDate, Locale.ENGLISH);
        // to check if the user enter the correct date format
        if (!dateTimeFormatChecker) {
            throw new DukeException("Please enter correct event Date yyyy-MM-dd HH:mm, example: 2019-12-31 11:10");
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        formatDateTime = LocalDateTime.parse(taskEventDate, formatter);



        Task task = new Event(taskDescription, formatDateTime);
        int previousTaskSize = taskList.size();
        taskList.add(task);
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize + 1 == subsequentTaskSize);

        return String.format(
                "I've added this task:\n%s\nNow you have %s tasks in the list.",
                task, taskList.size()
        );
    }

    @Override
    public String toString() {
        return "event <taskDescription> /at <formatDateTime>";
    }

}
