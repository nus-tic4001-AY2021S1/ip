package com.example.duke;

public class FindCommand extends Command {
    String searchText;

    public FindCommand(String searchText) {
        this.searchText = searchText;
    }

    /*public void execute(TaskList myTask, Ui ui, Storage storage) {
        ui.showMessageToUser("Here are the matching tasks in your list:");
        for (int i = 0; i < myTask.size(); i++) {
            if (myTask.getDescription(i).contains(searchText)) {
                ui.showMessageToUser(myTask.get(i).toString());
            }
        }

    }*/

}
