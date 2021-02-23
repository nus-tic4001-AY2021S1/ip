package data;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private static List<Task> tasks = new ArrayList<>();

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getDescription() {
        String tasksDescription = "";
        for (int i = 0; i < tasks.size(); i++) {
            tasksDescription += tasks.get(i).getDescription().trim();
            if (i == tasks.size() - 1) {

            } else {
                tasksDescription += "|";
            }
        }
        return tasksDescription;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Prints the list of tasks.
     */
    public void printTasks() {
        System.out.println("Tasks:");
        int i = 1;
        for (Task t : this.tasks) {
            System.out.println(i + "." + t);
            i++;
        }
    }

    /**
     * Returns the current number of tasks in the list
     *
     * @return 0 if list is empty or the number of tasks
     */
    public static int getNumberOfTasks() {
        return tasks.isEmpty() ? 0 : tasks.size();
    }

    public void markAsDone(int idx) {
        tasks.get(idx - 1).setDone(true);
    }

    public void markAsNotDone(int idx) {
        tasks.get(idx - 1).setDone(false);
    }

    /**
     * Remove a task at the index specified in the list
     *
     * @param fullCommand
     */
    public void removeTask(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("remove".length()).trim());
        tasks.remove(index - 1);
    }

    /**
     *
     * @param keyword
     * @return
     */
    public List<Task> findTasks(String keyword) {
        List<Task> foundTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (task.getDescription().contains(keyword.trim())) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    public void setTaskTag(String tag, int idx) {
        tasks.get(idx - 1).setTag(tag);
    }

    public void removeTaskTag(int idx) {
        tasks.get(idx - 1).unTag();
    }
}
