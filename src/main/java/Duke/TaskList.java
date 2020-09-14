package Duke;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList(ArrayList<Task> tasks){
        this.tasks=tasks;
    }
    public TaskList(){}

    public ArrayList<Task> getTasks(){
        return tasks;
    }
    public int getSize(){
        return tasks.size();
    }
    public void storeInArray(Task t) {
        tasks.add(t);
    }
    public void deleteFromList(int index) {
        tasks.remove(index);
    }
}
