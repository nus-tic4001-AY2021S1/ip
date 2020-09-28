package com.example.duke;

public class ListCommand extends Command{

    public void execute(TaskList myTask, Ui ui, Storage storage){
        if( myTask.size()<1){
            System.out.println("Sorry, no Tasks to list");
        }
        for (int i = 0; i < myTask.size();i++)
        {
            ui.showMessageToUser(i+1 + myTask.get(i).toString());
            //System.out.println("list command");
        }
    }
}

