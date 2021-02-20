package duke.ui;

import java.util.ArrayList;

import duke.task.Task;
import duke.task.TaskList;

/**
 * Contains methods that generate the output messages from user's input.
 */
public class Ui {
    private final StringBuilder output = new StringBuilder();

    /**
     * Builds the error message string
     */
    public void printError(String errorMessage) {
        output.append("OOPS!! ");
        output.append(errorMessage);
    }

    /**
     * Builds the added task message string
     */
    public void printAddedTask(TaskList tasks) {
        output.append("Got it! I have added this task:");
        output.append(System.lineSeparator());
        output.append(tasks.getTask(tasks.getSize() - 1).toString());
        output.append(System.lineSeparator());
        output.append("Now you have ");
        output.append(tasks.getSize());
        output.append(" tasks in the list.");
    }

    /**
     * Builds the removed task message string
     */
    public void printRemovedTask(int size, String taskDescription) {
        output.append("Noted! I've removed this task: ");
        output.append(System.lineSeparator());
        output.append(taskDescription);
        output.append(System.lineSeparator());
        output.append("Now you have ");
        output.append(size);
        output.append(" tasks in the list.");
    }

    /**
     * Builds the done task message string
     */
    public void printDoneTask(Task task) {
        output.append("I have marked this task as done:");
        output.append(System.lineSeparator());
        output.append(task.toString());
    }

    /**
     * Builds the list of tasks message string
     */
    public void printTasks(TaskList tasks) {
        if (tasks.getSize() == 0) {
            output.append("Sorry, there is no task in your list.");
        } else {
            output.append("Here are the tasks in your list:");
            output.append(System.lineSeparator());
            for (int i = 0; i < tasks.getSize(); i++) {
                output.append(i + 1);
                output.append(". ");
                output.append(tasks.getTask(i).toString());
                output.append(System.lineSeparator());
            }
        }
    }

    /**
     * Builds the list of filtered tasks message string
     */
    public void printFilteredTasks(TaskList tasks) {
        ArrayList<Integer> searchResultIndexes = tasks.getSearchResultIndexes();
        if (searchResultIndexes.size() == 0) {
            output.append("Sorry, there is no matching task.");
        } else {
            output.append("Here are the matching tasks in your list:");
            output.append(System.lineSeparator());
            for (int i = 0; i < searchResultIndexes.size(); i++) {
                output.append(i + 1);
                output.append(". ");
                output.append(tasks.getTask(searchResultIndexes.get(i)).toString());
                output.append(System.lineSeparator());
            }
        }
    }

    /**
     * Builds the list of sorted tasks message string
     */
    public void printSortedTasks(TaskList tasks) {
        if (tasks.getSize() == 0) {
            output.append("Sorry, there is no task in your list.");
        } else {
            output.append("Tasks sorted! Here are the tasks in your list:");
            output.append(System.lineSeparator());
            for (int i = 0; i < tasks.getSize(); i++) {
                output.append(i + 1);
                output.append(". ");
                output.append(tasks.getTask(i).toString());
                output.append(System.lineSeparator());
            }
        }
    }

    /**
     * Clears the output message string.
     */
    public void clearOutput() {
        output.setLength(0);
    }

    /**
     * Gets the output message string.
     *
     * @return Output message string to be shown to the user.
     */
    public String getOutput() {
        return output.toString();
    }
}
