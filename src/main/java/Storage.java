import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Task> tempStorage;
    private boolean isExit;
    Storage(){
        tempStorage = new ArrayList<>(100);
        isExit = false;
    }
    public void addTaskToTemp(String toAdd){
        tempStorage.add(new Task(toAdd));
    }
    public void addToDoToTemp(String toAdd){
        tempStorage.add(new Todo(toAdd));
    }
    public void addDeadlineToTemp(String toAdd){
        String description = toAdd.split(" /by ")[0];
        String by = toAdd.split(" /by ")[1];
        tempStorage.add(new Deadline(description,by));
    }
    public void addEventToTemp(String toAdd){
        String description = toAdd.split(" /at ")[0];
        String at = toAdd.split(" /at ")[1];
        tempStorage.add(new Event(description,at));
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
