package com.example.duke;

public class AddEventCommand extends Command {
    String deadline;
    public AddEventCommand(String description, String byDate) {
        super(description);
        deadline=byDate;
    }
    public void execute (TaskList myTask,Ui myUi){
        Event myEvent=new Event(taskDescription, deadline);
        myTask.add(myEvent);
        myUi.showMessageToUser("Event has been added successfully");
    }
}
