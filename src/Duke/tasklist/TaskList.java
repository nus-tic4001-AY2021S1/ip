package Duke.tasklist;

import Duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private static List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
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
        System.out.println(tasks.size());
    }

    public void printTasks() {
        System.out.println("Tasks:");
        int i = 1;
        for (Task t : this.tasks) {
            System.out.println("[" + (i) + "] " + t);
            i++;
        }
    }

    public static String getTaskCount() {
        return "Tasks in the list: " + tasks.size();
    }

    public static int getNumberOfTasks() {
        return tasks.isEmpty() ? 0 : tasks.size();
    }

    public void markAsDone(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
        tasks.get(index - 1).setDone(true);

    }

    public void markAsNotDone(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("undone".length()).trim());
        tasks.get(index - 1).setDone(false);

    }

//    public void removeTask(String fullCommand) {
//        int index = Integer.parseInt(fullCommand.substring("remove".length()).trim());
//        tasks.remove(index - 1);
//    }
}
