package tasks;

/**
 * This is extend class inherited from Tasks.
 * adding event task
 */

public class Event extends Tasks {

    public Event(String description, String time){
        super(description, time);
        super.type="[E]";
    }

    public String toString(){

        return type + status +" "+description + "(" + time +")";
    }
}


