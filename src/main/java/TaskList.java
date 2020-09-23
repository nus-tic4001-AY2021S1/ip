import java.util.ArrayList;

//contains the task list e.g., it has operations to add/delete tasks in the list
class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(){
        this.tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks(){
        return this.tasks;
    }
    public Task getTask(int i){
        return this.tasks.get(i);
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public Task deleteTask(int i){
        return this.tasks.remove(i);
    }
    public int getSize(){
        return this.tasks.size();
    }
}
