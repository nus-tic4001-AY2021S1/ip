package duke.task;

import java.util.Comparator;

public class TaskListSorter implements Comparator<Task> {
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
            if (((Deadline) a).getBy().compareTo(((Deadline) b).getBy()) < 0) {
                return -1;
            } else if (((Deadline) a).getBy().compareTo(((Deadline) b).getBy()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (a instanceof Event && b instanceof Event) {
            if (((Event) a).getAt().compareTo(((Event) b).getAt()) < 0) {
                return -1;
            } else if (((Event) a).getAt().compareTo(((Event) b).getAt()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }
}