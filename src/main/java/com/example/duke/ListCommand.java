package com.example.duke;

public class ListCommand extends Command {

    String listOfTasks="";

    @Override
    public String execute(TaskList myTask, Ui ui, Storage storage) {
        if (myTask.size() < 1) {
                System.out.println("Sorry, no Tasks to list");
            return "Sorry, no Tasks to list";
        }
        for (int i = 0; i < myTask.size(); i++) {
            //ui.showMessageToUser(i + 1 + myTask.get(i).toString());
            System.out.println(i + 1 + myTask.get(i).toString());
            listOfTasks=listOfTasks+(i + 1 + myTask.get(i).toString()+"\n");
        }
        return listOfTasks;
    }
}

