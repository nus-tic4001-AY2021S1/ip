package com.example.duke;

public class Command {
    String taskDescription;

    public Command() {

    }

    public Command(String description) {
        taskDescription = description;
    }

    public String execute(TaskList myTask, Ui ui, Storage storage) {
        //default case where the command is not understood.
        return "OOPS!!! I'm sorry, but I don't know what that means :-( \n"+
                "todo: E.g: todo complete workout \n"+
                "deadline: E.g: deadline Finish Assignment 1 by January 25th\n"+
                "event: E.g: event Attend Apple Conference at Jan 10th to Jan 11th\n"+
                "delete: E.g: delete 2\n"+
                "list: E.g: list  \n"+
                "done: E.g: done 2 \n"+
                "find: E.g: find Return Library books \n"+
                "update: E.g: update 2 Return money \n";
    }

    public boolean isExit() {
        return false;
    }


}
