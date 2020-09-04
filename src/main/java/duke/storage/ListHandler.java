package duke.storage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.*;

public class ListHandler {

    private Vector ListStorage = new Vector();

    public void addToDo(String body){
        ListStorage.add(new Todo(body));
    }

    public void addDeadline(String body, String by, String time){
        ListStorage.add(new Deadline(body, by, time));
    }

    public void addEvent(String body, String at, String timePeriod){
        ListStorage.add(new Event(body, at, timePeriod));
    }

    public Vector GetList(){
        return ListStorage;
    }

    public Task UpdateListItem(String index){
        try {
            int idx = Integer.parseInt(index.trim());
            Task task = (Task) ListStorage.get(idx - 1);
            task.markAsDone();

            return task;

        } catch (NumberFormatException e) { }
          catch (ArrayIndexOutOfBoundsException e) { }

        return null;
    }

    public Task DeleteListItem(String index){
        try {
            int idx = Integer.parseInt(index.trim());
            Task task = (Task) ListStorage.remove(idx - 1);
            return task;

        } catch (Exception e) {}

        return null;
    }
}
