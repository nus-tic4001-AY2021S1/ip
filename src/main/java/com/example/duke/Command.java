package com.example.duke;

import java.util.ArrayList;

public class Command {
    String taskDescription;
    public Command(){

    }
    public Command (String description){
        taskDescription=description;
    }

    public void execute (TaskList myTask){

    }
    public boolean  isExit(){
        return false;
    }


}
