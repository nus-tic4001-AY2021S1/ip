package Dukes;

import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<Task>(100);
    public ArrayList<Task> list = new ArrayList<Task>();

    /*public TaskList(ArrayList<String> content) throws DukeException {
        for (String s : content) {
            loadTask(s);
        }
    }*/
    public TaskList(ArrayList<String> load){

    }

    public TaskList() {

    }
   /* public void loadTask(String s) throws DukeException {
        String[] strArr = s.split(" \\| ");
        String action = strArr[0];
        Task t;
        switch (action) {
            case "T":
                t = new ToDo(strArr[2]);
                break;
            case "D":
                t = new Deadline(strArr[2], strArr[3]);
                break;
            case "E":
                t = new Event(strArr[2], strArr[3]);
                break;
            default:
                throw new DukeException("Previous Task storage is corrupted. Resetting your task . .");
        }
        if (strArr[1].equals("1")) {
            t.markAsDone();
        }
        list.add(t);
    }*/

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getSize() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return false;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }
}

   /* public void loadTask(String s) throws DukeException {
        String[] strArr = s.split(" \\| ");
        String action = strArr[0];
        Task t;
        switch (action) {
            case "T":
                t = new ToDo(strArr[2]);
                break;
            case "D":
                t = new Deadline(strArr[2], strArr[3]);
                break;
            case "E":
                t = new Event(strArr[2], strArr[3]);
                break;
            default:
                throw new DukeException("Previous Task storage is corrupted. Resetting your task . .");
        }
        if (strArr[1].equals("1")) {
            t.markAsDone();
        }
        list.add(t);
    }

    public TaskList(ArrayList<String> detail) throws DukeException {
        for (String s : detail) {
            loadTask(s);
        }
    }
}*/

   /* public void loadTask(String input) throws DukeException {
        String[] strArr = input.split(" \\| ");
        Task tasks = null;
            if (strArr[0].equals("T")) {
                tasks = new ToDo(strArr[2]);
            } else if (strArr[0].equals("D")) {
                tasks = new Deadline(strArr[2], strArr[3]);
            } else if (strArr[0].equals("E")) {
                tasks = new Event(strArr[2], strArr[3]);
            } else {
                throw new DukeException("Previous Tasks are corrupted. Please resetting your task . .");
            }
            if (strArr[1].equals("1")) {
                tasks.markAsDone();
            }
            list.add(tasks);
        }
    }*/

