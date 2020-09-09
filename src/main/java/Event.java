class Event extends Task {
    protected boolean isDone;
    protected String at;

    public Event(String description, String at){
        super(description);
        this.at = at;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }
    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
