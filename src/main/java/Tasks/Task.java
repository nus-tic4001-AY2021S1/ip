package Tasks;

public abstract class Task {
    protected String type;
    protected boolean done = false;
    protected String taskDescription;
    protected String symbol = "[✗]";

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString(){
        return type+symbol+" "+taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
        setSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    private void setSymbol() {
        if(done){
            this.symbol = "[✓]";
        }else{
            this.symbol = "[✗]";
        }
    }
}
