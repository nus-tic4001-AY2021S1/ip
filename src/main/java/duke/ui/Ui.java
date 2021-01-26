package duke.ui;

import duke.task.Task;
import duke.task.TaskList;

import java.util.ArrayList;

/**
 * Contains methods that interacts with the users such as obtaining commands
 * from user input and displaying messages to the users.
 */
public class Ui {
    private final StringBuilder output = new StringBuilder();

    public void printError(String errorMessage) {
        output.append("OOPS!! ");
        output.append(errorMessage);
    }

    public void printGoodbye() {
        output.append("Bye! Hope to see you again soon.");
    }

    public void printAddedTask(TaskList tasks) {
        output.append("Got it! I have added this task:");
        output.append(System.lineSeparator());
        output.append(tasks.getTask(tasks.getSize() - 1).toString());
        output.append(System.lineSeparator());
        output.append("Now you have ");
        output.append(tasks.getSize());
        output.append(" tasks in the list.");
    }

    public void printRemovedTask(int size, String taskDescription) {
        output.append("Noted! I've removed this task: ");
        output.append(taskDescription);
        output.append("Now you have ");
        output.append(size);
        output.append(" tasks in the list.");
    }

    public void printDoneTask(Task task) {
        output.append("I have marked this task as done:");
        output.append(System.lineSeparator());
        output.append(task.toString());
    }

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

    public void printFilteredTasks(TaskList tasks) {
        ArrayList<Integer> searchResultIndexes = tasks.getSearchResultIndexes();
        if (searchResultIndexes.size() == 0) {
            output.append("Sorry, there is no matching task.");
        } else {
            output.append("Here are the matching tasks in your list:");
            for (int i = 0; i < searchResultIndexes.size(); i++) {
                output.append(i + 1);
                output.append(". ");
                output.append(tasks.getTask(searchResultIndexes.get(i)).toString());
            }
        }
    }

    public void clearOutput() {
        output.setLength(0);
    }

    public String getOutput() {
        return output.toString();
    }
}