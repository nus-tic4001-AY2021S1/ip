class Deadline extends Task {
    protected boolean isDone;
    protected String by;

    //constructor
    public Deadline(String description, String by){
        super(description);
        this.by=by;
    }
    //constructor
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //constructor
    public void markAsDone(){
        this.isDone = true;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
    public String getBy(){
        return this.by;
    }
    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
