package com.example.duke;

import java.util.ArrayList;

public class AddTodoCommand extends Command {

    public AddTodoCommand(String description) {
        super(description);
    }

    public void execute (TaskList myTask){
        Todo myTodo=new Todo(taskDescription);
        myTask.add(myTodo);
        System.out.println("new todo added");

    }
}
