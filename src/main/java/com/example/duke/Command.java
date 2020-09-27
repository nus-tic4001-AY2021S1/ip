package com.example.duke;

public class Command {
    String taskDescription;
    public Command(){

    }
    public Command (String description){
        taskDescription=description;
    }

    public void execute(TaskList myTask, Ui ui){

    }
    public boolean  isExit(){
        return false;
    }


}
