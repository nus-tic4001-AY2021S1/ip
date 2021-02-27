package duke.tasks;

import duke.DukeException;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tempStorage;

    public TaskList() {
        tempStorage = new ArrayList<>(100);
    }

    public void addTask(Task toAdd) {
        tempStorage.add(toAdd);
    }

    public Task deleteTaskAt(int index) {
        return tempStorage.remove(index);
    }

    public Task getTask(int index) {
        return tempStorage.get(index);
    }

    public int getSize() {
        return tempStorage.size();
    }

    public void setDoneAt(int index) {
        tempStorage.get(index).setDone();
    }

    public void addTodoToTemp(String toAdd) {
        tempStorage.add(new Todo(toAdd));
    }

    public void addDeadlineToTemp(String toAdd) throws DukeException {
        if (!toAdd.contains(" /by ")) {
            throw new DukeException("No /by found in command.");
        }
        String description = toAdd.split(" /by ")[0];
        if (toAdd.split(" /by ").length < 2) {
            throw new DukeException("No event time found after keyword /by .");
        }
        String by = toAdd.split(" /by ")[1];
        tempStorage.add(new Deadline(description,by));
    }

    public void addEventToTemp(String toAdd) throws DukeException {
        if (!toAdd.contains(" /at ")) {
            throw new DukeException("No /at found in command.");
        }
        String description = toAdd.split(" /at ")[0];
        if (toAdd.split(" /at ").length < 2) {
            throw new DukeException("No event time found after keyword /at .");
        }
        String at = toAdd.split(" /at ")[1];
        tempStorage.add(new Event(description,at));
    }
}
