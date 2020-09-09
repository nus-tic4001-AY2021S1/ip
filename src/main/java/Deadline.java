class Deadline extends Task {
    protected boolean isDone;
    protected String by;

    //constructor
    public Deadline(String description, String by){
        super(description);
        this.by=by;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }
    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
