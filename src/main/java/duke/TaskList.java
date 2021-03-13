package duke;

import java.util.ArrayList;
import java.util.Iterator;

import duke.tasks.Task;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public Task get(int i) {
        return taskList.get(i);
    }

    public void remove(int i) {
        taskList.remove(i);
    }

    public void add(Task t) {
        taskList.add(t);
    }

    public Iterator iterator() {
        return taskList.iterator();
    }

    public ArrayList<Task> getWholeList() {
        return this.taskList;
    }

    public int size() {
        return taskList.size();
    }

    /**
     * @param keyword the key input word
     * @return
     */
    public ArrayList<Task> findKeywordList(String keyword) {
        ArrayList<Task> keywordTaskList = new ArrayList<>();
        for (Task t:this.taskList) {
            if (t.getTaskDescription().contains(keyword)) {
                keywordTaskList.add(t);
            }
        }
        return keywordTaskList;
    }

}
