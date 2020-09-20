package com.example.duke;

public class Event extends Task{
    protected String by;

    public Event (String description, String by){
        super(description);
        this.by=by;
    }
    /**
     *
     * @return for onscreen display
     */
    @Override
    public String toString(){
        return "[E]" + "["+ super.getStatusIcon()+ "]" + super.description + " (at: " + by + ")";
    }

    /**
     *
     * @return for writing to file
     */
    @Override
    public String toWriteFileString(){
        return "E" + "|"+ super.getStatusIconForFile()+ "|" + super.description + "|" + by;
    }
}
