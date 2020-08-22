public class Task {
    private boolean done;
    private String taskDescription;
    private String symbol = "[✗]";

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
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
