class Todo extends Task {
    protected boolean isDone;

    //constructor
    public Todo(String description){
        super(description);
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}

