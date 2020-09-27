package com.example.duke;

public class AddDeadlineCommand extends Command {
    String deadline;
    public AddDeadlineCommand(String description, String byDate) {
        super(description);
        deadline=byDate;
    }
    public void execute(TaskList myTask, Ui ui){
        Deadline myDeadline=new Deadline(taskDescription, deadline);
        myTask.add(myDeadline);
        ui.showMessageToUser("Deadline has been added successfully");
    }
}
