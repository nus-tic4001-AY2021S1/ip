package com.example.duke;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getStatusIconForFile() {
        return (isDone ? "1" : "0");
    }


    public void markAsDone() {
        this.isDone = true;
    }

    /*public String toString()
    {
        return description;
    }*/

    public abstract String toString();

    public abstract String toWriteFileString();


}
