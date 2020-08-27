import java.util.ArrayList;

import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

public class TodoList {
    // An array list of task objects
    private ArrayList<Task> taskList;

    /**
     * creating an TodoList object
     */
    public TodoList() {
        taskList = new ArrayList<>();
    }


    /**
     * A method to list done all the tasks from the list and show the list to user.
     * Show the message to user and notify the user that "Here are the tasks in your list"
     */
    public void listAllTasks() {
        Ui.showMessage("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Ui.showMessage((i + 1) + "." + taskList.get(i).toString());
        }
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Todo"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addToDoType(String toAddTaskDetails) {
        taskList.add(new Todo(toAddTaskDetails));
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Deadline"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addDeadlineType(String toAddTaskDetails) {
        String taskDescription = (toAddTaskDetails.split("(?i)/by")[0]).trim();// splits case insensitive
        String taskDeadline = (toAddTaskDetails.split("(?i)/by")[1]).trim();// splits case insensitive
        taskList.add(new Deadline(taskDescription, taskDeadline));
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Event"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addEventType(String toAddTaskDetails) {
        String taskDescription = (toAddTaskDetails.split("(?i)/at")[0]).trim();// splits case insensitive
        String taskEventDate = (toAddTaskDetails.split("(?i)/at")[1]).trim();// splits case insensitive
        taskList.add(new Event(taskDescription, taskEventDate));
    }

    /**
     * A method to read the value from user.
     * Show the message to user and notify the user that a current task is added in the list
     *
     * @param input A String that holds the user input from the terminal
     */
    public void readTaskFromUser(String input) {
        Ui.showMessage("Got it. I've added this task:");
        int currentNewAddedTaskIndex = (taskList.size() - 1);
        Ui.showMessage("  " + taskList.get(currentNewAddedTaskIndex).toString());
        Ui.showMessage("Now you have " + taskList.size() + " tasks in the list.");
    }


    /**
     * A method to mark the selected task as completed
     * update value of the task field:isDone = true
     *
     * @param selectedTask A String that holds the ID (number) of a task
     * @throws NullPointerException           If TASK NUM is Empty/Null: Returning to Main Menu
     * @throws ArrayIndexOutOfBoundsException If TASK NUM is invalid, TASK NUM cannot be found in the task list: Returning to Main Menu
     */
    public void markSelectedTaskDone(String selectedTask) {

        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM cannot be found in the task list: Returning to Main Menu");
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (i == taskIndex) {

                    Ui.showMessage("Nice! I've marked this task as done: ");
                    taskList.get(i).setDone();

                    Ui.showMessage("[" + taskList.get(i).getStatusIcon() + "] " + taskList.get(i).getDescription());
                }

            }


        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }
    }
}
