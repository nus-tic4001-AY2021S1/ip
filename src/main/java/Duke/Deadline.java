package Duke;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    public Deadline(String description, char type,String by) {
        super(description,type);
        this.by = by;
    }
    public Deadline(String description, char type,String by,boolean isDone) {
        super(description,type,isDone);
        this.by = by;
    }
    @Override
    public String toString() {
        return "["+this.type+"] " + this.getStatusIcon() + " " + this.description + " (by: " + by + ")";
    }
    public String printToFIle(){
        int i=0;
        if(this.isDone) i=1;
        return this.type+"|" + i + "|" + this.description + "|" + by;
    }
}