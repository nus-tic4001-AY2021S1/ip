package Duke;

public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String description, char type,String at) {
        super(description,type);
        this.at = at;
    }

    public Event(String description, char type,String at,boolean isDone) {
        super(description,type,isDone);
        this.at = at;
    }
    @Override
    public String toString() {
        return "["+this.type+"] " + this.getStatusIcon() + " " + this.description + " (at: " + at + ")";
    }
    public String printToFIle(){
        int i=0;
        if(this.isDone) i=1;
        return this.type+"|" + i + "|" + this.description + "|" + at;
    }
}
