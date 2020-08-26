package Tasks;

public abstract class Task {
    protected String type;
    protected boolean done = false;
    protected String taskDescription;
    protected String symbol = "[✗]";

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return type + symbol + " " + taskDescription;
    }

    public void setDone(boolean done) {
        this.done = done;
        setSymbol();
    }

    private void setSymbol() {
        if (done) {
            this.symbol = "[✓]";
        } else {
            this.symbol = "[✗]";
        }
    }
}
