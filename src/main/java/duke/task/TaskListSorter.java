package duke.task;

import java.util.Comparator;

/**
 * Implements the Comparator interface.
 * It contains the compare method that sorts <code>Task</code> objects
 * based on task's deadline.
 */
public class TaskListSorter implements Comparator<Task> {
    /**
     * Compares two <code>Task</code> objects and order them.
     *
     * @param a First <code>Task</code> object in a comparison.
     * @param b Second <code>Task</code> object in a comparison.
     * @return -1 if a < b, 1 if a > b, 0 if a == b.
     */
    public int compare(Task a, Task b) {
        if ((a instanceof Deadline || a instanceof Event) && (b instanceof Todo)) {
            return -1;
        }
        if ((a instanceof Todo) && (b instanceof Deadline || b instanceof Event)) {
            return 1;
        }
        if ((a instanceof Deadline) && (b instanceof Event)) {
            return -1;
        }
        if ((a instanceof Event) && (b instanceof Deadline)) {
            return 1;
        }
        if (a instanceof Deadline && b instanceof Deadline) {
            return Integer.compare(((Deadline) a).getBy().compareTo(((Deadline) b).getBy()), 0);
        }
        if (a instanceof Event && b instanceof Event) {
            return Integer.compare(((Event) a).getAt().compareTo(((Event) b).getAt()), 0);
        }
        return 0;
    }
}
