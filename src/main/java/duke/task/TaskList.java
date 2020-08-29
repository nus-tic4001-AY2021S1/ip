package duke.task;

import duke.exception.DukeException;
import duke.ui.UI;

import java.util.ArrayList;

/**
 * Responsible for managing all the tasks in the list. This class will use an ArrayList inside it.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public int size() {
        return tasks.size();
    }

    void add(Task task) {
        tasks.add(task);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void changeDone(String line, UI ui, TaskList tasks) {
        line = line.substring("done".length()).trim();
        try {
            if (!line.isEmpty()) {
                markAsDone(line, ui, tasks);
            } else {
                throw new DukeException(ui.colorRed("Please type in the" +
                        " 'done <task index number>' format."));
            }
        } catch (DukeException e) {
            ui.printError(e.getMessage());
        }
    }

    private void markAsDone(String line, UI ui, TaskList tasks) {
        try {
            if (tasks.size() != 0) {
                int index = Integer.parseInt(line);
                tasks.get(index - 1).setDone(true);
                ui.markedAsDone(index, tasks);
            } else ui.printError("There are no tasks to mark as done.");
        } catch (NumberFormatException e) {
            ui.printError("Please type a number for the index.");
        } catch (IndexOutOfBoundsException e) {
            ui.printError("Please type an index number from 1 to "
                    + tasks.size() + ".");
        }
    }

    public void createTodo(String line, UI ui, TaskList tasks) {
        try {
            if (line.substring("todo".length()).trim().isEmpty()) {
                throw new DukeException
                        (ui.colorRed("Please type in the 'todo <something>' format."));
            } else if (line.contains("todo")) {
                line = line.replaceFirst("todo", "[Todo]    ");
                tasks.add(new Todo(line));
                ui.taskAdded(line, tasks);
            }
        } catch (DukeException e) {
            ui.printError(e.getMessage());
        }
    }

    public void createDeadline(String line, UI ui, TaskList tasks) {
        try {
            if (line.substring("deadline".length()).trim().isEmpty() || !line.contains("/by")) {
                throw new DukeException
                        (ui.colorRed("Please type in the 'deadline <something> /by <when>' format."));
            } else if (line.contains("deadline")) {
                String[] split = line.split("/by");
                if (split[0].isEmpty() || split[1].isEmpty()) {
                    throw new DukeException
                            (ui.colorRed("Please type in the 'deadline " +
                                    "<something> /by <when>' format."));
                } else if (line.contains("deadline")) {
                    line = line.replaceFirst("deadline", "[Deadline]")
                            .replaceFirst("/by", "(by:")
                            .concat(")");
                    tasks.add(new Deadline(line));
                    ui.taskAdded(line, tasks);
                }
            }
        } catch (DukeException e) {
            ui.printError(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.printError("Please type in something for <when>" +
                    " after 'deadline <something> /by'.");
        }
    }

    public void createEvent(String line, UI ui, TaskList tasks) {
        try {
            if (line.substring("event".length()).trim().isEmpty() || !line.contains("/at")) {
                throw new DukeException
                        (ui.colorRed("Please type in the 'event <something> /at <when>' format."));
            } else if (line.contains("event")) {
                String[] split = line.split("/at");
                if (split[0].isEmpty() || split[1].isEmpty()) {
                    throw new DukeException
                            (ui.colorRed("Please type in the 'event " +
                                    "<something> /at <when>' format."));
                } else if (line.contains("event")) {
                    line = line.replaceFirst("event", "[Event]   ")
                            .replaceFirst("/at", "(at:")
                            .concat(")");
                    tasks.add(new Event(line));
                    ui.taskAdded(line, tasks);
                }
            }
        } catch (DukeException e) {
            ui.printError(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.printError("Please type in something for <when>" +
                    " after 'deadline <something> /by'.");
        }
    }
}