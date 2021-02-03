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

/** .
 * Executes a event command.
 */
public class EventCommand extends Command {
    private String taskDescription;
    private  LocalDateTime formatDateTime;

    /** .
     * Constructs a EventCommand.
     *  @param input The strings contains keywords.
     */
    public EventCommand(String input) {
        super(input);
    }


    /** .
     * Executes a sort command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        String taskDetail;
        int len = input.split(" ").length; // to check who many words
        String[] lineArr = input.split(" ", 2);
        String commandFirstWord = input.split(" ")[0].toLowerCase();

        if (len > 1) {
            taskDetail = lineArr[1].trim();  // filter out the first words
        } else {
            throw new DukeException("OOPS!!! The description of a " + commandFirstWord + " cannot be empty.");
        }

        String toAddTaskDetails = taskDetail;

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
                "Got it. I've added this task:\n%s\nNow you have %s tasks in the list.",
                task, taskList.size()
        );



    }



}
