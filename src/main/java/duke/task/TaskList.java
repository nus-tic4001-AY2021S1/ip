package duke.task;

import duke.exception.DukeException;
import duke.ui.Ui;

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

    void remove(int index) { tasks.remove(index - 1); }

    public Task get(int index) {
        return tasks.get(index);
    }

    public boolean isEmpty(String line) {
        return line.isEmpty();
    }

    public String removeCommandWord(String word, String line) {
        return line.substring(word.length()).trim();
    }

    public String reformatLine(String type, String keyword, String line) {
        line = line.replaceFirst("/" + keyword, "(" + keyword + ":").concat(")");
        return type + line;
    }

    public void setAsCompleted(String line, Ui ui, TaskList tasks) {
        line = removeCommandWord("done", line);
        try {
            if (tasks.size() == 0) {
                ui.printRedBorderlines("It appears that you have no tasks yet, so you can't complete any!\n" +
                        "Perhaps you should start creating one?");
                return;
            }
            if (isEmpty(line)) {
                throw new DukeException("You almost typed a proper done command, but you missed out the number!\n" +
                        "Please type in the 'done <task index number>' format.");
            }
            int index = Integer.parseInt(line);
            tasks.get(index - 1).setDone(true);
            ui.printTaskCompleted(index, tasks);

        } catch (DukeException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (NumberFormatException e) {
            ui.printRedBorderlines("I'm sorry, but the list goes numerically.\nPerhaps you could type a number for the index?");
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It appears that you only have " + tasks.size() + " task(s) in your list,\n" +
                    "perhaps you might want to try typing an index number from 1 to " + tasks.size() + " instead?");
        }
    }

    public void createTodo(String line, Ui ui, TaskList tasks) {
        line = removeCommandWord("done", line);
        try {
            if (isEmpty(line)) {
                throw new DukeException("It seems that you missed out the task description!\n" +
                        "Please type in the 'todo <something>' format.");
            }

            line = "[Todo]     " + line;
            tasks.add(new Todo(line));
            ui.printTaskAdded(tasks);

        } catch (DukeException e) {
            ui.printRedBorderlines(e.getMessage());
        }
    }

    public void createDeadline(String line, Ui ui, TaskList tasks) {
        line = removeCommandWord("deadline", line);
        try {
            if (isEmpty(line) || !line.contains("/by")) {
                throw new DukeException("It seems that you've missed out the task description or the /by <when> segment!\n" +
                        "Please type in the 'deadline <something> /by <when>' format.");
            }
            String[] split = line.split("/by");

            if (isEmpty(split[0]) || isEmpty(split[1])) {
                throw new DukeException("It seems that you've missed out the task description or the /by <when> segment!\n" +
                        "Please type in the 'deadline <something> /by <when>' format.");
            }

            reformatLine("[Deadline] ", "by", line);
            tasks.add(new Deadline(line));
            ui.printTaskAdded(tasks);

        } catch (DukeException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It seems that you've missed out the deadline time!\n" +
                    "Please type in something for <when> after 'deadline <something> /by'.");
        }
    }

    public void createEvent(String line, Ui ui, TaskList tasks) {
        line = removeCommandWord("event", line);
        try {
            if (isEmpty(line) || !line.contains("/at")) {
                throw new DukeException("It seems that you've missed out the task description " +
                        "or the /at <when to when> segment!\n" +
                        "Please type in the 'event <something> /at <when to when>' format.");
            }
            String[] split = line.split("/at");

            if (isEmpty(split[0]) || isEmpty(split[1])) {
                throw new DukeException("It seems that you've missed out the task description " +
                        "or the /at <when to when> segment!\n" +
                        "Please type in the 'event <something> /at <when to when>' format.");
            }

            line = reformatLine("[Event]    ", "at", line);
            tasks.add(new Deadline(line));
            ui.printTaskAdded(tasks);

        } catch (DukeException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It seems that you've missed out the event time!\n" +
                    "Please type in something for <when> after 'deadline <something> /by'.");
        }
    }
    public void deleteTask(String line, Ui ui, TaskList tasks) {
        line = removeCommandWord("delete", line);
        try {
            if (tasks.size() == 0) {
                ui.printRedBorderlines("It appears that you have no tasks yet, so you can't delete any!\n" +
                        "Perhaps you should start creating one?");
                return;
            }
            if (isEmpty(line)) {
                throw new DukeException("You almost typed a proper delete command, but you missed out the number!\n" +
                        "Please type in the 'delete <task index number>' format.");
            }
            int index = Integer.parseInt(line);
            ui.printTaskRemoved(tasks);
            tasks.remove(index);

        } catch (DukeException e) {
            ui.printRedBorderlines(e.getMessage());
        } catch (NumberFormatException e) {
            ui.printRedBorderlines("I'm sorry, but the list goes numerically.\nPerhaps you could type a number for the index?");
        } catch (IndexOutOfBoundsException e) {
            ui.printRedBorderlines("It appears that you only have " + tasks.size() + " task(s) in your list,\n" +
                    "perhaps you might want to try typing an index number from 1 to " + tasks.size() + " instead?");
        }
    }
}