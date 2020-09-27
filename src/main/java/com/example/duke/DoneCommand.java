package com.example.duke;

public class DoneCommand extends Command {
    String index;
    public DoneCommand (String index){
        this.index = index;
    }
    public void execute(TaskList myTask, Ui ui){
        myTask.markAsDone(Integer.parseInt(index)-1);
        ui.showMessageToUser("Event has been added successfully");
    }
}
