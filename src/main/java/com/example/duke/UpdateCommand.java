package com.example.duke;

public class UpdateCommand extends Command {
    String index;
    //String newDescription;

    public UpdateCommand (String index, String newDescription){
        this.index=index; this.taskDescription=newDescription;
    }
    public String execute(TaskList myTask, Ui ui, Storage storage) {
        //myTask.remove(Integer.parseInt(index) - 1);
        myTask.editItem(Integer.parseInt(index) - 1,taskDescription);
        //ui.showMessageToUser("Task successfully deleted");
        System.out.println("Task successfully edited");
        storage.saveFile(myTask);
        return "Task description edited";
    }



}
