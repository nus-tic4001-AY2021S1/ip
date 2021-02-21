package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.exceptions.DukeException;
import duke.tasks.Deadline;
import duke.ui.Ui;
import duke.tasks.Task;

import java.time.LocalDate;
import java.util.Locale;

import static duke.util.TaskList.isValidDateTimeFormat;

/** .
 * Executes a DeadLine command.
 */
public class DeadLineCommand extends Command {
    private String taskDescription;
    private LocalDate dueDate;

    /** .
     * Constructs a DeadLineCommand.
     *  @param input The strings contains keywords.
     */
    public DeadLineCommand(String input) {
        super(input);
    }


    /** .
     * Executes a DeadLine command and returns a response.
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
        if (!toAddTaskDetails.toLowerCase().contains("/by")) {
            throw new DukeException("Cannot find '/by' in command.Please enter valid task details.");
        }

        if (toAddTaskDetails.split("(?i)/by").length < 2) {
            throw new DukeException("No deadline time found after keyword /by.Please enter valid task details.");
        }

        taskDescription = (toAddTaskDetails.split("(?i)/by")[0]).trim();// splits case insensitive
        String taskDeadline = (toAddTaskDetails.split("(?i)/by")[1]).trim();// splits case insensitive

        boolean dateTimeFormatChecker = isValidDateTimeFormat("yyyy-MM-dd", taskDeadline, Locale.ENGLISH);
        // to check if the user enter the correct date format
        if (!dateTimeFormatChecker) {
            throw new DukeException("Please enter correct deadline Due Date yyyy-MM-dd, example: 2019-12-31");
        }

        dueDate = LocalDate.parse(taskDeadline);



        Task task = new Deadline(taskDescription, dueDate);
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
