package com.example.duke;

public class Deadline extends Task {
    protected String by;

    public Deadline (String description, String by){
        super(description);
        this.by=by;
    }

    public Deadline (String description, String by, boolean isDone){
        super(description,isDone);
        this.by=by;
    }

    /**
     *
     * @return for onscreen display
     */
    @Override
    public String toString(){
        return "[D]" + "["+ super.getStatusIcon()+ "]" + super.description + " (by: " + by + ")";
    }

    /**
     *
     * @return for writing to file
     */
    @Override
    public String toWriteFileString(){
        return "D" + "|"+ super.getStatusIconForFile()+ "|" + super.description + "|" + by;
    }
}
