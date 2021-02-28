package com.example.duke;

public class DoneCommand extends Command {
    String index;

    public DoneCommand(String index) {
        this.index = index;
    }

    public String execute(TaskList myTask, Ui ui, Storage storage) {
        myTask.markAsDone(Integer.parseInt(index) - 1);
        //ui.showMessageToUser("Marked as done successfully");
        storage.saveFile(myTask);
        return "Marked as done successfully";
    }
}
