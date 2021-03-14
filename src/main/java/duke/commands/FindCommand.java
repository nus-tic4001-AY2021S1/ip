package duke.commands;

import duke.exceptions.DukeException;
import duke.parser.Parser;
import duke.util.Storage;
import duke.util.TaskList;
import duke.tasks.Task;
import duke.ui.Ui;

import java.util.ArrayList;
import java.util.StringJoiner;

/** .
 * Executes a find command.
 */
public class FindCommand extends Command {

    /** .
     * Constructs a FindCommand.
     *  @param input The strings contains keywords.
     */
    public FindCommand(String input) {
        super(input);
    }

    /** .
     * Executes a find command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        String taskDetail = Parser.findTaskDetail(input);


        String taskDescription;
        ArrayList<Task> taskListKeywordFound = new ArrayList<>();
        StringJoiner response = new StringJoiner("\n");

        int matchedCount = 0;
        for (int i = 0; i < taskList.size(); i++) {
            taskDescription = taskList.get(i).toString();
            if (taskDescription.toLowerCase().contains(taskDetail.toLowerCase())) {
                matchedCount = matchedCount + 1;
                taskListKeywordFound.add(taskList.get(i));
                // once there is a match to a task, add this task to the new task list:taskListKeywordFound
            }

        }


        if (matchedCount == 0) {
            Ui.showMessage("Sorry! Cannot find any matched tasks in your list.");
            return "Sorry! Cannot find any matched tasks in your list.";
        } else {
            Ui.showMessage("Here are the matching tasks in your list:");
            for (int i = 0; i < taskListKeywordFound.size(); i++) {
                Ui.showMessage((i + 1) + "." + taskListKeywordFound.get(i).toString());
                // display the matched tasks to user from the task list:taskListKeywordFound
                response.add(String.format("%d.%s", i + 1, taskListKeywordFound.get(i).toString()));
            }
            return String.format(
                    "Here are the matching tasks in your list:\n%s",response.toString());
        }

    }

}






