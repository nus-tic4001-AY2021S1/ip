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
        return String.format(super.toString());
    }

    @Override
    public String save() {
        return "T" + " | " + (this.isDone() ? 1 : 0) + " | " + super.save() + " | "
                + this.tag + System.lineSeparator();
    }

}
