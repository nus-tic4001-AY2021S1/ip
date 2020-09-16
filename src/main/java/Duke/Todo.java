package Duke;

public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }
    public Todo(String description,char type) {
        super(description,type);
    }
    public Todo(String description,char type,boolean isDone) {
        super(description,type,isDone);
    }
    @Override
    public String toString() {
        return "["+this.type+"] " + this.getStatusIcon() + " " + this.description;
    }
    public String printToFIle(){
        return this.type+"|" + (isDone ? "1" : "0")+ "|" + this.description;
    }
}

