package com.example.duke;

public class Todo extends Task {
    public Todo (String description){
        super(description);
    }

    public Todo (String description, boolean isDone){
        super(description,isDone);
    }

    /**
     *
     * @return for onscreen display
     */
    @Override
    public String toString(){
        return "[T]" + "["+ super.getStatusIcon()+ "]" + super.description ;
    }

    /**
     *
     * @return for writing to file
     */
    @Override
    public String toWriteFileString(){
        return "T" + "|"+ super.getStatusIconForFile()+ "|" + super.description ;
    }
}
