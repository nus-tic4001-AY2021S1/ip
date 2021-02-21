package duke;

public class ToDos extends Task {

    protected String memo;

    public ToDos(String description) {
        super(description);
    }

    public ToDos(String description, String memo) {
        super(description);
        this.memo = memo;
    }

    @Override
    public String toString() {

        String toDo = "[T]" + "[" + this.getStatusIcon() + "] " +  this.description;

        if (memo != null) {
            return toDo + "(Memos : " + this.memo + ")";
        } else {
            return toDo;
        }

    }

}
