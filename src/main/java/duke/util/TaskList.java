package duke.util;

import duke.exceptions.DukeException;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;
import duke.ui.Ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * TaskList: contains the task list e.g., it has operations to add/delete tasks in the list
 * TodoList
 */
public class TaskList {

    // An array list of task objects
    private static ArrayList<Task> taskList;

    /** .
     * creating an TodoList object
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /** .
     * creating a taskList
     */
    public static ArrayList<Task> getList() {
        return taskList;
    }


    /**
     * Sorts tasks in the task lists.
     *
     */
    public void sort() {
        Collections.sort(taskList);
    }

    /**
     * To check the datetime if it is valid.
     *
     * @param format A String that holds the format of date/time.
     * @param value A String that holds the details of task
     * @param locale A Locale that holds the locale
     */
    public static boolean isValidDateTimeFormat(String format, String value, Locale locale) {
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                    // Debugging purposes
                    //e2.printStackTrace();
                }
            }
        }

        return false;
    }

    /**
     * Adds a task to the list of tasks.
     *
     * @param task The task to add.
     */
    public void add(Task task) {
        taskList.add(task);
    }



    /**
     * Returns the size of the list of tasks.
     *
     * @return The size of the list of tasks.
     */
    public int size() {
        return taskList.size();
    }

    public Task remove(int index) {
        return taskList.remove(index);
    }




    /**
     * Returns a task from the list of tasks without removing it.
     *
     * @param index The index of the task to return.
     * @return The task corresponding to the given index.
     */
    public Task get(int index) {
        return taskList.get(index);
    }


    /**
     * A method to clear all entries.
     * Show the message to user and notify the user that "All entries have been cleared."
     */
    public static void clearAllTasks() {

        // list initially
        Ui.showMessage("The Task list initially:\n" + taskList);

        // clear function used
        taskList.clear();

        // list after clearing all elements
        Ui.showMessage("The Task list after using clear() method:" + taskList);

    }


    /** .
     * A method to view the selected task details
     *
     * @param selectedTask A String that holds the ID (number) of a task
     * @throws NullPointerException If TASK NUM is Empty/Null: Returning to Main Menu
     * @throws ArrayIndexOutOfBoundsException If TASK NUM is invalid,
     *          TASK NUM cannot be found in the task list: Returning to Main Menu
     */
    public void viewSelectedTask(String selectedTask) {

        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException(
                        "TASK NUM cannot be found in the task list: Returning to Main Menu");
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (i == taskIndex) {
                    Ui.showMessage("Nice! Here is the task ready to view:");
                    Ui.showMessage(taskList.get(i).toString());
                }

            }


        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }
    }


    public void clear() {
        // clear function used
        taskList.clear();
    }




}










