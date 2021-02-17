package com.example.duke;

public class DeleteCommand extends Command {
    String index;

    public DeleteCommand(String index) {
        this.index = index;
    }

    public void execute(TaskList myTask, Ui ui, Storage storage) {
        myTask.remove(Integer.parseInt(index) - 1);
        ui.showMessageToUser("Task successfully deleted");
        storage.saveFile(myTask);
    }
}
