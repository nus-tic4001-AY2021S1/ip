package duke.commands;

import duke.TaskList;
import duke.tasks.Task;
import duke.Ui;

import java.util.ArrayList;

public class FindCommand {

    // An array list of task objects
    private ArrayList<Task> taskList;

    /** .
     * creating an Task object
     */
    public FindCommand() {
        taskList = TaskList.getList();
    }


    /** .
     * A method to find a task by searching for a keyword.
     * Show the message to user and notify the user that "Here are the matching tasks in your list"
     *
     * @param line get the task content from txt file, which contains keyword
     */
    public void executeCommand(String line) {
        String taskDescription;
        ArrayList<Task> taskListKeywordFound = new ArrayList<>();

        int matchedCount = 0;
        for (Task task : taskList) {
            taskDescription = task.toString();
            if (taskDescription.toLowerCase().contains(line.toLowerCase())) {
                matchedCount = matchedCount + 1;
                taskListKeywordFound.add(task);
                // once there is a match to a task, add this task to the new task list:taskListKeywordFound
            }
        }
        if (matchedCount == 0) {
            Ui.showMessage("Sorry! Cannot find any matched tasks in your list.");
        } else {
            Ui.showMessage("Here are the matching tasks in your list:");
            for (int i = 0; i < taskListKeywordFound.size(); i++) {
                Ui.showMessage((i + 1) + "." + taskListKeywordFound.get(i).toString());
                // display the matched tasks to user from the task list:taskListKeywordFound
            }
        }


    }





}