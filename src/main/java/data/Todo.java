package data;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String toString() {
        return String.format("[is done ? %s] " + super.toString(), this.completionStatus() ? "Yes" : "No");
    }

    @Override
    public String save() {
        return "T" + " | " + (this.isDone() ? 1 : 0) + " | " + super.save() + System.lineSeparator();
    }

}
