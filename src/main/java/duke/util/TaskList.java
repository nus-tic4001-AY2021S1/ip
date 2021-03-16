package duke.util;

import duke.tasks.Task;

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

    /**
     * Removes a task from the list of tasks.
     *
     * @param index The index of task to remove.
     */
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
     * Clears all tasks from the list of tasks.
     *
     */
    public void clear() {
        taskList.clear();
    }




}










