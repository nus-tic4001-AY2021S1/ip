package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.util.ArrayList;
/**
 * Storage class handles List of task as tempStorage,
 */

public class Storage {
    private ArrayList<Task> tempStorage;
    private boolean isExit;
    Storage(){
        tempStorage = new ArrayList<>(100);
        isExit = false;
    }
    public void addToDoToTemp(String toAdd){
        tempStorage.add(new Todo(toAdd));
    }
    public void addDeadlineToTemp(String toAdd) throws DukeException{
        if(!toAdd.contains(" /by ")){
            throw new DukeException("No /by found in command.");
        }
        String description = toAdd.split(" /by ")[0];
        if(toAdd.split(" /by ").length<2){
            throw new DukeException("No event time found after keyword /by .");
        }
        String by = toAdd.split(" /by ")[1];
        tempStorage.add(new Deadline(description,by));
    }
    public void addEventToTemp(String toAdd) throws DukeException{
        if(!toAdd.contains(" /at ")){
            throw new DukeException("No /at found in command.");
        }
        String description = toAdd.split(" /at ")[0];
        if(toAdd.split(" /at ").length<2){
            throw new DukeException("No event time found after keyword /at .");
        }
        String at = toAdd.split(" /at ")[1];
        tempStorage.add(new Event(description,at));
    }
    public Task deleteTaskAt(int i){
        return tempStorage.remove(i);
    }
    public int getSize(){
        return tempStorage.size();
    }
    public Task getTask(int i){
        return tempStorage.get(i);
    }
    public void toExit(){
        isExit=true;
    }
    public boolean getIsExit(){
        return isExit;
    }
    public void setDoneAt(int i){tempStorage.get(i).setDone();}
}
