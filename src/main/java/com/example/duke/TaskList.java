package com.example.duke;

import java.util.ArrayList;
import java.util.List;


public class TaskList {
    private ArrayList myTasks;
    public TaskList(){
        myTasks=new ArrayList<Task>();
    }
    public TaskList (ArrayList<Task> tasksFromFile) {
        myTasks = new ArrayList<>();
        myTasks.addAll(tasksFromFile);
    }
    public void add(Task myTask){
        myTasks.add(myTask);
    }
}
