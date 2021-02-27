package com.example.duke;

public class Command {
    String taskDescription;

    public Command() {

    }

    public Command(String description) {
        taskDescription = description;
    }

    public String execute(TaskList myTask, Ui ui, Storage storage) {
        return "nothing";

    }

    public boolean isExit() {
        return false;
    }


}
