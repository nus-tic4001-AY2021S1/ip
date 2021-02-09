package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * This TaskList class to add Task,deadline, event in duke task list,
 * and edit, delete the duke Task.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class TaskList {
    //  Use Java Collections classes ArrayList<Task>
    private List<Task> tasks = new ArrayList<>();
    //private final StringBuilder output = new StringBuilder();


    /**
     * This constructs a TaskList with a ListTask parameter.
     *
     * @param tasks tasks
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {

    }

    /**
     * This function is to add todo.
     *
     * @param fullCommand tasks' full command
     * @throws TaskException if create todo have error can throw this exception.
     */
    public String addTodo(String fullCommand) throws TaskException {
        StringBuilder output = new StringBuilder();
        Todo t = Parser.createTodo(fullCommand);
        tasks.add(t);
        output.append("\nGot it. I've added this task: \n");
        output.append("  ").append(tasks.get(tasks.size() - 1).toString());
        output.append("\nNow you have ").append(tasks.size()).append(" tasks in the list.\n");
        return String.valueOf(output);
    }

    /**
     * This function is to add deadline.
     *
     * @param fullCommand tasks' full command.
     * @throws TaskException if create deadline have error can throw this exception.
     */
    public String addDeadline(String fullCommand) throws TaskException {
        StringBuilder output = new StringBuilder();
        Deadline t = Parser.createDeadline(fullCommand);
        tasks.add(t);
        output.append("\nGot it. I've added this task: \n");
        output.append("  ").append(tasks.get(tasks.size() - 1).toString());
        output.append("\nNow you have ").append(tasks.size()).append(" tasks in the list.\n");
        return String.valueOf(output);
    }

    /**
     *This function is to add event.
     *
     * @param fullCommand tasks' full command
     */
    public String addEvent(String fullCommand) throws TaskException {
        StringBuilder output = new StringBuilder();
        Event t = Parser.createEvent(fullCommand);
        tasks.add(t);
        output.append("\nGot it. I've added this task: \n");
        output.append("  ").append(tasks.get(tasks.size() - 1).toString());
        output.append("\nNow you have ").append(tasks.size()).append(" tasks in the list.\n");
        return String.valueOf(output);
    }

    /**
     *This function is to print tasks.
     *
     * @param fullCommand tasks' full command
     */
    public String showTasks(String fullCommand) {
        StringBuilder output = new StringBuilder();
        output.append("\nHere are the tasks in your list:\n");
        String description = fullCommand.trim().substring("list".length()).trim();
        if (description.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                output.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
            }
            return String.valueOf(output);
        } else {
            try {
                int index = Integer.parseInt(description);
                if (index <= tasks.size() && index > 0) {
                    return "[" + (index) + "] " + tasks.get(index - 1);
                } else {
                    return "\nOOPS!!!Printing range should be 1 to " + tasks.size();
                }
            } catch (NumberFormatException e) {
                return "\nOOPS!!!Print command should be ‘print' or 'print INTEGER'\n";
            }
        }
    }

    /**
     *This function is to mark tasks as done.
     *
     * @param fullCommand tasks' full command
     */
    public String markAsDone(String fullCommand) {
        try {
            int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
            assert index <= tasks.size() : "\nOOPS!!!Command number is invalid\n";
            //assert error when index bigger than tasks size.
            if (index <= tasks.size() && index > 0) {
                tasks.get(index - 1).setDone(true);
                return "\nTasks: " + index + " has marked as DONE.";
            } else {
                return "\nOOPS!!!Marking as done range should be 1 to " + tasks.size();
            }
        } catch (NumberFormatException e) {
            return "\nOOPS!!!markAsDone command not Integer!\n";
        }
    }

    /**
     *This function is to deleted tasks from task list.
     *
     * @param fullCommand tasks' full command
     */
    public String deleteTasks(String fullCommand) {
        try {
            int index = Integer.parseInt(fullCommand.substring("delete".length()).trim());
            StringBuilder output = new StringBuilder();
            if (index <= tasks.size() && index > 0) {
                output.append("\nNoted. I've removed this task: \n" + "  ").append(tasks.get(index - 1));
                output.append(tasks.remove(index - 1));
                output.append("\nNow you have ").append(tasks.size()).append(" tasks in the list.\n");
                return String.valueOf(output);
            } else {
                return "\nOOPS!!!:Deleting range should be 1 to " + tasks.size();
            }
        } catch (NumberFormatException e) {
            return "\nOOPS!!!:Deleted command not Integer!\n";
        }
    }

    /**
     *This function is to call saveTasks method to save tasks in user driver.
     * @return null
     */
    public String saveTasks() {
        return Storage.writeTaskToFile(tasks);
    }

    /**
     * This function is to find tasks from task list.
     *
     * @param fullCommand tasks' full command
     */
    public String findTasks(String fullCommand) {
        List<String> ss = new ArrayList<>();
        StringBuilder findList = new StringBuilder();
        String description = fullCommand.trim().substring("find".length()).trim();
        for (int i = 0; i < tasks.size(); i++) {
            String s = tasks.get(i).toString();
            if (s.contains(description)) {
                ss.add(i + 1 + "." + s + '\n');
            }
        }
        if (ss.size() != 0) {
            findList.append("\nHere are the matching tasks in your list: \n");
            ss.forEach(findList::append);
            return String.valueOf(findList);
        } else {
            return "\nOOPS!!! Our list not contain " + "'" + description + "'.\n";
        }
    }

}