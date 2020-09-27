package com.example.duke;

public class AddTodoCommand extends Command {

    public AddTodoCommand(String description) {
        super(description);
    }

    public void execute(TaskList myTask, Ui ui){
        Todo myTodo=new Todo(taskDescription);
        myTask.add(myTodo);
        //System.out.println("new todo added, " + taskDescription);
        ui.showMessageToUser("Todo has been added successfully");
    }
}
