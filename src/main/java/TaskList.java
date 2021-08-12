import java.util.ArrayList;
import java.util.Iterator;

import task.Tasks;

public class TaskList {
    private ArrayList<Tasks> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public Tasks get(int i) {
        return taskList.get(i);
    }

    public void remove(int i) {
        taskList.remove(i);
    }

    public void add(Tasks t) {
        taskList.add(t);
    }

    public Iterator iterator() {
        return taskList.iterator();
    }

    public ArrayList<Tasks> getTaskList() {
        return this.taskList;
    }

    public int size() {
        return taskList.size();
    }


    /**
     * @param keyWord search task key word
     * @return a list of matched task
     */
    public ArrayList<Tasks> findTask(String keyWord) {
        ArrayList<Tasks> matchedTaskList = new ArrayList<>();
        for (Tasks t:this.taskList) {
            if (t.getTaskDescription().contains(keyWord)) {
                matchedTaskList.add(t);
            }
        }
        return matchedTaskList;
    }
}

