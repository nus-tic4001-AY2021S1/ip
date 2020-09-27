package com.example.duke;

public class DeleteCommand extends Command {
    String index;
    public DeleteCommand(String index){
        this.index=index;
    }
    public void execute(TaskList myTask, Ui ui){
        myTask.remove(Integer.parseInt(index)-1);

    }
}
